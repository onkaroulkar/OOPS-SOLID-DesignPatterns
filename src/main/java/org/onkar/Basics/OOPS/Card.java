package org.onkar.Basics.OOPS;

abstract public class Card implements PaymentMethod {
	
	protected String cardNo;
	protected String userName;
	
	public Card(String cardNo, String userName) {
		super();
		this.cardNo = cardNo;
		this.userName = userName;
	}

	 public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
