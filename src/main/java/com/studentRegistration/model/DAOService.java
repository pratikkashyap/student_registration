package com.studentRegistration.model;

import java.sql.ResultSet;

public interface DAOService {

	public void connectionDB();
	public boolean verifyDetails(String email, String password);
	public void saveReg(String name, String city, String email, String mobile);
	public ResultSet RegistrationList();
	public void DeleteRegistration(String email);
	public void UpdateReg(String email, String mobile);
		
}
