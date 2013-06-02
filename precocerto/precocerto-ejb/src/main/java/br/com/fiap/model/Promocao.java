package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tb_promocao database table.
 * 
 */
@Entity
@Table(name="tb_promocao")
public class Promocao implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codPromocao;
	private int avaliacao;
	private String dsDescricao;
	private Timestamp dtFinal;
	private Timestamp dtIncial;
	private ProdutoServico produtoServico;
	private Anunciante anunciante;
	private List<PromocaoEndereco> promocaoEnderecos;

	public Promocao() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_promocao", unique=true, nullable=false)
	public int getCodPromocao() {
		return this.codPromocao;
	}

	public void setCodPromocao(int codPromocao) {
		this.codPromocao = codPromocao;
	}


	public int getAvaliacao() {
		return this.avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}


	@Column(name="ds_descricao", length=255)
	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}


	@Column(name="dt_final")
	public Timestamp getDtFinal() {
		return this.dtFinal;
	}

	public void setDtFinal(Timestamp dtFinal) {
		this.dtFinal = dtFinal;
	}


	@Column(name="dt_incial")
	public Timestamp getDtIncial() {
		return this.dtIncial;
	}

	public void setDtIncial(Timestamp dtIncial) {
		this.dtIncial = dtIncial;
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


	//bi-directional many-to-one association to Anunciante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_anunciante", nullable=false)
	public Anunciante getAnunciante() {
		return this.anunciante;
	}

	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}


	//bi-directional many-to-one association to PromocaoEndereco
	@OneToMany(mappedBy="promocao")
	public List<PromocaoEndereco> getPromocaoEnderecos() {
		return this.promocaoEnderecos;
	}

	public void setPromocaoEnderecos(List<PromocaoEndereco> promocaoEnderecos) {
		this.promocaoEnderecos = promocaoEnderecos;
	}

	public PromocaoEndereco addPromocaoEndereco(PromocaoEndereco promocaoEndereco) {
		getPromocaoEnderecos().add(promocaoEndereco);
		promocaoEndereco.setPromocao(this);

		return promocaoEndereco;
	}

	public PromocaoEndereco removePromocaoEndereco(PromocaoEndereco promocaoEndereco) {
		getPromocaoEnderecos().remove(promocaoEndereco);
		promocaoEndereco.setPromocao(null);

		return promocaoEndereco;
	}

}