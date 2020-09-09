package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class AbstractMensagem implements Serializable{
	
	private static final long serialVersionUID = -2693730261654447294L;

	protected void msgInf(String titulo, String descricao){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, descricao));
	}
	
	protected void msgAlert(String titulo, String descricao){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, descricao));
	}
	
	protected void msgError(String titulo, String descricao){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, descricao));
	}
	
	protected void msgErrorFatal(Exception e,  String titulo, String descricao){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, descricao));
	}
}
