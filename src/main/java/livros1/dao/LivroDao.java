package livros1.dao;

import javax.persistence.*;
import livros1.entity.*;
import java.io.Serializable;
import java.util.List;


public class LivroDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
    private EntityManager manager;
	
	public void incluir(Livro livro) {
		manager.persist(livro);
		}
	
	public void remove(Livro livro) {
		manager.remove(manager.merge(livro));
		
		}
	
	public List<Livro> listaTodos(){
		String jpql = "select l from Livro l";
		Query query = manager.createQuery(jpql);
		List<Livro> livros = query.getResultList();
		
		return livros;
		
		}
	
	public List<Livro> listaPorTitulo(String titulo){
		String jpql = "select l from Livro l where l.titulo LIKE '%"+titulo+"%'";
		Query query = manager.createQuery(jpql);
		List<Livro> livros = query.getResultList();
		
		return livros;
		}
	
	
	public Livro buscaPorId(Integer id) {
		Livro livro = manager.find(Livro.class, id);
		return livro;
		
		}
	
	public void atualiza(Livro livro) {
		manager.merge(livro);
		
		}
	
	public int livrosPorCategoria(String categoriaId) {
		String jpql = "select l from Livro l where l.categoria.id = '"+categoriaId+"'";
		Query query = manager.createQuery(jpql);
		List<Livro> livros = query.getResultList();
		
		return livros.size();
		
		}
	
	

}
