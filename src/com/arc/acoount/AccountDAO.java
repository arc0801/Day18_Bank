package com.arc.acoount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.arc.member.MemberDTO;
import com.arc.util.DBConnector;

public class AccountDAO {
	//계좌 조회
	public ArrayList<AccountDTO> accountSelect(String id) throws Exception{
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		AccountDTO accountDTO = new AccountDTO();
		ArrayList<AccountDTO> ar = new ArrayList<AccountDTO>();
		
		con = DBConnector.getConnect();
		
		String sql = "select * from account "
				+ "where id = ?";
		
		st = con.prepareStatement(sql);
		
		st.setString(1, id);
		
		rs = st.executeQuery();
		
		while(rs.next()) {
			accountDTO = new AccountDTO();
			accountDTO.setaName(rs.getString("aName"));
			accountDTO.setaNum(rs.getString("aNum"));
			accountDTO.setaBal(rs.getLong("aBal"));
			ar.add(accountDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}
	
	//계좌 개설
	public int accountCreate(AccountDTO accountDTO)throws Exception{
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		con = DBConnector.getConnect();
		
		String sql = "Insert into account values(?, ?, ?, ?)";		
		
		st = con.prepareStatement(sql);
		
		st.setString(1, accountDTO.getId());
		st.setString(2, accountDTO.getaNum());
		st.setString(3, accountDTO.getaName());
		st.setLong(4, accountDTO.getaBal());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
}
