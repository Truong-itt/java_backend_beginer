package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.pagging.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService {
	
	@Inject
	private INewDAO newDao;
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<NewModel> findByCategory(Long categoryId) {
		return newDao.findByCategory(categoryId);
	}
	
	@Override
	public NewModel save(NewModel newModel) {
		// get id them vao ra		
		
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//		newModel.setCreateBy("");
//		newModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
//		newModel.setModifiedBy("");	
		CategoryModel category = categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId = newDao.save(newModel);
		//	System.out.println(newId);		
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		// muon update van de la da up date len thak nao tim thong qua id
		NewModel oldNew = newDao.findOne(updateNew.getId());
		// logic lam viec voi kieu du lieu moi ney can thog tin du liue cua du lieu cu thi co the thuc hien nhu sau 
		// get mot so thong tin tu code cu
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreateBy(oldNew.getCreateBy());
//		updateNew.setModifiedBy(oldNew.getModifiedBy());
//		updateNew.setModifiedDate(oldNew.getModifiedDate());

		// du lieu sau khi thuc hien thi can 
		CategoryModel category = categoryDAO.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(Long[] ids) {
		for (long id:ids) {
			newDao.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) { 
		System.out.println("new service");

		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

	@Override
	public NewModel findOne(long id) {
		NewModel newModel = newDao.findOne(id);
		System.out.println("thong tin tim la:"+id);
		CategoryModel categoryModel = categoryDAO.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}
}
