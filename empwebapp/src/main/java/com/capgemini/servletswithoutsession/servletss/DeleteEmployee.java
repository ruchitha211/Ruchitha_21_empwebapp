package com.capgemini.servletswithoutsession.servletss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.servletswithoutsession.service.EmployeeService;
import com.capgemini.servletswithoutsession.service.EmployeeServiceImpl;

public class DeleteEmployee extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("id1");
	EmployeeService service=new EmployeeServiceImpl();
	service.deleteEmployeeById(Integer.parseInt(id));

	super.doPost(req, resp);
}

}
