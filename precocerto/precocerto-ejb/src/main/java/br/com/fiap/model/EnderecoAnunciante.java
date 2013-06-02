package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_endereco_anunciante database table.
 * 
 */
@Entity
@Table(name="tb_endereco_anunciante")
public class EnderecoAnunciante implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codEnderecoAnunciante;
	private Anunciante anunciante;
	private Endereco endereco;
	private List<PromocaoEndereco> promocaoEnderecos;

	public EnderecoAnunciante() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_endereco_anunciante", unique=true, nullable=false)
	public int getCodEnderecoAnunciante() {
		return this.codEnderecoAnunciante;
	}

	public void setCodEnderecoAnunciante(int codEnderecoAnunciante) {
		this.codEnderecoAnunciante = codEnderecoAnunciante;
	}


	//bi-directional many-to-one association to Anunciante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_anunciante")
	public Anunciante getAnunciante() {
		return this.anunciante;
	}

	public void setAnunciante(Anunciante anunciante) {
		this.anunciante = anunciante;
	}


	//bi-directional many-to-one association to Endereco
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_endereco")
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	//bi-directional many-to-one association to PromocaoEndereco
	@OneToMany(mappedBy="enderecoAnunciante")
	public List<PromocaoEndereco> getPromocaoEnderecos() {
		return this.promocaoEnderecos;
	}

	public void setPromocaoEnderecos(List<PromocaoEndereco> promocaoEnderecos) {
		this.promocaoEnderecos = promocaoEnderecos;
	}

	public PromocaoEndereco addPromocaoEndereco(PromocaoEndereco promocaoEndereco) {
		getPromocaoEnderecos().add(promocaoEndereco);
		promocaoEndereco.setEnderecoAnunciante(this);

		return promocaoEndereco;
	}

	public PromocaoEndereco removePromocaoEndereco(PromocaoEndereco promocaoEndereco) {
		getPromocaoEnderecos().remove(promocaoEndereco);
		promocaoEndereco.setEnderecoAnunciante(null);

		return promocaoEndereco;
	}

}