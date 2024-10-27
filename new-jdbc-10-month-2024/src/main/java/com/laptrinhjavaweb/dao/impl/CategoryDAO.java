package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

//	public Connection getConnection() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/newjava09month2024";
//			String user = "root";
//			String password = "something";
//			return DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException | SQLException e) {
//			return null;
//		}
//	}
	
//	@Override
//	public List<CategoryModel> findAll() {
//		List<CategoryModel> results = new ArrayList<>();
//		String sql = "select * from category";
//		Connection connection = getConnection();
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		if (connection != null) {
//			try {
//				statement = connection.prepareStatement(sql);
//				resultSet = statement.executeQuery();
//				while (resultSet.next()) {
//					CategoryModel category = new CategoryModel();
//					category.setId(resultSet.getLong("id"));
//					category.setCode(resultSet.getString("code"));
//					category.setCode(resultSet.getString("name"));
//					category.setCode(resultSet.getString("code"));
//					results.add(category);
//				}
//			}
//			catch (SQLException e){
//				return null;
//			}
//			finally {
//				try {
//					if (connection != null) {
//						connection.close();
//					}
//					if (statement != null) {
//						statement.close();
//					}
//					if (resultSet != null) {
//						resultSet.close();
//					}
//
//				} catch (Exception e) {
//					return null;
//				}
//			}
//		}
//		return null;
//	}
}
