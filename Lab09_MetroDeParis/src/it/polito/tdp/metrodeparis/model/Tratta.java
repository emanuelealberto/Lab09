package it.polito.tdp.metrodeparis.model;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

public class Tratta {
	private Fermata fermata1;
	private Fermata fermata2;
	private Linea linea;
	private int idConnessione;
	private double tempo;
	
	public Tratta(Fermata fermata1, Fermata fermata2, Linea linea, int idConnessione) {
		super();
		this.fermata1 = fermata1;
		this.fermata2 = fermata2;
		this.linea = linea;
		this.idConnessione = idConnessione;
		tempo = calcolaTempo();
	}

	private double calcolaTempo() {
		double distanza = LatLngTool.distance(fermata1.getCoords(),fermata2.getCoords(), LengthUnit. KILOMETER);
		double tempo = distanza/linea.getVelocita();
		return tempo*60;
	}

	/**
	 * @return the fermata1
	 */
	public Fermata getFermata1() {
		return fermata1;
	}

	/**
	 * @param fermata1 the fermata1 to set
	 */
	public void setFermata1(Fermata fermata1) {
		this.fermata1 = fermata1;
	}

	/**
	 * @return the fermata2
	 */
	public Fermata getFermata2() {
		return fermata2;
	}

	/**
	 * @param fermata2 the fermata2 to set
	 */
	public void setFermata2(Fermata fermata2) {
		this.fermata2 = fermata2;
	}

	/**
	 * @return the linea
	 */
	public Linea getLinea() {
		return linea;
	}

	/**
	 * @param linea the linea to set
	 */
	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	/**
	 * @return the idConnessione
	 */
	public int getIdConnessione() {
		return idConnessione;
	}

	/**
	 * @param idConnessione the idConnessione to set
	 */
	public void setIdConnessione(int idConnessione) {
		this.idConnessione = idConnessione;
	}

	/**
	 * @return the tempo
	 */
	public double getTempo() {
		return tempo;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tratta [fermata1=" + fermata1 + ", fermata2=" + fermata2 + ", linea=" + linea + ", idConnessione="
				+ idConnessione + ", tempo=" + tempo + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fermata1 == null) ? 0 : fermata1.hashCode());
		result = prime * result + ((fermata2 == null) ? 0 : fermata2.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tratta other = (Tratta) obj;
		if (fermata1 == null) {
			if (other.fermata1 != null)
				return false;
		} else if (!fermata1.equals(other.fermata1))
			return false;
		if (fermata2 == null) {
			if (other.fermata2 != null)
				return false;
		} else if (!fermata2.equals(other.fermata2))
			return false;
		return true;
	}
	
	
	
	
	
}
