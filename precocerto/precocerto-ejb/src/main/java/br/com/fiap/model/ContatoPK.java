package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_contato database table.
 * 
 */
@Embeddable
public class ContatoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int codContato;
	private int codAnunciante;

	public ContatoPK() {
	}

	@Column(name="cod_contato", unique=true, nullable=false)
	public int getCodContato() {
		return this.codContato;
	}
	public void setCodContato(int codContato) {
		this.codContato = codContato;
	}

	@Column(name="cod_anunciante", unique=true, nullable=false)
	public int getCodAnunciante() {
		return this.codAnunciante;
	}
	public void setCodAnunciante(int codAnunciante) {
		this.codAnunciante = codAnunciante;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ContatoPK)) {
			return false;
		}
		ContatoPK castOther = (ContatoPK)other;
		return 
			(this.codContato == castOther.codContato)
			&& (this.codAnunciante == castOther.codAnunciante);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codContato;
		hash = hash * prime + this.codAnunciante;
		
		return hash;
	}
}