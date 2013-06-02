package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_usuario database table.
 * 
 */
@Entity
@Table(name="tb_usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codUsuario;
	private String dsEmail;
	private String senha;
	private List<Anunciante> anunciantes;
	private List<Consumidor> consumidors;
	private TipoUsuario tipoUsuario;

	public Usuario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_usuario", unique=true, nullable=false)
	public int getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}


	@Column(name="ds_email", length=255)
	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}


	@Column(length=255)
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	//bi-directional many-to-one association to Anunciante
	@OneToMany(mappedBy="usuario")
	public List<Anunciante> getAnunciantes() {
		return this.anunciantes;
	}

	public void setAnunciantes(List<Anunciante> anunciantes) {
		this.anunciantes = anunciantes;
	}

	public Anunciante addAnunciante(Anunciante anunciante) {
		getAnunciantes().add(anunciante);
		anunciante.setUsuario(this);

		return anunciante;
	}

	public Anunciante removeAnunciante(Anunciante anunciante) {
		getAnunciantes().remove(anunciante);
		anunciante.setUsuario(null);

		return anunciante;
	}


	//bi-directional many-to-one association to Consumidor
	@OneToMany(mappedBy="usuario")
	public List<Consumidor> getConsumidors() {
		return this.consumidors;
	}

	public void setConsumidors(List<Consumidor> consumidors) {
		this.consumidors = consumidors;
	}

	public Consumidor addConsumidor(Consumidor consumidor) {
		getConsumidors().add(consumidor);
		consumidor.setUsuario(this);

		return consumidor;
	}

	public Consumidor removeConsumidor(Consumidor consumidor) {
		getConsumidors().remove(consumidor);
		consumidor.setUsuario(null);

		return consumidor;
	}


	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_tipo_usuario", nullable=false)
	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}