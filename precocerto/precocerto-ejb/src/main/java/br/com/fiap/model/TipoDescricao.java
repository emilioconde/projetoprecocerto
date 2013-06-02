package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipo_descricao database table.
 * 
 */
@Entity
@Table(name="tb_tipo_descricao")
public class TipoDescricao implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codTipoDescricao;
	private String dsDescricao;
	private List<Descricao> descricaos;

	public TipoDescricao() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tipo_descricao", unique=true, nullable=false)
	public int getCodTipoDescricao() {
		return this.codTipoDescricao;
	}

	public void setCodTipoDescricao(int codTipoDescricao) {
		this.codTipoDescricao = codTipoDescricao;
	}


	@Column(name="ds_descricao", length=255)
	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}


	//bi-directional many-to-one association to Descricao
	@OneToMany(mappedBy="tipoDescricao")
	public List<Descricao> getDescricaos() {
		return this.descricaos;
	}

	public void setDescricaos(List<Descricao> descricaos) {
		this.descricaos = descricaos;
	}

	public Descricao addDescricao(Descricao descricao) {
		getDescricaos().add(descricao);
		descricao.setTipoDescricao(this);

		return descricao;
	}

	public Descricao removeDescricao(Descricao descricao) {
		getDescricaos().remove(descricao);
		descricao.setTipoDescricao(null);

		return descricao;
	}

}