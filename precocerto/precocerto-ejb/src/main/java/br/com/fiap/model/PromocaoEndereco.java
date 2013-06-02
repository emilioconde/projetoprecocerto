package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_promocao_endereco database table.
 * 
 */
@Entity
@Table(name="tb_promocao_endereco")
public class PromocaoEndereco implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codPromocaoEndereco;
	private EnderecoAnunciante enderecoAnunciante;
	private Promocao promocao;

	public PromocaoEndereco() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_promocao_endereco", unique=true, nullable=false)
	public int getCodPromocaoEndereco() {
		return this.codPromocaoEndereco;
	}

	public void setCodPromocaoEndereco(int codPromocaoEndereco) {
		this.codPromocaoEndereco = codPromocaoEndereco;
	}


	//bi-directional many-to-one association to EnderecoAnunciante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_endereco_anunciante")
	public EnderecoAnunciante getEnderecoAnunciante() {
		return this.enderecoAnunciante;
	}

	public void setEnderecoAnunciante(EnderecoAnunciante enderecoAnunciante) {
		this.enderecoAnunciante = enderecoAnunciante;
	}


	//bi-directional many-to-one association to Promocao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_promocao")
	public Promocao getPromocao() {
		return this.promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}

}