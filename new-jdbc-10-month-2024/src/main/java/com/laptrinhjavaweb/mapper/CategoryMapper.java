package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		// ham nay thuc hien chuyen doi code thong qua qua trinh lay thong tin va truyen vao lop 
		try {
			CategoryModel category = new CategoryModel();
			category.setId(rs.getLong("id"));
			category.setCode(rs.getString("code"));
			category.setName(rs.getString("name"));
			return category;
		}
		catch ( SQLException e) {
				return null;
		}
	}
}
