package org.java.spring.db.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false, unique = true)
	private String descrizione;
	@Column(nullable = false, unique = false)
	private double prezzo;

	@Column(unique = true)
	private String foto;

	public Pizza() {
	}

	public Pizza(String nome, String descrizione, double prezzo, String foto) {
		setNome(nome);
		setDescrizione(descrizione);
		setPrezzo(prezzo);
		setFoto(foto);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "[" + getId() + "]" + getNome() + " - " 
				+ getDescrizione() + " - " + getPrezzo() + " - " + getFoto();
		
	}

}