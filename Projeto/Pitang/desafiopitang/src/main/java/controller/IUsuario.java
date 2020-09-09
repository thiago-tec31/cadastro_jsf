package controller;

import java.io.Serializable;
import java.util.List;

import exception.UsuarioException;
import model.Usuario;

public interface IUsuario extends Serializable {
	public void salvar(Usuario usuario) throws UsuarioException;

	public void excluir(Usuario usuario) throws UsuarioException;

	public List<Usuario> buscarTodos(Usuario usuario) throws UsuarioException;
}
