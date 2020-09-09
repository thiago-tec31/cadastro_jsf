package dao;

import java.io.Serializable;
import java.util.List;

public interface IDaoGeneric<E> extends Serializable {
	
	public E merge(E entidade);
	
	public void deletePorID(E entidade);
	
	public List<E> getListEntidade(E entidade);
	
}
