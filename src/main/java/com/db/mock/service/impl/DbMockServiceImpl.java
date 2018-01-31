package com.db.mock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db.mock.service.dao.DbMockServiceDao;
import com.db.mock.service.model.Request;
import com.db.mock.service.model.Response;
@Component
public class DbMockServiceImpl {
	@Autowired
	private DbMockServiceDao dbMockServiceDao;

	public Response createRecord(Request request) {
		return dbMockServiceDao.createRecord( request);
		
	}

	public Response getEmployee(String id) {
		// TODO Auto-generated method stub
		return dbMockServiceDao.getEmployee(id);
	}

}
