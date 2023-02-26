package com.masai.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.masai.Dao.ConsumerDao;
import com.masai.Dao.ConsumerDaoImpl;

import com.masai.Exceptions.ConsumerException;
import com.masai.customcolor.ConsoleColor.ConsoleColors;
import com.masai.main.Main;
import com.masai.model.Bill;
import com.masai.model.Consumer;

public class ConsumerUseCase {
	static Scanner sc= new Scanner(System.in);
	public static final ConsumerDao dao= new ConsumerDaoImpl();
	
	public static void main(String[] args) {
		System.out.println(ConsoleColors.WHITE_BACKGROUND+"-------------------------------------------------------");
		System.out.println(ConsoleColors.GREEN_BOLD+"|| Please Choose Your Action :-");
		System.out.println(ConsoleColors.GREEN_BOLD+"--------------------------------------");
//		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[1] Login Consumer                    |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[1] PayBill                           |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[2] View Transaction History          |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[3] Go Back                           |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[4] Exit                              |");
		

		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"----------------------------------------------------------|"+ConsoleColors.RESET);
		
		System.out.println(" ");
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Please Enter Your Choice :");
		
		int choice =sc.nextInt();
		switch(choice) {
		
		case 1: {
			PayBill();
			ConsumerUseCase con=new ConsumerUseCase();
			con.main(args);
			break;
		}
		case 2 :{
			TransactionHistory();
			ConsumerUseCase con=new ConsumerUseCase();
			con.main(args);
			break;
		}
		case 3:{
			Main m1=new Main();
			m1.main(args);
			break;
		}
		case 4:{
			System.out.println(ConsoleColors.GREEN_BOLD+"ThanYou for useing Application! Visit Again ");
			break;
		}
		default:
			System.out.println("Invalid choice");
			ConsumerUseCase con=new ConsumerUseCase();
			con.main(args);
			
		
		}
		
		
	}
	
	
//	
//	public static void Login() {
//		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Consumer Name :");
//		String Username=sc.next();
//		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Password :");
//		String password=sc.next();
//		Consumer conn= new Consumer();
//		try {
//			conn=dao.LoginConsumer(Username, password);
//			System.out.println(ConsoleColors.GREEN_BOLD+"Welcome "+ conn.getC_username());
////			System.out.println("-----------------------------------------------------");
//			
//			
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Consumer Id : "+conn.getConsumer_id());
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Id : "+ conn.getAdmin_id());
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Consumer Name : "+ conn.getC_username());
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Comsumer Password : "+conn.getC_password());
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Consumer Active status: "+conn.getIs_active());
//			
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"-------------------------------------------------------");
//			
//		} catch (ConsumerException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
////			e.printStackTrace();
//		}
//		
//		
//		
//	}
	
	public static void  PayBill() {
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Consumer Id :");
		int Consumer_id=sc.nextInt();
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Bill Id :");
		int Bill_id=sc.nextInt();
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Amount :");
		double amount=sc.nextDouble();
		
		try {
			String res=dao.PaybillByConsumerId(Consumer_id, Bill_id, amount);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+res);
		} catch (ConsumerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void TransactionHistory() {
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Consumer Id :");
		int Consumer_id=sc.nextInt();
		List<Bill> list=new ArrayList<>();
		
		
		try {
			list=dao.ViewHisOwnTransactionHistory(Consumer_id);
			
			list.forEach(bill->{
				System.out.println(ConsoleColors.WHITE_BACKGROUND+"------------------------------------------------------------");
				
				System.out.println(ConsoleColors.GREEN_BOLD+"--------------------------------------");
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Bill Id          :           |"+bill.getId());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Consumer id      :           |"+bill.getConsumer_id());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Start Date       :           |"+bill.getStartDate());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"End Date         :           |"+bill.getEndDate());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Unit Consumed    :           |"+bill.getUnitsConsumed());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Fixed charge     :           |"+bill.getFixedCharge());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Tax              :           |"+bill.getTax());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Adjustment       :           |"+bill.getAdjustment());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Total amount     :           |"+bill.getTotalAmount());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Is Paid          :           |"+bill.getIsPaid());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Amount due       :           |"+bill.getAmount_due());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Amount Paid      :           |"+bill.getAmount_paid());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Due Date         :           |"+bill.getDue_date());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Payment Date     :           |"+bill.getPayment_date());
				
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"-------------------------------------------------------------|"+ConsoleColors.RESET);
				
			});
	
			
		} catch (ConsumerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	
	
	
	


}
