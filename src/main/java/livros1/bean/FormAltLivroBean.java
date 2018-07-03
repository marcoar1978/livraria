package livros1.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.*;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.*;
import javax.inject.*;
import javax.transaction.*;


import livros1.entity.*;
import livros1.dao.*;


@ViewScoped
@Named
public class FormAltLivroBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String livroId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("livroId");
	private int livroId2 = Integer.parseInt(this.livroId);
	private Livro livro;
	private String msg;
	
	
	
	@Transactional
	public void alterar() {
		dao.atualiza(this.livro);
		this.msg = "Registro do livro atualizado";
		
		
		}
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public int getLivroId2() {
		return livroId2;
	}

	public void setLivroId2(int livroId2) {
		this.livroId2 = livroId2;
	}

	@Inject
	private LivroDao dao;
	
	@PostConstruct
	public void init() {
		//this.livroId2 = Integer.parseInt(this.livroId);
		this.livro = dao.buscaPorId(this.livroId2);
		
		}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getLivroId() {
		return livroId;
	}

	public void setLivroId(String livroId) {
		this.livroId = livroId;
	}
	
	
	
	
	
	
	
	
}
