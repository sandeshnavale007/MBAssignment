package com.management.employee.modal;

public class SubscriptionResponse {

	private int id;
	private String desc1;
	private String desc2;
	private String desc3;
	private double amount;
	private String details;
	private String Title;
	private boolean status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getDesc2() {
		return desc2;
	}
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}
	public String getDesc3() {
		return desc3;
	}
	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	
	
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	public SubscriptionResponse(int id, String desc1, String desc2, String desc3, double amount, String details,
			String title) {
		super();
		this.id = id;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
		this.amount = amount;
		this.details = details;
		Title = title;
	}

	
	 public SubscriptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public static class SubscriptionResponseBuilder{
		 private int id;
			private String desc1;
			private String desc2;
			private String desc3;
			private double amount;
			private String details;
			private String title;
			
			
	        /**
			 * @param id the id to set
			 */
			public SubscriptionResponseBuilder setId(int id) {
				this.id = id;
				 return this;
			}


			/**
			 * @param desc1 the desc1 to set
			 */
			public SubscriptionResponseBuilder setDesc1(String desc1) {
				this.desc1 = desc1;
				 return this;
			}


			/**
			 * @param desc2 the desc2 to set
			 */
			public SubscriptionResponseBuilder setDesc2(String desc2) {
				this.desc2 = desc2;
				 return this;
			}


			/**
			 * @param desc3 the desc3 to set
			 */
			public SubscriptionResponseBuilder setDesc3(String desc3) {
				this.desc3 = desc3;
				 return this;
			}


			/**
			 * @param amount the amount to set
			 */
			public SubscriptionResponseBuilder setAmount(double amount) {
				this.amount = amount;
				 return this;
			}


			/**
			 * @param details the details to set
			 */
			public SubscriptionResponseBuilder setDetails(String details) {
				this.details = details;
				 return this;
			}


			/**
			 * @param title the title to set
			 */
			public SubscriptionResponseBuilder setTitle(String title) {
				this.title = title;
				 return this;
			}


			public SubscriptionResponse createAPIResponse() {
	            return new SubscriptionResponse(id, desc1, desc2, desc3,amount, details, title);
	        }
	 }
}
