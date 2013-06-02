package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipo_contato database table.
 * 
 */
@Entity
@Table(name="tb_tipo_contato")
public class TipoContato implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codTipoContato;
	private String dsDescricao;
	private List<Contato> contatos;

	public TipoContato() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tipo_contato", unique=true, nullable=false)
	public int getCodTipoContato() {
		return this.codTipoContato;
	}

	public void setCodTipoContato(int codTipoContato) {
		this.codTipoContato = codTipoContato;
	}


	@Column(name="ds_descricao", length=20)
	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}


	//bi-directional many-to-one association to Contato
	@OneToMany(mappedBy="tipoContato")
	public List<Contato> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Contato addContato(Contato contato) {
		getContatos().add(contato);
		contato.setTipoContato(this);

		return contato;
	}

	public Contato removeContato(Contato contato) {
		getContatos().remove(contato);
		contato.setTipoContato(null);

		return contato;
	}

}