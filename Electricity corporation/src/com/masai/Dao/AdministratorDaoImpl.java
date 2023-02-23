package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		Administrator admin=null;
		try(Connection conn =DBUtils.connectToDatabase()){
			PreparedStatement pt=conn.prepareStatement("select * from Administrator where ad_email=? AND ad_password=?");
			pt.setString(1, ad_email);
			pt.setString(2, password);
			
			ResultSet rs=pt.executeQuery();
			
			if(rs.next()) {
				admin=new Administrator();
				admin.setAdmin_id(rs.getInt("admin_id"));
				admin.setAd_username(rs.getString("ad_username"));
				admin.setAd_email(rs.getString("ad_email"));
				admin.setAd_password(rs.getString("ad_password"));
			}else {
				throw new AdministratorException("Invalid Admin Password and Email!");
			}
			
		}catch(SQLException ex) {
			
			ex.printStackTrace();
			throw new AdministratorException(ex.getMessage());
		}
		
		
		return admin;
	}

	@Override
	public String RegisterConsumer(Consumer consumer) throws AdministratorException {
		// TODO Auto-generated method stub
		String res="Consumer Not Registered yet";
		
		try(Connection conn=DBUtils.connectToDatabase()){
			
			PreparedStatement pt=conn.prepareStatement("insert into Consumer (consumer_id, admin_id, c_username,c_password,is_active) values(?,?,?,?,?)");
			
			pt.setInt(1, consumer.getConsumer_id());
			pt.setInt(2, consumer.getAdmin_id());
			pt.setString(3, consumer.getC_username());
			pt.setString(4, consumer.getC_password());
			pt.setString(5, consumer.getIs_active());
			
			int x=pt.executeUpdate();
			if(x>0) {
				res="Consumer Added Successfully";
			}
			
			
		}catch(SQLException ex) {
			res=ex.getMessage();
			
		}
		return res;
	}

	@Override
	public List<Consumer> VeiwAllconsumer() throws AdministratorException {
		// TODO Auto-generated method stub
		List<Consumer> consumer = new ArrayList<>();
		try(Connection conn=DBUtils.connectToDatabase()){
			
			PreparedStatement pt=conn.prepareStatement("select * from consumer");
			
			ResultSet set=pt.executeQuery();
			
			while(set.next()) {
				int c_id=set.getInt("consumer_id");
				int admin_id=set.getInt("admin_id");
				String username=set.getString("c_username");
				String pass=set.getString("c_password");
				String status=set.getString("is_active");
				
				Consumer c=new Consumer(c_id,admin_id,username,pass,status);
				consumer.add(c);
			}
			
		
			
			
		}catch(SQLException ex) {
			throw new AdministratorException(ex.getMessage());
			
		}
		
		
		return consumer;
	}

	@Override
	public List<Bill> viewBillbyConsumerid(int consumer_id) throws AdministratorException {
		// TODO Auto-generated method stub
		List<Bill> list=new ArrayList<>();
		Bill bill=null;
		try(Connection conn =DBUtils.connectToDatabase()){
			PreparedStatement pt=conn.prepareStatement("select * from Bill where consumer_id=?");
			pt.setInt(1, consumer_id);
			
			
			ResultSet rs=pt.executeQuery();
			
			while(rs.next()) {
				bill=new Bill();
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
			throw new AdministratorException(ex.getMessage());
		}
		
		
		return list;
	}

	@Override
	public List<Bill> ViewAllBills() throws AdministratorException {
		// TODO Auto-generated method stub
		List<Bill> list = new ArrayList<>();
		try(Connection conn =DBUtils.connectToDatabase()){
			PreparedStatement pt=conn.prepareStatement("select * from Bill");
			
			
			
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
				
			}
			
		}catch(SQLException ex) {
			
			ex.printStackTrace();
			throw new AdministratorException(ex.getMessage());
		}
		
		return list;
	}

	@Override
	public List<Bill> ViewAllBillsPaid() throws AdministratorException {
		
		// TODO Auto-generated method stub
		
		List<Bill> list = new ArrayList<>();
		try(Connection conn =DBUtils.connectToDatabase()){
			PreparedStatement pt=conn.prepareStatement("select * from Bill where isPaid ='Yes'");
//			pt.setString(1, c);
			
			
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
			throw new AdministratorException(ex.getMessage());
		}
		
		return list;
	}

	@Override
	public String DeleteConsumerById(int consumer_id) throws AdministratorException {

		String res="Not Deleted Yet";
		try(Connection conn=DBUtils.connectToDatabase()){
			
			PreparedStatement pt=conn.prepareStatement("Update consumer set is_active='No' where consumer_id=?");
			
			pt.setInt(1, consumer_id);
			
			
			int x=pt.executeUpdate();
			if(x>0) {
				res="Consumer Deleted Successfully";
			}
			
			
		}catch(SQLException ex) {
			res=ex.getMessage();
			
		}
		return res;
	}

	

	@Override
	public List<Bill> ViewAllBillsPending() throws AdministratorException {
		// TODO Auto-generated method stub
		List<Bill> list = new ArrayList<>();
		try(Connection conn =DBUtils.connectToDatabase()){
			PreparedStatement pt=conn.prepareStatement("select * from Bill where isPaid='No'");
			
			
			
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
			throw new AdministratorException(ex.getMessage());
		}
		
		return list;
	}

}
