package com.masai.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Exceptions.AdministratorException;
import com.masai.customcolor.ConsoleColor.ConsoleColors;
import com.masai.main.Main;
import com.masai.model.Administrator;
import com.masai.model.Bill;
import com.masai.model.Consumer;

public class AdminUseCase {
	
	static Scanner sc= new Scanner(System.in);
	public static final AdministratorDao dao= new AdministratorDaoImpl();
	
	public static void main(String[] args) {
		System.out.println(ConsoleColors.WHITE_BACKGROUND+"-------------------------------------------------------");
		System.out.println(ConsoleColors.GREEN_BOLD+"|| Please Choose Your Action :-");
		System.out.println(ConsoleColors.GREEN_BOLD+"--------------------------------------");
//		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[1] Login Admin                           |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[1] Register new consumer                 |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[2] View All Consumer                     |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[3] View bill of Consumer                 |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[4] View all the bills                    |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[5] View all the bills Paid               |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[6] View all the bills Panding            |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[7] Delete Consumer                       |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[8] Go Back                               |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[9] Exit                                  |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"----------------------------------------------------------|"+ConsoleColors.RESET);
		
		System.out.println(" ");
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Please Enter Your Choice :");
		
		int choice =sc.nextInt();
		switch(choice) {
		
		case 1: {
				Register();
				break;
		}
		case 2: {
				ViewAllConsumer();
				break;
			
		}case 3:{
			ViewBillByconsumerIdUseCase();
			break;
		}
		case 4 :{
			VeiwAllBills();
			break;
			
			
		}
		case 5 : {
			ViewAllPaidBills();
			break;
			
		}
		case 6 : {
			ViewAllPendingBills();
			break;
			
		}case 7 :{
			DeleteConsumerById();
			break;
		}
		case 8:{
			Main m1=new Main();
			m1.main(args);
			break;
		}
		case 9:{
			System.out.println(ConsoleColors.GREEN_BOLD+"ThanYou for useing Application! Visit Again ");
			break;
		}
		default :
			System.out.println("Invalid choice");
			AdminUseCase adm=new AdminUseCase();
			adm.main(args);
			
		}
		
		
	}
	
	
	
//	public static void Login() {
//		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Consumer Email :");
//		String email=sc.next();
//		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Password :");
//		String pass=sc.next();
//		Administrator ad= new Administrator();
//		try {
//			ad=dao.LoginAdminAcount(email, pass);
//			System.out.println(ConsoleColors.GREEN_BOLD+"Welcome "+ad.getAd_username());
////			System.out.println("-----------------------------------------------------");
//			
//			
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Id : "+ad.getAdmin_id());
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Name : "+ad.getAd_username());
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Email : "+ad.getAd_email());
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Password : "+ad.getAd_password());
//			
//			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"-------------------------------------------------------");
//			
//		} catch (AdministratorException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
	
	public static void Register() {
//		Scanner sc= new Scanner(System.in);
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Consumer id : ");
		int c_id=sc.nextInt();
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter AddminId : ");
		int a_id=sc.nextInt();
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Consumer Name : ");
		String name=sc.next();
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Password : ");
		String pass=sc.next();
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Consumer Active Yes/No : ");
		String is_active=sc.next();
	
		Consumer con=new Consumer(c_id,a_id,name,pass,is_active);
		
		try {
			String m=dao.RegisterConsumer(con);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+m);
		} catch (AdministratorException e) {
			// TODO Auto-generated catch block
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	public static void ViewAllConsumer() {
		try {
			List<Consumer> consumer= dao.VeiwAllconsumer();
			if(consumer.size()==0) {
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"No Consumer Exist");
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Choose 1 from menu to Add Consumer");
			
			}else {
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+ "::Consumer Details are as Followed :: ");
				consumer.forEach(i->{
					System.out.println(ConsoleColors.WHITE_BACKGROUND+"-------------------------------------------------------");
					
					System.out.println(ConsoleColors.GREEN_BOLD+"--------------------------------------");
					System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Consumer Id                   |"+i.getConsumer_id());
					System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Administrator id              |"+i.getAdmin_id());
					System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Consumer Name                  |"+i.getC_username());
					
					System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Consumer Active Status         |"+i.getIs_active());

					System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"----------------------------------------------------------|"+ConsoleColors.RESET);
					
				});
				
			}
		} catch (AdministratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void  VeiwAllBills() {
			List<Bill> list=new ArrayList<>();
		
		
		try {
			list=dao.ViewAllBills();
			
			list.forEach(bill->{
				System.out.println(ConsoleColors.WHITE_BACKGROUND+"------------------------------------------------------------");
				
				System.out.println(ConsoleColors.GREEN_BOLD+"--------------------------------------");
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Bill Id         :           |"+bill.getId());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Consumer id     :           |"+bill.getConsumer_id());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Start Date       :           |"+bill.getStartDate());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"End Date         :           |"+bill.getEndDate());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Unit Consumed   :           |"+bill.getUnitsConsumed());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Fixed charge    :           |"+bill.getFixedCharge());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Tax              :           |"+bill.getTax());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Adjustment       :           |"+bill.getAdjustment());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Total amount     :           |"+bill.getTotalAmount());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Is Paid          :           |"+bill.getIsPaid());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Amount due      :           |"+bill.getAmount_due());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Amount Paid     :           |"+bill.getAmount_paid());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Due Date         :           |"+bill.getDue_date());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Payment Date     :           |"+bill.getPayment_date());
				
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"-------------------------------------------------------------|"+ConsoleColors.RESET);
				
			});
	
			
		} catch (AdministratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public static void ViewBillByconsumerIdUseCase() {
		
		List<Bill> list=new ArrayList<>();
		
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Consumer id : ");
		int c_id=sc.nextInt();
		try {
			list=dao.viewBillbyConsumerid(c_id);
			
			list.forEach(bill->{
				System.out.println(ConsoleColors.WHITE_BACKGROUND+"------------------------------------------------------------");
				
				System.out.println(ConsoleColors.GREEN_BOLD+"--------------------------------------");
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Bill Id         :           |"+bill.getId());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Consumer id     :           |"+bill.getConsumer_id());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Start Date       :           |"+bill.getStartDate());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"End Date         :           |"+bill.getEndDate());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Unit Consumed   :           |"+bill.getUnitsConsumed());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Fixed charge    :           |"+bill.getFixedCharge());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Tax              :           |"+bill.getTax());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Adjustment       :           |"+bill.getAdjustment());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Total amount     :           |"+bill.getTotalAmount());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Is Paid          :           |"+bill.getIsPaid());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Amount due      :           |"+bill.getAmount_due());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+" Amount Paid     :           |"+bill.getAmount_paid());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Due Date         :           |"+bill.getDue_date());
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Payment Date     :           |"+bill.getPayment_date());
				
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"-------------------------------------------------------------|"+ConsoleColors.RESET);
				
			});
	
			
		} catch (AdministratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ViewAllPaidBills() {
		
		List<Bill> list=new ArrayList<>();
		
		
		try {
			list=dao.ViewAllBillsPaid();
			
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
	
			
		} catch (AdministratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void ViewAllPendingBills() {
		
		List<Bill> list=new ArrayList<>();
		
		
		try {
			list=dao.ViewAllBillsPending();
			
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
	
			
		} catch (AdministratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void DeleteConsumerById() {
		
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Consumer id : ");
		int c_id=sc.nextInt();
		
		try {
			String res=dao.DeleteConsumerById(c_id);
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+res);
		} catch (AdministratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

















