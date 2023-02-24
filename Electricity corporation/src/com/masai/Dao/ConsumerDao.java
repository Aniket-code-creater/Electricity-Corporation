package com.masai.Dao;

import java.util.List;

import com.masai.Exceptions.ConsumerException;
import com.masai.model.Bill;
import com.masai.model.Consumer;

public interface ConsumerDao {
	
	public Consumer LoginConsumer(String c_username, String Password) throws ConsumerException;
	
	public String PaybillByConsumerId(int Consumer_id, int Bill_id,double amount) throws ConsumerException;
	
	public List<Bill> ViewHisOwnTransactionHistory(int Consumer_id) throws ConsumerException;
	

}
