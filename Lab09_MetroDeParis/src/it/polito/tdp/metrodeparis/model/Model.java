package it.polito.tdp.metrodeparis.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.alg.DijkstraShortestPath;

import it.polito.tdp.metrodeparis.dao.MetroDAO;

public class Model {
	MetroDAO md = new MetroDAO();
	WeightedGraph<Fermata, DefaultWeightedEdge> graph = new SimpleWeightedGraph<Fermata, DefaultWeightedEdge>(DefaultWeightedEdge.class) ;
	List<Tratta> tratte ;
	Map<Integer,Fermata> f = md.getAllFermate();
	public List<Fermata> getFermate(){
		List<Fermata> fermate = new LinkedList<Fermata>(f.values());
		return fermate;
	}
	
	public String createGraph(){
		Graphs.addAllVertices(graph, getFermate());
		tratte = new LinkedList<Tratta>(md.getTratte().values());
		for (Tratta t: tratte){
			DefaultWeightedEdge we = graph.addEdge(t.getFermata1(), t.getFermata2());
			if (we != null){
			graph.setEdgeWeight(we, t.getTempo());
			System.out.println(t.toString());
			}
		}
		return graph.toString();
		
	}

	public String calcolaPercorso(Fermata partenza, Fermata arrivo) {
		this.createGraph();
		DijkstraShortestPath<Fermata, DefaultWeightedEdge> path = new DijkstraShortestPath<Fermata, DefaultWeightedEdge>(graph,partenza,arrivo);
		System.out.println(path.getPath().toString());
		double tempo=0;
		for(DefaultWeightedEdge dwe: path.getPathEdgeList()){
			if(dwe!=null){
				tempo+=md.getTratte().get(dwe).getTempo()+0.5;
				
			}
		}
		System.out.println("TEMPO TOTALE: "+ tempo);
		return null;
	
		
	}
	
	/*public void edgeTraversed(DefaultWeightedEdge e) {

		Fermata f1 = graph.getEdgeSource(e) ;
		Fermata f2 = graph.getEdgeTarget(e) ;
		
		if(f.containsKey(f1) && f.containsKey(f2))
			return ;
		
		if( !f.containsKey(f1) ) {
			// c1 è quello nuovo
			f.put(f1,  f2) ;
		} else {
			// c2 è quello nuovo
			f.put(f2,  f1) ;
		}
	}*/
}
