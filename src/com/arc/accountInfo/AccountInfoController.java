package com.arc.accountInfo;

import java.util.ArrayList;
import java.util.Scanner;

import com.arc.bankView.AccountInfoView;
import com.arc.bankView.AccountView;
import com.arc.bankView.BankView;
import com.arc.bankinput.AccountInfoInput;

public class AccountInfoController {

	private Scanner sc;
	private AccountInfoDAO accountInfoDAO;
	private AccountInfoDTO accountInfoDTO;
	private AccountInfoView accountInfoView;
	private AccountInfoInput accountInfoInput;
	private BankView bankView;

	public AccountInfoController() {
		sc = new Scanner(System.in);
		accountInfoDAO = new AccountInfoDAO();
		accountInfoDTO = new AccountInfoDTO();
		accountInfoView = new AccountInfoView();
		accountInfoInput = new AccountInfoInput();
		bankView = new BankView();
	}



	public void start(String anum) {
		boolean check = true;

		while(check) {

			System.out.println("1. 입출금내역조회");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 종료");

			int select = sc.nextInt();

			switch(select) {
			case 1:

				try {
					ArrayList<AccountInfoDTO> ar = accountInfoDAO.incomeselect(anum);
					accountInfoView.view(ar);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				break;

			case 2:

				try {
					long income = accountInfoInput.incomeInput(sc);
					long balance = accountInfoDAO.getAccountBalance(anum);
					AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
					accountInfoDTO.setType(1);
					accountInfoDTO.setAnum(anum);
					accountInfoDTO.setTs(income);
					accountInfoDTO.setAbal(balance+income);

					select = accountInfoDAO.transaction(accountInfoDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					select = 0;
				}

				if(select>0) {
					bankView.view("입금성공");
				}else {
					bankView.view("입금실패");
				}

				break;

			case 3:

				try {
					long income = accountInfoInput.incomeInput(sc);
					long balance = accountInfoDAO.getAccountBalance(anum);

					if(balance>=income) {
						AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
						accountInfoDTO.setType(0);
						accountInfoDTO.setAnum(anum);
						accountInfoDTO.setTs(income);
						accountInfoDTO.setAbal(balance-income);

						select = accountInfoDAO.transaction(accountInfoDTO);
					}else {
						System.out.println("잔액이 부족합니다");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					select = 0;
				}

				if(select>0) {
					bankView.view("출금성공");
				}else {
					bankView.view("출금실패");
				}

				break;

			default :
				check = !check;
				break;

			}
		}


	}
}
