package com.masai.model;

import java.sql.Date;
import java.time.LocalDate;

public class Bill {
    private int id;
    private String consumerName;
    private Date startDate;
    private Date endDate;
    private int unitsConsumed;
    private double fixedCharge;
    private double tax;
    private double adjustment;
    private double totalAmount;
    private boolean isPaid;
	public Bill() {
		
	}
	public Bill(int id, String consumerName, Date startDate, Date endDate, int unitsConsumed, double fixedCharge,
			double tax, double adjustment, double totalAmount, boolean isPaid) {
		super();
		this.id = id;
		this.consumerName = consumerName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.unitsConsumed = unitsConsumed;
		this.fixedCharge = fixedCharge;
		this.tax = tax;
		this.adjustment = adjustment;
		this.totalAmount = totalAmount;
		this.isPaid = isPaid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
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
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", consumerName=" + consumerName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", unitsConsumed=" + unitsConsumed + ", fixedCharge=" + fixedCharge + ", tax=" + tax + ", adjustment="
				+ adjustment + ", totalAmount=" + totalAmount + ", isPaid=" + isPaid + "]";
	}

    // Constructor, getters and setters
	
	
	
	
    
    
}

