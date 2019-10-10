package com.arc.acoount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.arc.util.DBConnector;

public class AccountDAO {

	public int accountCreate(AccountDTO accountDTO)throws Exception{
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		con = DBConnector.getConnect();
		
		String sql = "Insert into account values(?, ?, ?, ?)";		
		
		st = con.prepareStatement(sql);
		
		st.setString(1, accountDTO.getId());
		st.setString(2, accountDTO.getAccountNum());
		st.setString(3, accountDTO.getAccountName());
		st.setInt(4, accountDTO.getBalance());
		
		result = st.executeUpdate();
		
		return result;
	}
	
}