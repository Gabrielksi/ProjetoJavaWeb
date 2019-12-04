package controler.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.dao.UsuarioDAO;
import model.entity.Usuario;


@ManagedBean
@ViewScoped
public class UsuarioMB {
	
	private Usuario usuario = new Usuario();
	private UsuarioDAO usuariodao = new UsuarioDAO();
	
	public String envia() {
		usuario = usuariodao.getUsuario(usuario.getLogin(), usuario.getSenha());
		if(usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado","ERRO Login"));
			return null;
		}else {
			return "/main";
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
