package com.crm.base.web;

import java.util.List;
import java.util.Map;

public interface BaseRepository<T> {

	void save(T t);

	void save(Map<String, Object> map);

	void saveBatch(List<T> list);

	int update(T t);

	int update(Map<String, Object> map);

	int delete(Object id);

	int deleteBatch(Map<String, Object> map);

	int deleteBatch(Object[] id);

	T queryObject(Object id);

	List<T> queryList(Map<String, Object> map);
	
	List<T> allList();

	List<T> queryList(Object id);

	int queryTotal(Map<String, Object> map);

	int queryTotal();
}
