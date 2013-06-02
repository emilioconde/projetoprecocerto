package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipo_produto_servico database table.
 * 
 */
@Entity
@Table(name="tb_tipo_produto_servico")
public class TipoProdutoServico implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codTipoProduto;
	private int dsDescricao;
	private String dsUnidade;
	private List<ProdutoServico> produtoServicos;

	public TipoProdutoServico() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tipo_produto", unique=true, nullable=false)
	public int getCodTipoProduto() {
		return this.codTipoProduto;
	}

	public void setCodTipoProduto(int codTipoProduto) {
		this.codTipoProduto = codTipoProduto;
	}


	@Column(name="ds_descricao")
	public int getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(int dsDescricao) {
		this.dsDescricao = dsDescricao;
	}


	@Column(name="ds_unidade", length=20)
	public String getDsUnidade() {
		return this.dsUnidade;
	}

	public void setDsUnidade(String dsUnidade) {
		this.dsUnidade = dsUnidade;
	}


	//bi-directional many-to-one association to ProdutoServico
	@OneToMany(mappedBy="tipoProdutoServico")
	public List<ProdutoServico> getProdutoServicos() {
		return this.produtoServicos;
	}

	public void setProdutoServicos(List<ProdutoServico> produtoServicos) {
		this.produtoServicos = produtoServicos;
	}

	public ProdutoServico addProdutoServico(ProdutoServico produtoServico) {
		getProdutoServicos().add(produtoServico);
		produtoServico.setTipoProdutoServico(this);

		return produtoServico;
	}

	public ProdutoServico removeProdutoServico(ProdutoServico produtoServico) {
		getProdutoServicos().remove(produtoServico);
		produtoServico.setTipoProdutoServico(null);

		return produtoServico;
	}

}