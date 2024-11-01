package com.laptrinhjavaweb.service;

import java.util.List;

import javax.enterprise.inject.New;

import com.laptrinhjavaweb.model.NewModel;

public interface INewService {
	List<NewModel> findByCategory(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel newModel);
	
	void delete(Long[] ids);
	List<NewModel> findAll(Integer offset, Integer limit);
	
	int getTotalItem();
}
