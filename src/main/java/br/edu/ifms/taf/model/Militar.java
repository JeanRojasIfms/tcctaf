package br.edu.ifms.taf.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Militar implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String identidade;
	private String cpf;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pelotao_id")
	private Pelotao pelotao;

	private Companhia companhia;
	
	public Militar() {
		// TODO Auto-generated constructor stub
	}

	

	public Militar(Integer id, String nome, String identidade, String cpf, Pelotao pelotao, Companhia companhia) {
		super();
		this.id = id;
		this.nome = nome;
		this.identidade = identidade;
		this.cpf = cpf;
		this.pelotao = pelotao;
		this.companhia = companhia;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pelotao getPelotao() {
		return pelotao;
	}

	public void setPelotao(Pelotao pelotao) {
		this.pelotao = pelotao;
	}
	
	

	public Companhia getCompanhia() {
		return companhia;
	}



	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Militar other = (Militar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
