package com.arc.bankView;

import java.util.ArrayList;

import com.arc.accountInfo.AccountInfoDTO;

public class AccountInfoView {
	
	public void view(ArrayList<AccountInfoDTO> ar) {
		System.out.println("Tnum\tAnum\t\tTdate\tTs\tType\tAbal");
		
		for(AccountInfoDTO accountInfoDTO : ar) {
			System.out.print(accountInfoDTO.getTnum()+"\t");
			System.out.print(accountInfoDTO.getAnum()+"\t");
			System.out.print(accountInfoDTO.getTdate()+"\t");
			System.out.print(accountInfoDTO.getTs()+"\t");
			System.out.print(accountInfoDTO.getType()+"\t");
			System.out.print(accountInfoDTO.getAbal()+"\n");
		}
	}

	
	
	
	
	
}
