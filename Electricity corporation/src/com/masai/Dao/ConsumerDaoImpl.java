package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Exceptions.AdministratorException;
import com.masai.Exceptions.ConsumerException;
import com.masai.Utility.DBUtils;
import com.masai.model.Administrator;
import com.masai.model.Bill;
import com.masai.model.Consumer;

public class ConsumerDaoImpl implements ConsumerDao{

	@Override
	public Consumer LoginConsumer(String c_username, String Password) throws ConsumerException {
		// TODO Auto-generated method stub
		
		Consumer consumer=null;
		try(Connection conn =DBUtils.connectToDatabase()){
			PreparedStatement pt=conn.prepareStatement("select * from Consumer where c_username=? AND c_password=?");
			pt.setString(1, c_username);
			pt.setString(2, Password);
			
			ResultSet rs=pt.executeQuery();
			
			if(rs.next()) {
				consumer=new Consumer();
//				admin.setAdmin_id(rs.getInt("admin_id"));
				consumer.setConsumer_id(rs.getInt("consumer_id"));
				consumer.setAdmin_id(rs.getInt("admin_id"));
				consumer.setC_username(rs.getString("c_username"));
				consumer.setC_password(rs.getString("c_password"));
				consumer.setIs_active(rs.getString("is_active"));
			}else {
				System.out.println("Invalid Password And Name");
				throw new ConsumerException("Invalid Password and UserName!");
			}
			
		}catch(SQLException ex) {
			
			ex.printStackTrace();
//			throw new ConsumerException(ex.getMessage());
		}
		
		
		return consumer;
		
		
	}

	@Override
	public String PaybillByConsumerId(int Consumer_id, int Bill_id,double amount) throws ConsumerException {
		// TODO Auto-generated method stub
		String res="Not Pay Yet!";
		try(Connection conn=DBUtils.connectToDatabase()){
			
			PreparedStatement pt=conn.prepareStatement("Update Bill  set isPaid='Yes',amount_paid=amount_paid+?,payment_date=current_date,amount_due=total_amount-amount_paid where consumer_id=? And Bill_id=?");
			
			pt.setDouble(1, amount);
			pt.setInt(2, Consumer_id);
			pt.setInt(3, Bill_id);
			
			
			int x=pt.executeUpdate();
			if(x>0) {
				res="Congratulation! Payment Successfully";
			}
			
			
		}catch(SQLException ex) {
			res=ex.getMessage();
			
		}
		return res;
	}

	@Override
	public List<Bill> ViewHisOwnTransactionHistory(int Consumer_id) throws ConsumerException {
		// TODO Auto-generated method stub
		List<Bill> list = new ArrayList<>();
		try(Connection conn =DBUtils.connectToDatabase()){
			PreparedStatement pt=conn.prepareStatement("select * from Bill where consumer_id=?");
			pt.setInt(1, Consumer_id);
			
			
			
			ResultSet rs=pt.executeQuery();
			
			while(rs.next()) {
				Bill bill=new Bill();
//				bill.setAdmin_id(rs.getInt("admin_id"));
				bill.setId(rs.getInt("bill_id"));
				bill.setConsumer_id(rs.getInt("consumer_id"));
				bill.setStartDate(rs.getDate("start_date"));
				bill.setEndDate(rs.getDate("end_date"));
				bill.setUnitsConsumed(rs.getInt("unit_consumed"));
				bill.setFixedCharge(rs.getDouble("fixed_charge"));
				bill.setTax(rs.getDouble("tax"));
				bill.setAdjustment(rs.getDouble("adjustment"));
				bill.setTotalAmount(rs.getDouble("total_amount"));
				bill.setIsPaid(rs.getString("isPaid"));
				bill.setAmount_due(rs.getDouble("amount_due"));
				bill.setAmount_paid(rs.getDouble("amount_paid"));
				bill.setDue_date(rs.getDate("due_date"));
				bill.setPayment_date(rs.getDate("payment_date"));
				list.add(bill);
				
			}
			
		}catch(SQLException ex) {
			
			ex.printStackTrace();
			throw new ConsumerException(ex.getMessage());
		}
		
		return list;
	}

}
