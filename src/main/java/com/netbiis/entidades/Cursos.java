package com.netbiis.entidades;
// Generated 7 de nov. de 2022 23:42:42 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cursos generated by hbm2java
 */
@Entity
@Table(name = "cursos")
public class Cursos implements java.io.Serializable {

	private Integer idCurso;
	private String nome;
	private String valor;
	private String url;
	
	public Cursos() {
	}

	public Cursos(String nome, String valor, String url) {
		this.nome = nome;
		this.valor = valor;
		this.url = url;
	}

	public Cursos(Integer idCurso, String nome, String valor, String url) {
		this.idCurso = idCurso;
		this.nome = nome;
		this.valor = valor;
		this.url = url;		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_curso", unique = true, nullable = false)
	public Integer getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	@Column(name = "nome", nullable = false, length = 80)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "valor", nullable = false, length = 20)
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Column(name = "url", nullable = false, length = 80)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
