package livros1.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.*;
import javax.faces.view.*;
import javax.inject.*;
import javax.transaction.*;


import livros1.entity.*;
import livros1.dao.*;


@ViewScoped
@Named
public class Relatorio1Bean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	


	private List<Categoria> categorias;
	private List<Livro> livros;
	private String msg = "Qde registros:xx";
	
	
	@Inject
	private CategoriaDao categoriaDao;
	
	@Inject
	private LivroDao livroDao;
	
	
	@PostConstruct
	public void init() {
		this.categorias = this.categoriaDao.lista();
		this.msg = "Qde registros "+this.categorias.size();
		}
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	public List<Livro> getLivros() {
		return livros;
	}


	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}


	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}


	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}


	public LivroDao getLivroDao() {
		return livroDao;
	}


	public void setLivroDao(LivroDao livroDao) {
		this.livroDao = livroDao;
	}

}
