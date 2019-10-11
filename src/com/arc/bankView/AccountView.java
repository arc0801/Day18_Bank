package com.arc.bankView;

import java.util.ArrayList;

import com.arc.acoount.AccountDTO;

public class AccountView {

	public void selectView(ArrayList<AccountDTO> ar) {
//		for(int i=0;i<ar.size();i++) {
//			System.out.println(ar.get(i).getaName());
//			System.out.println(ar.get(i).getaNum());
//			System.out.println(ar.get(i).getaBal());
//		}
		
		for(AccountDTO accountDTO : ar) {
			System.out.println("계좌명\t계좌번호\t\t잔액");
			System.out.print(accountDTO.getaName()+"\t");
			System.out.print(accountDTO.getaNum()+"\t");
			System.out.print(accountDTO.getaBal()+"\n");
		}
		
	}
}
