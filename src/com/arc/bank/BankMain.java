package com.arc.bank;

import com.arc.member.MemberController;
import com.arc.member.MemberDAO;
import com.arc.member.MemberDTO;

public class BankMain {

	public static void main(String[] args) {
//		MemberDAO memberDAO = new MemberDAO();
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("a");
		
		MemberController memberController = new MemberController();
		memberController.start();
		
		
	}
}
