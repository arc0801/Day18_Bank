package com.arc.bankView;

import java.util.ArrayList;

import com.arc.accountInfo.AccountInfoDTO;

public class AccountInfoView {
	
	public void view(ArrayList<AccountInfoDTO> ar) {
		System.out.println("Tradenumber\t");
		
		for(AccountInfoDTO accountInfoDTO : ar) {
			System.out.println(accountInfoDTO.getTnum()+"\t");
			
			
		}
		
		
		
	}

}
