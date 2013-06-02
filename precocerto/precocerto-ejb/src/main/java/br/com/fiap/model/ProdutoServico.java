package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_produto_servico database table.
 * 
 */
@Entity
@Table(name="tb_produto_servico")
public class ProdutoServico implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String dsDescricao;
	private String dsNome;
	private String unidade;
	private List<Descricao> descricaos;
	private TipoProdutoServico tipoProdutoServico;
	private List<Promocao> promocaos;

	public ProdutoServico() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	@Column(name="ds_descricao", length=255)
	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}


	@Column(name="ds_nome", length=255)
	public String getDsNome() {
		return this.dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}


	@Column(length=20)
	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}


	//bi-directional many-to-one association to Descricao
	@OneToMany(mappedBy="produtoServico")
	public List<Descricao> getDescricaos() {
		return this.descricaos;
	}

	public void setDescricaos(List<Descricao> descricaos) {
		this.descricaos = descricaos;
	}

	public Descricao addDescricao(Descricao descricao) {
		getDescricaos().add(descricao);
		descricao.setProdutoServico(this);

		return descricao;
	}

	public Descricao removeDescricao(Descricao descricao) {
		getDescricaos().remove(descricao);
		descricao.setProdutoServico(null);

		return descricao;
	}


	//bi-directional many-to-one association to TipoProdutoServico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_tipo_produto_servico", nullable=false)
	public TipoProdutoServico getTipoProdutoServico() {
		return this.tipoProdutoServico;
	}

	public void setTipoProdutoServico(TipoProdutoServico tipoProdutoServico) {
		this.tipoProdutoServico = tipoProdutoServico;
	}


	//bi-directional many-to-one association to Promocao
	@OneToMany(mappedBy="produtoServico")
	public List<Promocao> getPromocaos() {
		return this.promocaos;
	}

	public void setPromocaos(List<Promocao> promocaos) {
		this.promocaos = promocaos;
	}

	public Promocao addPromocao(Promocao promocao) {
		getPromocaos().add(promocao);
		promocao.setProdutoServico(this);

		return promocao;
	}

	public Promocao removePromocao(Promocao promocao) {
		getPromocaos().remove(promocao);
		promocao.setProdutoServico(null);

		return promocao;
	}

}