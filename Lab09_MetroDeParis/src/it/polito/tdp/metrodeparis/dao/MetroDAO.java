package it.polito.tdp.metrodeparis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javadocmd.simplelatlng.LatLng;

import it.polito.tdp.metrodeparis.model.Fermata;
import it.polito.tdp.metrodeparis.model.Linea;
import it.polito.tdp.metrodeparis.model.Tratta;

public class MetroDAO {
	private Map<Integer,Fermata> fermate ;
	private Map<Integer, Linea> linee = this.getLinee();

	public Map<Integer, Fermata> getAllFermate() {

		final String sql = "SELECT id_fermata, nome, coordx, coordy FROM fermata ORDER BY nome ASC";
		fermate = new HashMap<Integer, Fermata>();
		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Fermata f = new Fermata(rs.getInt("id_Fermata"), rs.getString("nome"), new LatLng(rs.getDouble("coordx"), rs.getDouble("coordy")));
				fermate.put(f.getIdFermata(),f);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}
		
		return fermate;
	}
	
	
	public Map<Integer, Linea> getLinee(){
		final String sql = "select * FROM linea";
		Map<Integer, Linea> linee = new HashMap<Integer, Linea>();

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Linea l = new Linea (rs.getInt("id_linea"),rs.getString("nome"),rs.getInt("velocita"), rs.getInt("intervallo")); 
				
				linee.put(l.getId(), l);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return linee;
	}
	
	public Map<Integer, Tratta> getTratte(){
		final String sql = "select * FROM connessione";
		Map<Integer,Tratta> tratte = new HashMap<Integer,Tratta>();

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Fermata f1 = (fermate.get(rs.getInt("id_stazP")));
				System.out.println(f1.toString());
				Fermata f2 = (fermate.get(rs.getInt("id_stazA")));
				System.out.println(f2.toString());
				Linea l = linee.get(rs.getInt("id_linea"));
				System.out.println(l.toString());
				Tratta t= new Tratta(f1, f2, l, rs.getInt("id_connessione"));
				tratte.put(t.getIdConnessione(), t);
			}

			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore di connessione al Database.");
		}

		return tratte;
	}
}
