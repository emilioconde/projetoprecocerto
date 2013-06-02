package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tb_anunciante database table.
 * 
 */
@Entity
@Table(name="tb_anunciante")
public class Anunciante implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codAnunciante;	
	private String dsNome;
	private String dsUrl;
	private Timestamp dtCadastro;
	private Usuario usuario;
	private TipoAnunciante tipoAnunciante;
	private List<Contato> contatos;
	private List<EnderecoAnunciante> enderecoAnunciantes;
	private List<Promocao> promocaos;

	public Anunciante() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_anunciante", unique=true, nullable=false)
	public int getCodAnunciante() {
		return this.codAnunciante;
	}

	public void setCodAnunciante(int codAnunciante) {
		this.codAnunciante = codAnunciante;
	}
	
	@Column(name="ds_nome", length=255)
	public String getDsNome() {
		return this.dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
	}


	@Column(name="ds_url", length=255)
	public String getDsUrl() {
		return this.dsUrl;
	}

	public void setDsUrl(String dsUrl) {
		this.dsUrl = dsUrl;
	}


	@Column(name="dt_cadastro")
	public Timestamp getDtCadastro() {
		return this.dtCadastro;
	}

	public void setDtCadastro(Timestamp dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cod_usuario", nullable=false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to TipoAnunciante
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_anunciante", nullable=false)
	public TipoAnunciante getTipoAnunciante() {
		return this.tipoAnunciante;
	}

	public void setTipoAnunciante(TipoAnunciante tipoAnunciante) {
		this.tipoAnunciante = tipoAnunciante;
	}


	//bi-directional many-to-one association to Contato
	@OneToMany(mappedBy="anunciante")
	public List<Contato> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Contato addContato(Contato contato) {
		getContatos().add(contato);
		contato.setAnunciante(this);

		return contato;
	}

	public Contato removeContato(Contato contato) {
		getContatos().remove(contato);
		contato.setAnunciante(null);

		return contato;
	}


	//bi-directional many-to-one association to EnderecoAnunciante
	@OneToMany(mappedBy="anunciante")
	public List<EnderecoAnunciante> getEnderecoAnunciantes() {
		return this.enderecoAnunciantes;
	}

	public void setEnderecoAnunciantes(List<EnderecoAnunciante> enderecoAnunciantes) {
		this.enderecoAnunciantes = enderecoAnunciantes;
	}

	public EnderecoAnunciante addEnderecoAnunciante(EnderecoAnunciante enderecoAnunciante) {
		getEnderecoAnunciantes().add(enderecoAnunciante);
		enderecoAnunciante.setAnunciante(this);

		return enderecoAnunciante;
	}

	public EnderecoAnunciante removeEnderecoAnunciante(EnderecoAnunciante enderecoAnunciante) {
		getEnderecoAnunciantes().remove(enderecoAnunciante);
		enderecoAnunciante.setAnunciante(null);

		return enderecoAnunciante;
	}


	//bi-directional many-to-one association to Promocao
	@OneToMany(mappedBy="anunciante")
	public List<Promocao> getPromocaos() {
		return this.promocaos;
	}

	public void setPromocaos(List<Promocao> promocaos) {
		this.promocaos = promocaos;
	}

	public Promocao addPromocao(Promocao promocao) {
		getPromocaos().add(promocao);
		promocao.setAnunciante(this);

		return promocao;
	}

	public Promocao removePromocao(Promocao promocao) {
		getPromocaos().remove(promocao);
		promocao.setAnunciante(null);

		return promocao;
	}

}