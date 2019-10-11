package com.arc.bankinput;

import java.util.Calendar;
import java.util.Scanner;

import com.arc.acoount.AccountDTO;

public class AccountInput {

	//계좌개설
	public AccountDTO accountMake(Scanner sc) {

		AccountDTO accountDTO = new AccountDTO();
		
		System.out.println("계좌명 입력");
		accountDTO.setaName(sc.next());
		
		Calendar ca = Calendar.getInstance(); //Calendar는 추상클래스라 객체 생성 불가. getInstance 이용. 현재시간 들어감.
		long l = ca.getTimeInMillis();
		
		accountDTO.setaNum(String.valueOf(l));
		
		//balance는 알아서 0으로 초기화 되어있음.
		//id는 로그인한 유저의 id이므로 받을 필요 없음.
		
		return accountDTO;
	}
	
}
