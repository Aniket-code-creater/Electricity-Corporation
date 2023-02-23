package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.masai.Exceptions.AdministratorException;
import com.masai.Utility.DBUtils;
import com.masai.model.Administrator;
import com.masai.model.Bill;
import com.masai.model.Consumer;

public class AdministratorDaoImpl implements AdministratorDao{

	@Override
	public Administrator LoginAdminAcount(String ad_email, String password) throws AdministratorException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String RegisterConsumer(Consumer consumer) throws AdministratorException {
		// TODO Auto-generated method stub
		String res="Not Registered";
		
		try(Connection conn=DBUtils.connectToDatabase()){
			
			PreparedStatement pt=conn.prepareStatement("insert into Consumer (consumer_id, admin_id, c_username,c_password,is_active)");
			
			pt.setInt(1, consumer.getConsumer_id());
			pt.setInt(2, consumer.getAdmin_id());
			pt.setString(3, consumer.getC_username());
			pt.setString(4, consumer.getC_password());
			pt.setBoolean(5, true);
			
		}catch(SQLException ex) {
			res=ex.getMessage();
			
		}
		return res;
	}

	@Override
	public List<Consumer> VeiwAllconsumer() throws AdministratorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill viewBillbyConsumerid(int consumer_id) throws AdministratorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> ViewAllBills() throws AdministratorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> ViewAllBillsPaid() throws AdministratorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DeleteConsumerById(int consumer_id) throws AdministratorException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Bill> ViewAllBillsPending() throws AdministratorException {
		// TODO Auto-generated method stub
		return null;
	}

}
