package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_consumidor database table.
 * 
 */
@Entity
@Table(name="tb_consumidor")
public class Consumidor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codConsumidor;	
	private String dsNome;
	private Usuario usuario;
	private List<EnderecoConsumidor> enderecoConsumidors;

	public Consumidor() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_consumidor", unique=true, nullable=false)
	public int getCodConsumidor() {
		return this.codConsumidor;
	}

	public void setCodConsumidor(int codConsumidor) {
		this.codConsumidor = codConsumidor;
	}

	@Column(name="ds_nome", length=255)
	public String getDsNome() {
		return this.dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}


	//bi-directional many-to-one association to Usuario
	@OneToOne
	@JoinColumn(name="cod_usuario", nullable=false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to EnderecoConsumidor
	@OneToMany(mappedBy="consumidor")
	public List<EnderecoConsumidor> getEnderecoConsumidors() {
		return this.enderecoConsumidors;
	}

	public void setEnderecoConsumidors(List<EnderecoConsumidor> enderecoConsumidors) {
		this.enderecoConsumidors = enderecoConsumidors;
	}

	public EnderecoConsumidor addEnderecoConsumidor(EnderecoConsumidor enderecoConsumidor) {
		getEnderecoConsumidors().add(enderecoConsumidor);
		enderecoConsumidor.setConsumidor(this);

		return enderecoConsumidor;
	}

	public EnderecoConsumidor removeEnderecoConsumidor(EnderecoConsumidor enderecoConsumidor) {
		getEnderecoConsumidors().remove(enderecoConsumidor);
		enderecoConsumidor.setConsumidor(null);

		return enderecoConsumidor;
	}

}