package com.db.mock.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.db.mock.service.model.Request;
import com.db.mock.service.model.Response;
@Component
public class DbMockServiceDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Response createRecord(Request request) {
		Response response = new Response();
	int id = 	jdbcTemplate.update("INSERT INTO EMPLOYEE (ID,NAME) VALUES(?,?)", new Object[]{request.getId(), request.getName()});
	if(id == 1){
	response.setId(request.getId());
	response.setName(request.getName());
	response.setMsg("SUCCESSFUL");
	}else{
		response.setMsg("FAIL");	
	}
	return response;
	}

	

	public Response getEmployee(String id) {
		Response response = jdbcTemplate.query("SELECT ID, NAME FROM EMPLOYEE WHERE ID = ?", new Object[]{id},
				new ResultSetExtractor<Response>() {
					public Response extractData(ResultSet rs) throws SQLException, DataAccessException {
						Response response = null;
						if (rs.next()) {
							response = new Response();
							response.setId(rs.getString("ID"));
							response.setName(rs.getString("NAME"));
						}
						return response;
					}

				});

		return response;
	}

}
