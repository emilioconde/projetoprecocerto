package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tb_endereco database table.
 * 
 */
@Entity
@Table(name="tb_endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codEndereco;
	private String dsBairro;
	private String dsCep;
	private String dsLocalidade;
	private String dsLogradouro;
	private String dsUf;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private int numero;
	private List<EnderecoAnunciante> enderecoAnunciantes;
	private List<EnderecoConsumidor> enderecoConsumidors;

	public Endereco() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_endereco", unique=true, nullable=false)
	public int getCodEndereco() {
		return this.codEndereco;
	}

	public void setCodEndereco(int codEndereco) {
		this.codEndereco = codEndereco;
	}


	@Column(name="ds_bairro", length=50)
	public String getDsBairro() {
		return this.dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}


	@Column(name="ds_cep", length=7)
	public String getDsCep() {
		return this.dsCep;
	}

	public void setDsCep(String dsCep) {
		this.dsCep = dsCep;
	}


	@Column(name="ds_localidade", length=50)
	public String getDsLocalidade() {
		return this.dsLocalidade;
	}

	public void setDsLocalidade(String dsLocalidade) {
		this.dsLocalidade = dsLocalidade;
	}


	@Column(name="ds_logradouro", length=255)
	public String getDsLogradouro() {
		return this.dsLogradouro;
	}

	public void setDsLogradouro(String dsLogradouro) {
		this.dsLogradouro = dsLogradouro;
	}


	@Column(name="ds_uf", length=2)
	public String getDsUf() {
		return this.dsUf;
	}

	public void setDsUf(String dsUf) {
		this.dsUf = dsUf;
	}


	@Column(precision=10, scale=7)
	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}


	@Column(precision=10, scale=7)
	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}


	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	//bi-directional many-to-one association to EnderecoAnunciante
	@OneToMany(mappedBy="endereco")
	public List<EnderecoAnunciante> getEnderecoAnunciantes() {
		return this.enderecoAnunciantes;
	}

	public void setEnderecoAnunciantes(List<EnderecoAnunciante> enderecoAnunciantes) {
		this.enderecoAnunciantes = enderecoAnunciantes;
	}

	public EnderecoAnunciante addEnderecoAnunciante(EnderecoAnunciante enderecoAnunciante) {
		getEnderecoAnunciantes().add(enderecoAnunciante);
		enderecoAnunciante.setEndereco(this);

		return enderecoAnunciante;
	}

	public EnderecoAnunciante removeEnderecoAnunciante(EnderecoAnunciante enderecoAnunciante) {
		getEnderecoAnunciantes().remove(enderecoAnunciante);
		enderecoAnunciante.setEndereco(null);

		return enderecoAnunciante;
	}


	//bi-directional many-to-one association to EnderecoConsumidor
	@OneToMany(mappedBy="endereco")
	public List<EnderecoConsumidor> getEnderecoConsumidors() {
		return this.enderecoConsumidors;
	}

	public void setEnderecoConsumidors(List<EnderecoConsumidor> enderecoConsumidors) {
		this.enderecoConsumidors = enderecoConsumidors;
	}

	public EnderecoConsumidor addEnderecoConsumidor(EnderecoConsumidor enderecoConsumidor) {
		getEnderecoConsumidors().add(enderecoConsumidor);
		enderecoConsumidor.setEndereco(this);

		return enderecoConsumidor;
	}

	public EnderecoConsumidor removeEnderecoConsumidor(EnderecoConsumidor enderecoConsumidor) {
		getEnderecoConsumidors().remove(enderecoConsumidor);
		enderecoConsumidor.setEndereco(null);

		return enderecoConsumidor;
	}

}