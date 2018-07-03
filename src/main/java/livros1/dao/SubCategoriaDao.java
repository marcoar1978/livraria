package livros1.dao;

import java.util.List;

import javax.persistence.*;
import livros1.entity.*;
import java.io.Serializable;

public class SubCategoriaDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<SubCategoria> buscaPorCatId(int catId){
		String jpql = "select s from SubCategoria s where s.categoria.id = "+catId+ " ";
		Query query = manager.createQuery(jpql);
		List<SubCategoria> subCategorias = query.getResultList();
		return subCategorias;
		
		}
	
		
	public SubCategoria buscaPorId(int subCategoriaId) {
		SubCategoria subcategoria = manager.find(SubCategoria.class, subCategoriaId);
		return subcategoria;
		}
	
	

}
