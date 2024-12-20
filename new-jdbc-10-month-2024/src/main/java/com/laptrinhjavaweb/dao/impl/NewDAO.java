package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.pagging.Pageble;



public class NewDAO extends AbstractDAO<NewModel> implements INewDAO{

	@Override
	public List<NewModel> findByCategory(Long categoryId) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		// cach viet 1 thong thuong 
		// String sql = "Insert into news (title, content, categoryid, createddate, createdby, modifieddate, modifiedby, thumbnail, shortdescription) value(?,?,?,?,?,?,?,?,?)";		
		// cach viet 2 thong qu stringbuilderr
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO news ");
		sql.append("(title, content, categoryid, createddate, createdby, thumbnail, shortdescription) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

		return insert(
				sql.toString(),
				newModel.getTitle(), 
				newModel.getContent(), 
				newModel.getCategoryId(),
				
				newModel.getCreatedDate(),
				newModel.getCreateBy(),
//				newModel.getModifiedDate(),
//				newModel.getModifiedBy(),
				
				newModel.getThumbnail(),
				newModel.getShortDescription());
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?, ");
		sql.append(" shortdescription = ?, content = ?, categoryid = ? ,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");

		// du dung StringBuilder de toi uu bo nho
		update(sql.toString(), 
				   updateNew.getTitle(),
				   updateNew.getThumbnail(), 
				   
				   updateNew.getShortDescription(), 
			       updateNew.getContent(), 
			       updateNew.getCategoryId(),
				   
			       updateNew.getCreatedDate(),
			       updateNew.getCreateBy(),
			       updateNew.getModifiedDate(),
			       updateNew.getModifiedBy(),
			       
				   updateNew.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news where id = ?";
		update(sql , id);
		
	}

//	@Override
//	public List<NewModel> findAll(int offset, int limit) {
//		String sql = "select * from news";
//		return query(sql, new NewMapper());
//	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
	    StringBuilder sql = new StringBuilder("SELECT * FROM news ");
	    if (pageble.getSorter() != null) {
	    	sql.append("ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
	    }
	    if (pageble.getOffset() != null && pageble.getLimit() != null) {
	        sql.append("LIMIT "+ pageble.getOffset() + ", " + pageble.getLimit() +"");
	    }
		System.out.println("new dao");
		System.out.println("query:" + sql.toString());
	    return query(sql.toString(), new NewMapper());
	}




//	@Override
//	public Long save(NewModel newModel) {
//		ResultSet resultSet = null;
//		Long id = null;
//		Connection connection = null;
//		PreparedStatement statement = null;
//		try {
//			String sql = "Insert into news (title, content, categoryid) value(?,?,?)";
//			connection = getConnection();
//			connection.setAutoCommit(false);
//			statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
//			statement.setString(1, newModel.getTitle());
//			statement.setString(2, newModel.getContent());
//			statement.setLong(3, newModel.getCategoryId());
//			statement.executeUpdate();
//			resultSet = statement.getGeneratedKeys(); 
//			if (resultSet.next()) {
//				id =  resultSet.getLong(1);
//			}
//			connection.commit(); 
//			return id;
//		} catch (SQLException e) {
//			if (connection != null) {
//				try {
//					connection.rollback();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
//			return null;
//		}
//		finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//				if (resultSet != null) {
//					resultSet.close();
//				}
//	
//			} catch (Exception e) {
//				return null;
//			}
//		}
//	}
	
	

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
//	public List<NewModel> findByCategory(Long categoryId) {
//		List<NewModel> results = new ArrayList<>();
//		String sql = "select * from news where categoryId = ?";
//		Connection connection = getConnection();
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		if (connection != null) {
//			try {
//				statement = connection.prepareStatement(sql);
//				statement.setLong(1, categoryId);
//				resultSet = statement.executeQuery();
//				while (resultSet.next()) {
//					NewModel news = new NewModel();
//					news.setId(resultSet.getLong("id"));
//					results.add(news);	
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
