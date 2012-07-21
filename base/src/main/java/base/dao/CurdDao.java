package base.dao;

import java.io.Serializable;
import java.util.List;

import base.model.QueryCond;
import base.model.QueryResult;

public interface CurdDao<E, P extends Serializable> {

	public void insert(E entity);

	public void update(E entity);

	public void delete(P id);

	public void delete(E entity);

	public E get(P id);

	public List<E> get(int start, int size);

	public QueryResult<E> get(QueryCond cond);
}
