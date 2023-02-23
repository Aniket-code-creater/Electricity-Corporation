package com.masai.Dao;

import java.util.List;

import com.masai.Exceptions.AdministratorException;
import com.masai.model.Administrator;
import com.masai.model.Bill;
import com.masai.model.Consumer;

public interface AdministratorDao {
	public Administrator LoginAdminAcount(String ad_email, String password)throws AdministratorException;
	
	public String RegisterConsumer(Consumer consumer) throws AdministratorException;

	public List<Consumer> VeiwAllconsumer() throws AdministratorException;

	public List<Bill> viewBillbyConsumerid(int consumer_id) throws AdministratorException;
	
	public  List<Bill> ViewAllBills() throws AdministratorException;
	
	public List<Bill> ViewAllBillsPaid() throws AdministratorException;
	public List<Bill> ViewAllBillsPending() throws AdministratorException;
	
	public String DeleteConsumerById(int consumer_id) throws AdministratorException;


}