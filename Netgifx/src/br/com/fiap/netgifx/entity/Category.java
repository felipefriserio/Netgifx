package br.com.fiap.netgifx.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CATEGORYID")
	private int id;
	
	@Column(name="NAME")
	private String nome;
	
	@ManyToMany(mappedBy="category", targetEntity=Gif.class, fetch=FetchType.LAZY)
	private List<Gif> gifs;

	
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
}
