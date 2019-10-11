package com.arc.bank;

import com.arc.accountInfo.AccountInfoDAO;
import com.arc.accountInfo.AccountInfoDTO;
import com.arc.acoount.AccountController;
import com.arc.member.MemberController;
import com.arc.member.MemberDAO;
import com.arc.member.MemberDTO;

public class BankMain {

	public static void main(String[] args) throws Exception{
		/*Connection con = DBConnetor.getConnection();
		System.out.println(con);*/ //연결 확인



		/*	MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("iu");
		memberDTO.setPw("iu");
		memberDTO.setName("iu");
		memberDTO.setPhone("010-555-5555");
		memberDTO.setEmail("ku@email.com");
		try {
			int result = memberDAO.memberJoin(memberDTO);
			System.out.println(result);
		} catch (Exception e) {

			e.printStackTrace();
		} 	// DAO Join 확인



		/*	MemberDAO memberDAO = new MemberDAO();
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId("iu");
			memberDTO.setPw("iu");

			try {
				memberDTO = memberDAO.memberLogin(memberDTO);
				System.out.println(memberDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/


//		MemberController memberController = new MemberController();
//		memberController.start();
//		
//		AccountInfoDAO accountInfoDAO = new AccountInfoDAO();
//		AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
//		accountInfoDTO.setAnum("1570756625406");
//		accountInfoDTO.setTs(200);
//		accountInfoDTO.setType(1);
//		accountInfoDTO.setAbal(0);
//		
//		int result = accountInfoDAO.transaction(accountInfoDTO);
//		System.out.println(result);


		//		AccountController accountController = new AccountController();
		//		accountController.start();



	}
}
