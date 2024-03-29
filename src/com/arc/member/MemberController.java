package com.arc.member;

import java.util.Scanner;

import com.arc.acoount.AccountController;
import com.arc.bankView.BankView;
import com.arc.bankinput.MemberInput;

public class MemberController {

	private Scanner sc;
	private MemberDAO memberDAO;
	private MemberInput memberInput;
	private MemberDTO memberDTO;
	private BankView bankView;
	private AccountController accountController;
	
	public MemberController() {
		sc = new Scanner(System.in);
		memberDAO = new MemberDAO();
		memberInput = new MemberInput();
		memberDTO = new MemberDTO();
		bankView = new BankView();
		accountController = new AccountController();
	}


	public void start() {
		boolean check = true;

		while(check) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");

			int select = sc.nextInt();
			memberDTO = null; //????? 초기화 필요한 변수

			switch(select) {
			case 1:
				memberDTO = memberInput.memberJoin(sc);
				
				try {
					select = memberDAO.memberJoin(memberDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					select = 0;
				}
				
				String msg = "Member Join Fail";
				
				if(select > 0) {
					msg = "Member Join Success";
				}
				
				bankView.view(msg);
				
				break;

			case 2:
				memberDTO = memberInput.memberLogin(sc); //id, pw 불러오기 위해~
				
				try {
					memberDTO = memberDAO.memberLogin(memberDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					memberDTO = null;
				}
				
				if(memberDTO != null) {
					bankView.view("Login Success");
					accountController.start(memberDTO);
				}else {
					bankView.view("Login Fail");
				}
				
				break;

			default:
				check = !check;
				break;
			}
		}
	}
}
