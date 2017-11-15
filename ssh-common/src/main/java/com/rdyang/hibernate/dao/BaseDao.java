package com.rdyang.hibernate.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.rdyang.hibernate.util.Pagination;

public interface BaseDao<T,PK extends Serializable> {
	
	/**
	 * 更新或新增，当t.id不为0时，做更新操作，当t.id为0时，做新增操作
	 * @param t
	 */
	void saveOrUpdate(T t);
	
	void save(T t);
	
	void update(T t);
	
	T get(Serializable id);
	
	/**
	 * 查询所有数据
	 * @return List
	 */
	List<T> getAll();
	
	/**
	 * 默认分页查询
	 * @param pageIndex 页数
	 * @param pageSize 每页条数
	 * @param params 查询参数
	 * @return Pagination
	 */
	Pagination<T> findPagination(int pageIndex,int pageSize,Map<String, Object> params);
	
	/**
	 * 查询结果，hql以命令参数方式传值
	 * ex:select * from tableName where id = :id
	 * @param hql hql语句
	 * @param params 查询参数
	 * @param pageIndex 页面开始位置
	 * @param pageSize 页面数据数量
	 * @return List
	 */
	List<T> find(CharSequence hql, int pageIndex, int pageSize, Map<String, Object> params);
	
	/**
	 * 查询结果，hql以占位符方式传值
	 * ex:select * from tableName where id = ?
	 * @param hql hql语句
	 * @param pageIndex 页面开始位置
	 * @param pageSize 页面数据数量
	 * @param params 查询参数
	 * @return List
	 * @deprecated
	 */
	List<T> find(CharSequence hql, int pageIndex, int pageSize, Object... params);
	
	/**
	 * 查询总数据条数
	 * @param params 查询条件
	 * @return long
	 */
	long getRowsCount(Map<String, Object> params);
	
}
