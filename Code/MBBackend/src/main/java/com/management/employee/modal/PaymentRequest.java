package com.management.employee.modal;

public class PaymentRequest {
	
	private String token;
	private String cardId;
	private Long tokenCreated;
	private Double amount; 
	private Long subscriptionId;
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public Long getTokenCreated() {
		return tokenCreated;
	}
	public void setTokenCreated(Long tokenCreated) {
		this.tokenCreated = tokenCreated;
	}
	/**
	 * @return the subscriptionId
	 */
	public Long getSubscriptionId() {
		return subscriptionId;
	}
	/**
	 * @param subscriptionId the subscriptionId to set
	 */
	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	
	
	

}
