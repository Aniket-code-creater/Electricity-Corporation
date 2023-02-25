package com.masai.main;

import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;
import com.masai.Dao.ConsumerDao;
import com.masai.Dao.ConsumerDaoImpl;
import com.masai.Exceptions.AdministratorException;
import com.masai.Exceptions.ConsumerException;
import com.masai.customcolor.ConsoleColor.ConsoleColors;
import com.masai.model.Administrator;
import com.masai.model.Consumer;
import com.masai.usecase.AdminUseCase;
import com.masai.usecase.ConsumerUseCase;

public class Main {
	static Scanner sc= new Scanner(System.in);
	public static final AdministratorDao dao= new AdministratorDaoImpl();
	public static final ConsumerDao CDao= new ConsumerDaoImpl();
	
	public static void main(String[] args) {
		System.out.println(ConsoleColors.WHITE_BACKGROUND+"-------------------------------------------------------");
		System.out.println(ConsoleColors.GREEN_BOLD+"|| Please Choose Your Action :-");
		System.out.println(ConsoleColors.GREEN_BOLD+"--------------------------------------");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[1] Admin Login                    |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[2] Consumer Login                 |");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"[3] Exit                           |");
		
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"----------------------------------------------------------|"+ConsoleColors.RESET);
		
		System.out.println(" ");
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Please Enter Your Choice :");
		
		int choice =sc.nextInt();
		switch(choice) {
		case 1:{
				LoginAdmin(args);
				break;
		}
		case 2:{
			Login(args);
			break;
			
		}
		case 3:{
//			System.out.println("ThanYou for useing Application! Visit Again");
			System.out.println(ConsoleColors.GREEN_BOLD+"ThanYou for useing Application! Visit Again ");
			break;
		}
		default :
			System.out.println("Oops! Invalid choice");
		Main m=new Main();
		m.main(args);
		
		
		
		}
	}
	
	
	public static void LoginAdmin(String[] args) {
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Admin Email :");
		String email=sc.next();
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Password :");
		String pass=sc.next();
		Administrator ad= new Administrator();
		try {
			ad=dao.LoginAdminAcount(email, pass);
			System.out.println(ConsoleColors.GREEN_BOLD+"Welcome "+ad.getAd_username());
//			System.out.println("-----------------------------------------------------");
			
			
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Id : "+ad.getAdmin_id());
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Name : "+ad.getAd_username());
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Email : "+ad.getAd_email());
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Password : "+ad.getAd_password());
			
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"-------------------------------------------------------");
			
			
			
			AdminUseCase admin=new AdminUseCase();
			admin.main(args);
			
			
		} catch (AdministratorException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void Login(String[] args) {
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Consumer Name :");
		String Username=sc.next();
		System.out.println(ConsoleColors.YELLOW_UNDERLINED+"Enter Password :");
		String password=sc.next();
		Consumer conn= new Consumer();
		try {
			conn=CDao.LoginConsumer(Username, password);
			System.out.println(ConsoleColors.GREEN_BOLD+"Welcome "+ conn.getC_username());
//			System.out.println("-----------------------------------------------------");
			
			
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Consumer Id : "+conn.getConsumer_id());
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Admin Id : "+ conn.getAdmin_id());
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Consumer Name : "+ conn.getC_username());
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Comsumer Password : "+conn.getC_password());
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+ConsoleColors.BLACK_BOLD+"Consumer Active status: "+conn.getIs_active());
			
			System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"-------------------------------------------------------");
			
			ConsumerUseCase con =new  ConsumerUseCase();
			con.main(args);
			
		} catch (ConsumerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		
		
		
	}

}
