package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.common.Base;
import br.com.cwi.crescer.common.IBaseDao;

@Repository
public class BaseDao<T extends Base> implements IBaseDao<T>{

    @PersistenceContext
    protected EntityManager manager;

    protected Class<T> classs;

    protected BaseDao(){
    }

    public BaseDao(Class<T> classs){
        this.classs = classs;
    }

    @Override
    @Transactional
    public void add(T item){
        this.manager.persist(item);
    }

    @Override
    @Transactional
    public void remove(T item){
        this.manager.remove(item);
    }

    @Override
    @Transactional
    public void update(T item){
        this.manager.merge(item);
    }

    @Override
    public T findById(Long id) {
        return this.manager.find(this.classs, id);
    }
}
