package com.redress.interfaces;

public interface CustomerInterface {
	
	public abstract String showCustomerInfoByUserID();
	public abstract String showComplaintsByUserID();
	public abstract String showComplaintByUserAndComplaintID();
	public abstract String showFeedbackByComplaintID();
	public abstract String showProductsOwnedByUserID();
	

	public abstract String addComplaint();
	public abstract String addFeedback();
	public abstract String editFeedbackByComplaintID();
	
	public abstract String sendMessage();
}
