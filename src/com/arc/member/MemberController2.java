package com.arc.member;

import java.util.Scanner;

import com.arc.bankView.BankView;
import com.arc.bankinput.MemberInput;

public class MemberController2 {

	private Scanner sc;
	private MemberDAO memberDAO;
	private MemberInput memberInput;
	private MemberDTO memberDTO;
	private BankView bankView;

	public MemberController2() {
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
					select = memberDAO.memberJoin(memberDTO); //exception 발생. 위로 올라감. select = 1인 상태. 그러므로 success 출력
					String msg = "Member Join Fail";

					if(select > 0) {
						msg = "Member Join Success";
					}

					bankView.view(msg);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					select = 0;
				}
				break;

			case 2:

				break;

			default:
				check = !check;
				break;





			}
		}


		//- 사용자는 계좌를 여러 개 생성가능
		//- 각 계좌를 입금, 출금 기능
		//- 입출금내역을 조회 기능
		//- 계좌 생성시, 계좌번호
		//- 로그인 정보, 이름, 전화번호, 이메일...
		//
		//- 회원가입
		//- 로그인
		//- 로그아웃
		//- 조회 - 계좌정보 조회, 이용내역 조회...
		//- 입금
		//- 출금
		//
		//로그인 - 실패시 다시 로그인
		//
		//성공시
		//	조회
		//	입금
		//	출금
		//
		//Day18_Bank >>
		//
		//com.arc.member - MemberDTO  MemberDAO(memberJoin, memberLogin)  MemberController(start)
		//com.arc.account - AccountDTO  AccountDAO(accountCreate) AccountController(start)
		//com.arc.accountinfo - AccountInfoDTO  AccountInfoDAO
		//
		//
		//com.arc.util
		//DBConnector - getConnection
		//
		//com.arc.bank - BankMain(main)



	}
}
