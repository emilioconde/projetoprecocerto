package br.com.fiap.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipo_usuario database table.
 * 
 */
@Entity
@Table(name="tb_tipo_usuario")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codTipoUsuario;
	private String dsDescricao;
	private List<Usuario> usuarios;

	public TipoUsuario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tipo_usuario", unique=true, nullable=false)
	public int getCodTipoUsuario() {
		return this.codTipoUsuario;
	}

	public void setCodTipoUsuario(int codTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
	}


	@Column(name="ds_descricao", length=20)
	public String getDsDescricao() {
		return this.dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}


	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipoUsuario")
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipoUsuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipoUsuario(null);

		return usuario;
	}

}