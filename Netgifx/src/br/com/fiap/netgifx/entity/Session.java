
package br.com.fiap.netgifx.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SESSION")
public class Session  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SESSIONID")
	private int id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToMany(mappedBy="session", targetEntity=Gif.class, fetch=FetchType.LAZY)
	private List<Gif> gifs;
	
	
	public Session() {
		super();
		this.gifs = new ArrayList<>();
	}
	public Session(String description) {
		this();
		this.description = description;
	}
	public Session(int id, String description) {
		this(description);
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Gif> getGifs() {
		return gifs;
	}
	public void setGifs(List<Gif> gifs) {
		this.gifs = gifs;
	}
}
