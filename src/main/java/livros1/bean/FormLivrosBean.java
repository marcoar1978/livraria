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
public class FormLivrosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Livro livro = new Livro();
	private String msg = "";
	private String msg2 = "";
	private List<Categoria> categorias;
	private List<SubCategoria> subCategorias;
	private int categoriaId;
	private String subCategoriaId;
	private int subCategoriaId2;
		
	@Inject
	private LivroDao dao;
	
	@Inject
	private CategoriaDao categoriaDao;
	
	@Inject
	private SubCategoriaDao subCategoriaDao;
	
	
	@PostConstruct
	public void init() {
		categorias = this.categoriaDao.lista();
		//subCategorias = this.subCategoriaDao.buscaPorCatId(1);
		}
	
	
	
	@Transactional
	public void salvar() {
		
		
		Categoria categoria = categoriaDao.buscaPorId(categoriaId);
		this.livro.setCategoria(categoria);
		
		SubCategoria subCategoria = subCategoriaDao.buscaPorId(subCategoriaId2);
		this.livro.setSubCategoria(subCategoria);
		
		dao.incluir(livro);
		//System.out.println("Livro \"+this.livro.getTitulo()+\" salvo com sucesso");
		//this.subCategoriaId2 = (int) this.subCategoriaId;
		this.msg = "Livro "+this.livro.getTitulo()+" salvo com sucesso ";
		this.livro = new Livro();
		}
	
	
	public void processaSubCategorias(AjaxBehaviorEvent event) {
		
		subCategorias = this.subCategoriaDao.buscaPorCatId(this.categoriaId);
		this.msg = "Categoria: "+this.categoriaId;
		//return "Ajax "+categoriaId;
	}
	
	public void processaSubCategorias2(AjaxBehaviorEvent event) {
		
		
		
		try {
			this.subCategoriaId2 = Integer.parseInt(this.subCategoriaId);
			this.msg2 = "Sub-categoria: "+this.subCategoriaId2;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		}


	public List<Categoria> getCategorias() {
		return categorias;
	}



	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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

	public int getCategoriaId() {
		return categoriaId;
	}




	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}




	public String getSubCategoriaId() {
		return subCategoriaId;
	}




	public void setSubCategoriaId(String subCategoriaId) {
		this.subCategoriaId = subCategoriaId;
	}
	
	public List<SubCategoria> getSubCategorias() {
		return subCategorias;
	}


	public void setSubCategorias(List<SubCategoria> subCategorias) {
		this.subCategorias = subCategorias;
	}

	public String getMsg2() {
		return msg2;
	}


	public void setMsg2(String msg2) {
		this.msg2 = msg2;
	}

	
}
