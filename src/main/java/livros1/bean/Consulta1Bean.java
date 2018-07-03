package livros1.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.*;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.*;
import javax.inject.*;
import javax.transaction.*;


import livros1.entity.*;
import livros1.dao.*;

@ViewScoped
@Named
public class Consulta1Bean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LivroDao dao;
	
	@Inject
	private CategoriaDao categoriaDao;
	
	@Inject
	private SubCategoriaDao subCategoriaDao;
	
	
	private Livro livro = new Livro();
	private String msg;
	private String tituloBusca;
	private List<Livro> livros;
	boolean panel = true;
	
	
	public void consultar(AjaxBehaviorEvent event) {
		this.livros = dao.listaPorTitulo(tituloBusca);
		
		if(this.livros.size() > 0) {
			this.panel = true;
			}
		else {
			this.panel = false;
			}
		
		this.msg = this.livros.size()+" registro(s)";
		
	}
	
	@Transactional
	public void deletarLivro(Livro livroDel) {
		
		dao.remove(livroDel);
		
		this.livros = dao.listaPorTitulo(tituloBusca);
		}
	
	
	public String getTituloBusca() {
		return tituloBusca;
	}



	public void setTituloBusca(String tituloBusca) {
		this.tituloBusca = tituloBusca;
	}



	public List<Livro> getLivros() {
		return livros;
	}



	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}



	
	
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public boolean isPanel() {
		return panel;
	}



	public void setPanel(boolean panel) {
		this.panel = panel;
	}

}
