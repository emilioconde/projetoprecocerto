package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_endereco_consumidor database table.
 * 
 */
@Entity
@Table(name="tb_endereco_consumidor")
public class EnderecoConsumidor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codEnderecoConsumidor;
	private Consumidor consumidor;
	private Endereco endereco;

	public EnderecoConsumidor() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_endereco_consumidor", unique=true, nullable=false)
	public int getCodEnderecoConsumidor() {
		return this.codEnderecoConsumidor;
	}

	public void setCodEnderecoConsumidor(int codEnderecoConsumidor) {
		this.codEnderecoConsumidor = codEnderecoConsumidor;
	}


	//bi-directional many-to-one association to Consumidor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_consumidor")
	public Consumidor getConsumidor() {
		return this.consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
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

}