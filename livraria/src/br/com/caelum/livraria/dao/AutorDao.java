package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ServerSessionPool;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {
	
	@Inject
	private Banco banco;

	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO] AutorDao criado");
	}
	
	public void salva(Autor autor) {
		System.out.println("[INFO] Salvando autor: " + autor.getNome());
		
//		try {
//			Thread.sleep(20000); //20 segundos
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 		
		
		banco.save(autor);
		
		System.out.println("[INFO] Salvou autor: " + autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
