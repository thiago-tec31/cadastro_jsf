package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import exception.UsuarioException;
import model.Usuario;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean extends AbstractMensagem {

	private static final long serialVersionUID = -3679404097368689663L;

	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarios = new ArrayList<>();

	private UsuarioImpl usuarioImpl = new UsuarioImpl();

	public void salvar() {
		try {
			this.usuarioImpl.salvar(this.usuario);
			msgInf("Usuário", "Usuário salvo com sucesso.");
			carregarUsuarios();
			this.usuario = new Usuario();
		} catch (UsuarioException e) {
			msgErrorFatal(e, "Erro inesperado", "Erro ao cadastrar usuário");
		}	
	}
	
	public void editar(Usuario user) {
		this.usuario = user;
	}
	
	public void excluir(Usuario usuario) {
		try {
			this.usuarioImpl.excluir(usuario);
			msgInf("Usuário", "Usuário removido com sucesso.");
			carregarUsuarios();
			this.usuario = new Usuario();
		} catch (UsuarioException e) {
			msgErrorFatal(e, "Erro inesperado", "Erro ao remover usuário");
		}
	}
	
	@PostConstruct
	private void carregarUsuarios() {
		try {
			this.usuarios = this.usuarioImpl.buscarTodos(this.usuario);
		} catch (UsuarioException e) {
			msgErrorFatal(e, "Erro inesperado", "Erro ao consultar os usuários");
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


}
