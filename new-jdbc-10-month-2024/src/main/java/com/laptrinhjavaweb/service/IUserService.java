package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserService {
	// muc dich tao ra doi tuong hoat dong
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
