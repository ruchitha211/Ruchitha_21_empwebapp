package com.capgemini.servletswithoutsession.dao;

import java.awt.List;
import java.util.ArrayList;

import com.capgemini.servletswithoutsession.dto.Bean;

public interface EmployeeDao {
	public boolean deleteEmployeeById(int id);
	public boolean updateEmployee(Bean b);
	public boolean  addEmployeeDetails(Bean b2);
	public Bean getEmployeeDetailsById(int id);
	public ArrayList<Bean> getAllEmployeeDetails();
	
	

}
