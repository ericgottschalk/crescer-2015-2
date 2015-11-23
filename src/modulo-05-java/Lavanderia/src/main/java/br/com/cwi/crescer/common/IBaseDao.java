package br.com.cwi.crescer.common;

public interface IBaseDao<T extends Base> {

    void add(T item);

    void update(T item);

    void remove(T item);

    T findById(Long id);
}
