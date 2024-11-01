package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel>{
	List<NewModel> findByCategory(Long categoryId);
	Long save(NewModel newModel);
	NewModel findOne(Long id);
	void update(NewModel newModel);
	

	void delete(long id);
	List<NewModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
}
