package com.arc.member;

import java.util.Scanner;

import com.arc.bankView.BankView;
import com.arc.bankinput.MemberInput;

public class MemberController {

	private Scanner sc;
	private MemberDAO memberDAO;
	private MemberInput memberInput;
	private MemberDTO memberDTO;
	private BankView bankView;
	
	public MemberController() {
		sc = new Scanner(System.in);
		memberDAO = new MemberDAO();
		memberInput = new MemberInput();
		memberDTO = new MemberDTO();
		bankView = new BankView();
	}


	public void start() {
		boolean check = true;

		while(check) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");

			int select = sc.nextInt();
			memberDTO = null; //?????

			switch(select) {
			case 1:
				memberDTO = memberInput.memberJoin(sc);
				
				try {
					select = memberDAO.memberJoin(memberDTO);
					String msg = "Member Join Fail";
					
					if(select > 0) {
						msg = "Member Join Success";
					}
					
					bankView.view(msg);
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 2:
				memberDTO = memberInput.memberLogin(sc);
				try {
					memberDTO = memberDAO.memberLogin(memberDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					memberDTO = null;
				}
				
				String msg2 = "Login Fail";
				
				if(memberDTO != null) {
					msg2 = "Login Success";
				}
				
				bankView.view(msg2);
				break;

			default:
				check = !check;
				break;





			}
		}





	}




}
