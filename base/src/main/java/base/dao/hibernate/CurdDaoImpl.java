package base.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import base.dao.CurdDao;
import base.model.QueryCond;
import base.model.QueryResult;

public class CurdDaoImpl<E, P extends Serializable> extends HibernateDaoSupport implements CurdDao<E, P> {

	protected Class<? extends E> clazz;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CurdDaoImpl() {
		this.clazz = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	public void insert(E entity) {
		getHibernateTemplate().save(entity);
	}

	public void update(E entity) {
		getHibernateTemplate().update(entity);
	}

	public void delete(P id) {
		delete(get(id));
	}

	public void delete(E entity) {
		getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public E get(P id) {
		return (E) getHibernateTemplate().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<E> get(final int start, final int size) {
		return (List<E>) getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from " + clazz.getName());
				query.setFirstResult(start);
				if (size > -1) {
					query.setMaxResults(size);
				}
				return query.list();
			}
		});
	}

	public QueryResult<E> get(QueryCond cond) {
		return null;
	}

}
