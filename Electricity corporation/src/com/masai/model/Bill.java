package com.masai.model;

import java.sql.Date;
import java.time.LocalDate;

public class Bill {
    private int id;
    private int consumer_id;
    private Date startDate;
    private Date endDate;
    private int unitsConsumed;
    private double fixedCharge;
    private double tax;
    private double adjustment;
    private double totalAmount;
    private String isPaid;
    private double amount_due;
    private double amount_paid;
    private Date due_date;
    private Date payment_date;
    
	public Bill() {
		
	}

	public Bill(int id, int consumer_id, Date startDate, Date endDate, int unitsConsumed, double fixedCharge,
			double tax, double adjustment, double totalAmount, String isPaid, double amount_due, double amount_paid,
			Date due_date, Date payment_date) {
		super();
		this.id = id;
		this.consumer_id = consumer_id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.unitsConsumed = unitsConsumed;
		this.fixedCharge = fixedCharge;
		this.tax = tax;
		this.adjustment = adjustment;
		this.totalAmount = totalAmount;
		this.isPaid = isPaid;
		this.amount_due = amount_due;
		this.amount_paid = amount_paid;
		this.due_date = due_date;
		this.payment_date = payment_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(int consumer_id) {
		this.consumer_id = consumer_id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public double getFixedCharge() {
		return fixedCharge;
	}

	public void setFixedCharge(double fixedCharge) {
		this.fixedCharge = fixedCharge;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(double adjustment) {
		this.adjustment = adjustment;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public double getAmount_due() {
		return amount_due;
	}

	public void setAmount_due(double amount_due) {
		this.amount_due = amount_due;
	}

	public double getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(double amount_paid) {
		this.amount_paid = amount_paid;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", consumer_id=" + consumer_id + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", unitsConsumed=" + unitsConsumed + ", fixedCharge=" + fixedCharge + ", tax=" + tax + ", adjustment="
				+ adjustment + ", totalAmount=" + totalAmount + ", isPaid=" + isPaid + ", amount_due=" + amount_due
				+ ", amount_paid=" + amount_paid + ", due_date=" + due_date + ", payment_date=" + payment_date + "]";
	}
	
    
	
	
	
	
    
    
}

