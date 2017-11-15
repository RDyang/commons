package com.rdyang.hibernate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rdyang.hibernate.dao.BaseDao;
import com.rdyang.hibernate.dao.exception.CreateHqlException;
import com.rdyang.hibernate.util.Pagination;

/**
 * 抽象类，不应该被实例化
 * 
 * @author Administrator
 *
 * @param <T>
 * @param <PK>
 */
public abstract class BaseDaoImpl<T, PK extends Serializable>
		implements
			BaseDao<T, PK> {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(BaseDaoImpl.class);

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveOrUpdate(T t) {
		getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void save(T t) {
		getCurrentSession().save(t);
	}

	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		String hql = "from " + clazz.getName();
		Query query = getCurrentSession().createQuery(hql);
		List<T> list = query.list();
		return list;
	}

	/**
	 * 默认分页查询
	 * 
	 * @param pageIndex
	 *            页数
	 * @param pageSize
	 *            每页条数
	 * @param params
	 *            查询参数
	 * @return Pagination
	 */
	public Pagination<T> findPagination(int pageIndex, int pageSize,
			Map<String, Object> params) {
		XqlHelper xqlHelper = new XqlHelper();
		String hql = xqlHelper.createHql(params);
		List<T> find = find(hql, pageIndex, pageSize, params);
		long rowsCount = getRowsCount(params);
		Pagination<T> page = new Pagination<>(rowsCount, pageIndex, pageSize,
				find.size(), find);
		return page;
	}

	/**
	 * 查询结果
	 * 
	 * @param hql
	 *            hql语句
	 * @param params
	 *            查询参数
	 * @param pageIndex
	 *            页面开始位置
	 * @param pageSize
	 *            页面数据数量
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(CharSequence hql, int pageIndex, int pageSize,
			Map<String, Object> params) {

		Query query = getCurrentSession().createQuery(hql.toString());

		setPage(query, pageIndex, pageSize);
		setParameter(query, params);

		List<T> list = query.list();
		return list;
	}

	/**
	 * 查询结果，hql以占位符方式传值 ex:select * from tableName where id = ?
	 * 
	 * @param hql
	 *            hql语句
	 * @param pageIndex
	 *            页面开始位置
	 * @param pageSize
	 *            页面数据数量
	 * @param params
	 *            查询参数
	 * @return List
	 * @deprecated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(CharSequence hql, int pageIndex, int pageSize,
			Object... params) {
		Query query = getCurrentSession().createQuery(hql.toString());
		setPage(query, pageIndex, pageSize);
		setParameter(query, params);

		List<T> list = query.list();

		return list;
	}

	private Query setParameter(Query query, Map<String, Object> params) {

		int index = 0;
		for (Entry<String, Object> param : params.entrySet()) {
			Field field = getField(param.getKey());
			if(isString(field)) {
				query.setParameter(index++, "%" + param.getValue() + "%");
			}else {
				query.setParameter(index++, param.getValue());
			}
		}

		return query;
	}

	private Query setParameter(Query query, Object... params) {
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query;
	}

	private Query setPage(Query query, int pageIndex, int pageSize) {
		if (pageIndex > 0 && pageSize > 0) {
			query.setFirstResult((pageIndex - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public long getRowsCount(Map<String, Object> params) {
		String clazzName = clazz.getName();
		String hql = "select count(*) from " + clazzName;
		Query query = getCurrentSession().createQuery(hql.toString());
		List list = query.list();
		return (long) list.get(0);
	}
	
	private Field getField(String fieldName) {
		Field field = null;
		try {
			field = clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			LOGGER.info("don't have this field...", e);
			throw new CreateHqlException(
					"can't find this field:" + fieldName,
					e);
		} catch (SecurityException e) {
			LOGGER.info("emmm...I don't know what happened...", e);
			throw new CreateHqlException(
					"can't find this field:" + fieldName,
					e);
		}
		return field;
	}
	
	private boolean isString(Field field) {
		return field.getType().toString().endsWith("String");
	}

	/**
	 * 无法通用，待修改
	 * 
	 * @author Administrator
	 * @deprecated
	 */
	protected class XqlHelper {
		private static final String FROM = " FROM ";
		private static final String WHERE = " WHERE 1=1 ";
		private static final String AND = " AND ";
		private static final String SELECT = " SELECE ";
		private static final String DISTANCT = " DISTANCT ";
		private static final String CALL = " CALL ";
		private static final String OR = " OR ";
		private static final String CONDITION_VALUE = " like ? ";
		private static final String COMMA = ",";

		public XqlHelper() {
		}

		public String createHql(Map<String, Object> conditions) {
			StringBuilder hql = createPrefixHql();
			if (null != conditions) {
				for (Entry<String, Object> condition : conditions.entrySet()) {
					hql.append(AND);
					hql.append(condition.getKey());
					Field field = getField(condition.getKey());
					if (isString(field)) {
						hql.append(CONDITION_VALUE);
					} else {
						hql.append("= ?");
					}
				}
			}
			return hql.toString();
		}

		public StringBuilder createPrefixHql() {
			StringBuilder xql = new StringBuilder();
			xql.append(FROM);
			xql.append(clazz.getSimpleName());
			xql.append(WHERE);
			return xql;
		}

		public String createSql(Map<String, String> conditions,
				String... resultColumns) {
			StringBuilder sql = createPrefixSql(resultColumns);
			for (Entry<String, String> condition : conditions.entrySet()) {
				sql.append(AND);
				sql.append(condition.getKey());
				sql.append(condition.getValue());
				sql.append(CONDITION_VALUE);
			}
			return sql.toString();
		}

		public StringBuilder createPrefixSql(String... resultColumns) {
			StringBuilder sql = new StringBuilder();
			for (String resultColumn : resultColumns) {
				sql.append(SELECT);
				sql.append(resultColumn);
				sql.append(COMMA);
			}
			sql.append(FROM);
			sql.append(clazz.getSimpleName());
			sql.append(WHERE);
			return sql;

		}
	}
}
