package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.common.Base;
import br.com.cwi.crescer.common.IBaseDao;

@Repository
public class BaseDao<T extends Base> implements IBaseDao<T>{

	@PersistenceContext
	private EntityManager manager;
	
	private Class<T> classs;
	
	protected BaseDao(){
	}
	
	public BaseDao(Class<T> classs){
		this.classs = classs;
	}
	
	public void add(T item){
		this.manager.getTransaction().begin();
		this.manager.persist(item);
		this.manager.getTransaction().commit();
	}
	
	public void remove(T item){
		this.manager.getTransaction().begin();
		this.manager.remove(item);
		this.manager.getTransaction().commit();
	}
	
	public void update(T item){
		this.manager.getTransaction().begin();
		this.manager.merge(item);
		this.manager.getTransaction().commit();
	}

	public T findById(long id) {
		return this.manager.find(this.classs, id);
	}
}
