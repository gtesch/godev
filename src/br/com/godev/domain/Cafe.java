package br.com.godev.domain;

public class Cafe {
	
	private int id; 
	private String cafe;
	private String horario;
	
	
	public String getCafe() {
		return cafe;
	}
	public void setCafe(String cafe) {
		this.cafe = cafe;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Cafe() {
		
	}

}
