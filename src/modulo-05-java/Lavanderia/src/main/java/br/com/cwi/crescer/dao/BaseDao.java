package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.common.Base;


@Repository
public class BaseDao<T extends Base>{

    @PersistenceContext
    protected EntityManager manager;

    @Transactional
    public void add(T item){
        this.manager.persist(item);
    }

    @Transactional
    public void remove(T item){
        this.manager.remove(item);
    }

    @Transactional
    public void update(T item){
        this.manager.merge(item);
    }
}
