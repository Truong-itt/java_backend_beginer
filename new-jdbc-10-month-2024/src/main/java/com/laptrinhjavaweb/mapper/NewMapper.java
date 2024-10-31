package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel>{
	// map data vê lop oob thuc hien cho viec luu tru data có the la list
	@Override
	public NewModel mapRow(ResultSet rs) {
		try {
			// thuc hien get thong tin model dem vao du lieu
			NewModel news = new NewModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setCategoryId(rs.getLong("categoryid"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setShortDescription(rs.getString("shortdescription"));
			news.setCreatedDate(rs.getTimestamp("createddate"));
			news.setCreateBy(rs.getString("createdby"));
			// xu li khi map data khi co data
			if (rs.getTimestamp("modifieddate") != null)  {
				news.setModifiedDate(rs.getTimestamp("modifieddate")); 
			}	
			if (rs.getTimestamp("modifiedby") != null)  {
				news.setModifiedBy(rs.getString("modifiedby")); 
			} 
			
			return news;
		}
		catch ( SQLException e) {
				return null;
		}
	}
}
