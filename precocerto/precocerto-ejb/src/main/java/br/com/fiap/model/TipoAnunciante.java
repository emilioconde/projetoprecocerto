package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipo_anunciante database table.
 * 
 */
@Entity
@Table(name="tb_tipo_anunciante")
public class TipoAnunciante implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codTipoAnunciante;
	private String dsDescricao;
	private List<Anunciante> anunciantes;

	public TipoAnunciante() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tipo_anunciante", unique=true, nullable=false)
	public int getCodTipoAnunciante() {
		return this.codTipoAnunciante;
	}

	public void setCodTipoAnunciante(int codTipoAnunciante) {
		this.codTipoAnunciante = codTipoAnunciante;
	}


	@Column(name="ds_descricao", length=20)
	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}


	//bi-directional many-to-one association to Anunciante
	@OneToMany(mappedBy="tipoAnunciante")
	public List<Anunciante> getAnunciantes() {
		return this.anunciantes;
	}

	public void setAnunciantes(List<Anunciante> anunciantes) {
		this.anunciantes = anunciantes;
	}

	public Anunciante addAnunciante(Anunciante anunciante) {
		getAnunciantes().add(anunciante);
		anunciante.setTipoAnunciante(this);

		return anunciante;
	}

	public Anunciante removeAnunciante(Anunciante anunciante) {
		getAnunciantes().remove(anunciante);
		anunciante.setTipoAnunciante(null);

		return anunciante;
	}

}