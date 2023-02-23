package com.masai.main;

//import java.sql.SQLException;
import java.util.Scanner;

import com.masai.usecase.AdminUseCase;
import com.masai.usecases.admin.AdminUseCases;


public class Main {
	public static void main(String[] args) {
		Main m=new Main();
		AdminUseCase ad=new AdminUseCase();
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome To Electronic Corporation ");
		System.out.println("========================================");
		System.out.println("+ 1. Admin        +\n"
						+ "+ 2. Consumer     +");
		System.out.println("========================================");
		System.out.println("Choose 1 for Admin And Choose 2 for Consumer");
		
		
		
		System.out.println("Enter Your Choice :");
		int choice=sc.nextInt();
		
//		switch(choice) {
//		case 1 : ad.Register();
//		
//		case 2 : ad.Login();
//		
//		}
		
		if(choice==1) {
			System.out.println("+ 1. Login     +\n"
					+ 		  " + 2. Register  +");
			System.out.println("Enter Your Choise :");
			int c=sc.nextInt();
			switch(c) {
			case 1 : ad.Register();
			
			case 2 : ad.Login();
			
			case 3 : break;
			
			}
			
		}else if(choice!=0){
			System.out.println("Thanx For Using App..");
		}
	}

}
