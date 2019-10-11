package com.arc.accountInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.arc.util.DBConnector;

public class AccountInfoDAO {

	//내역 조회 incomeselect
	public ArrayList<AccountInfoDTO> incomeselect() throws Exception{
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList<AccountInfoDTO> ar = new ArrayList<AccountInfoDTO>();
		
		con = DBConnector.getConnect();
		
		String sql = "select * from accountinfo where anum = ? "
				+ "order by tnum desc";
		
		st = con.prepareStatement(sql);
		
		st.setString(1, anum);
		
		rs = st.executeQuery();
		
		while(rs.next()) {
			AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
			accountInfoDTO.set
			
			
			
			
		}
		
		
		
		
		return ar;
	}
	
	//입출금 거래
	public int transaction(AccountInfoDTO accountInfoDTO) throws Exception{

		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		con = DBConnector. getConnect();

		String sql = "insert into accountinfo(tnum, anum, tdate, ts, type, abal) "
				+ "values(ts_seq.nextval, ?, sysdate, ?, ?, ?)";

		st = con.prepareStatement(sql);
		
		st.setString(1, accountInfoDTO.getAnum());
		st.setLong(2, accountInfoDTO.getTs());
		st.setInt(3, accountInfoDTO.getType());
		st.setLong(4, accountInfoDTO.getAbal());

		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}
