package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object ... parameters);
	// viet phuong thuc cho 
	void update (String sql, Object ...objects);
	Long insert (String sql, Object ...objects);
}
