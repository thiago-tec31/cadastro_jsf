package controller;

import java.util.List;

import dao.DaoGeneric;
import dao.IDaoGeneric;
import exception.UsuarioException;
import model.Usuario;

public class UsuarioImpl implements IUsuario {

	private static final long serialVersionUID = 5144477482651746616L;
	
	private static IDaoGeneric<Usuario> IDaoUsuario;
	
	static {
		if (IDaoUsuario == null) {
			IDaoUsuario = new DaoGeneric<Usuario>();
		}
	}

	@Override
	public void salvar(Usuario usuario) throws UsuarioException {
		try {
			IDaoUsuario.merge(usuario);
		} catch (Exception e) {
			throw new UsuarioException(e);
		}
	}

	@Override
	public void excluir(Usuario usuario) throws UsuarioException {
		try {
			IDaoUsuario.deletePorID(usuario);
		} catch (Exception e) {
			throw new UsuarioException(e);
		}
	}

	@Override
	public List<Usuario> buscarTodos(Usuario usuario) throws UsuarioException {
		List<Usuario> retorno;
		try {
			retorno = (List<Usuario>) IDaoUsuario.getListEntidade(usuario); 
		} catch (Exception e) {
			throw new UsuarioException(e);
		}
		
		return retorno;
	}

	

}
