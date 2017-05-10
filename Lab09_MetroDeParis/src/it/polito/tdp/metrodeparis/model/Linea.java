package it.polito.tdp.metrodeparis.model;

public class Linea {
	private int id;
	private String nome;
	private int velocita;
	private int intervallo;
	
	public Linea(int id, String nome, int velocita, int intervallo) {
		super();
		this.id = id;
		this.nome = nome;
		this.velocita = velocita;
		this.intervallo = intervallo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the velocita
	 */
	public int getVelocita() {
		return velocita;
	}

	/**
	 * @param velocita the velocita to set
	 */
	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}

	/**
	 * @return the intervallo
	 */
	public int getIntervallo() {
		return intervallo;
	}

	/**
	 * @param intervallo the intervallo to set
	 */
	public void setIntervallo(int intervallo) {
		this.intervallo = intervallo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Linea [id=" + id + ", nome=" + nome + ", velocita=" + velocita + ", intervallo=" + intervallo + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Linea other = (Linea) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
