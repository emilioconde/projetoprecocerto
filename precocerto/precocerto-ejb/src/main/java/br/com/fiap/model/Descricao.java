package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_descricao database table.
 * 
 */
@Entity
@Table(name="tb_descricao")
public class Descricao implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codDescricao;
	private String dsDescricao;
	private String urlDescricao;
	private ProdutoServico produtoServico;
	private TipoDescricao tipoDescricao;

	public Descricao() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_descricao", unique=true, nullable=false)
	public int getCodDescricao() {
		return this.codDescricao;
	}

	public void setCodDescricao(int codDescricao) {
		this.codDescricao = codDescricao;
	}


	@Column(name="ds_descricao", length=255)
	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}


	@Column(name="url_descricao", length=255)
	public String getUrlDescricao() {
		return this.urlDescricao;
	}

	public void setUrlDescricao(String urlDescricao) {
		this.urlDescricao = urlDescricao;
	}


	//bi-directional many-to-one association to ProdutoServico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_produto_servico", nullable=false)
	public ProdutoServico getProdutoServico() {
		return this.produtoServico;
	}

	public void setProdutoServico(ProdutoServico produtoServico) {
		this.produtoServico = produtoServico;
	}


	//bi-directional many-to-one association to TipoDescricao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_tipo_descricao", nullable=false)
	public TipoDescricao getTipoDescricao() {
		return this.tipoDescricao;
	}

	public void setTipoDescricao(TipoDescricao tipoDescricao) {
		this.tipoDescricao = tipoDescricao;
	}

}