package com.db.mock.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.mock.service.impl.DbMockServiceImpl;
import com.db.mock.service.model.Request;
import com.db.mock.service.model.Response;

@RestController
public class DbMockServiceController {
	
	@Autowired
	private DbMockServiceImpl dbMockServiceController;
	
	@RequestMapping( value = "/save" , method = RequestMethod.POST)
	public Response createRecord(@RequestBody Request request){
	return	dbMockServiceController.createRecord(request);
		
	}

	
	@RequestMapping( value = "/employee" , method = RequestMethod.GET)
	public Response createRecord(@RequestParam String id){
	return	dbMockServiceController.getEmployee(id);
		
	}
}
