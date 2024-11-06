package com.laptrinhjavaweb.service;

import java.util.List;

import javax.enterprise.inject.New;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.pagging.Pageble;

public interface INewService {
	List<NewModel> findByCategory(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel newModel);
	
	void delete(Long[] ids);
	List<NewModel> findAll(Pageble pageble);
	
	int getTotalItem();
	NewModel findOne(long id);
}
