package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_contato database table.
 * 
 */
@Entity
@Table(name="tb_contato")
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;
	private ContatoPK id;
	private int ddd;
	private int numero;
	private Anunciante anunciante;
	private TipoContato tipoContato;

	public Contato() {
	}


	@EmbeddedId
	public ContatoPK getId() {
		return this.id;
	}

	public void setId(ContatoPK id) {
		this.id = id;
	}


	public int getDdd() {
		return this.ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}


	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	//bi-directional many-to-one association to Anunciante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_anunciante", nullable=false, insertable=false, updatable=false)
	public Anunciante getAnunciante() {
		return this.anunciante;
	}

	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}


	//bi-directional many-to-one association to TipoContato
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_contato", nullable=false)
	public TipoContato getTipoContato() {
		return this.tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

}