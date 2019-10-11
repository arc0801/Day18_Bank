package com.arc.accountInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.arc.util.DBConnector;

import oracle.net.aso.a;

public class AccountInfoDAO {

	//updateBalance
	public int updateBalance(AccountInfoDTO accountInfoDTO)throws Exception{
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		con = DBConnector.getConnect();

		String sql = "update account set aBal=? where accountNumber =?";

		st=con.prepareStatement(sql);

		st.setLong(1, accountInfoDTO.getAbal());
		st.setString(2, accountInfoDTO.getAnum());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		
		return result;
	}




	//accountBalance
	public long getAccountBalance(String accountnumber) throws Exception{
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		long balance = 0;

		con = DBConnector.getConnect();

		String sql = "select accountBalance from account\r\n" + 
				"where accountnumber = ''";

		st = con.prepareStatement(sql);

		st.setString(1, accountnumber);

		rs = st.executeQuery();

		if(rs.next()) {
			balance = rs.getLong("accountbalance");
		}

		rs.close();
		st.close();
		con.close();

		return balance;
	}

	//내역 조회 incomeselect
	public ArrayList<AccountInfoDTO> incomeselect(String anum) throws Exception{

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
			accountInfoDTO.setTnum(accountInfoDTO.getTnum());
			accountInfoDTO.setAnum(accountInfoDTO.getAnum());
			accountInfoDTO.setTdate(accountInfoDTO.getTdate());
			accountInfoDTO.setTs(accountInfoDTO.getTs());
			accountInfoDTO.setType(accountInfoDTO.getType());
			accountInfoDTO.setAbal(accountInfoDTO.getAbal());
			ar.add(accountInfoDTO);
		}

		rs.close();
		st.close();
		con.close();

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
