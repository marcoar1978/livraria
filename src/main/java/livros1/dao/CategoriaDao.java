package livros1.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import livros1.entity.*;

public class CategoriaDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Categoria> lista(){
		String jpql = "select c from Categoria c";
		Query query = manager.createQuery(jpql);
		List<Categoria> categorias =  query.getResultList();
		
		return categorias;
		}
	
	public Categoria buscaPorId(Integer categoriaId) {
		Categoria  categoria = manager.find(Categoria.class, categoriaId);
		return categoria;
		
		
		}

}
