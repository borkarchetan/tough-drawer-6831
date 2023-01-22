package com.tms.MODEL;

public class Tender {

	private int tdrId;
	private String tdrName;
	private String tdrType;
	private int tdrAmount;
	private String tdrDeadline;
	private String tdrAddress;

	public Tender() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tender(String tdrName, String tdrType, int tdrAmount, String tdrDeadline, String tdrAddress) {
		super();

		this.tdrName = tdrName;
		this.tdrType = tdrType;
		this.tdrAmount = tdrAmount;
		this.tdrDeadline = tdrDeadline;
		this.tdrAddress = tdrAddress;
	}

	public Tender(int tdrId, String tdrName, String tdrType, int tdrAmount, String tdrDeadline, String tdrAddress) {
		super();
		this.tdrId = tdrId;
		this.tdrName = tdrName;
		this.tdrType = tdrType;
		this.tdrAmount = tdrAmount;
		this.tdrDeadline = tdrDeadline;
		this.tdrAddress = tdrAddress;
	}

	@Override
	public String toString() {
		return "Tender [tdrId=" + tdrId + ", tdrName=" + tdrName + ", tdrType=" + tdrType + ", tdrAmount=" + tdrAmount
				+ ", tdrDeadline=" + tdrDeadline + ", tdrAddress=" + tdrAddress + "]";
	}

	public int getTdrId() {
		return tdrId;
	}

	public void setTdrId(int tdrId) {
		this.tdrId = tdrId;
	}

	public String getTdrName() {
		return tdrName;
	}

	public void setTdrName(String tdrName) {
		this.tdrName = tdrName;
	}

	public String getTdrType() {
		return tdrType;
	}

	public void setTdrType(String tdrType) {
		this.tdrType = tdrType;
	}

	public int getTdrAmount() {
		return tdrAmount;
	}

	public void setTdrAmount(int tdrAmount) {
		this.tdrAmount = tdrAmount;
	}

	public String getTdrDeadline() {
		return tdrDeadline;
	}

	public void setTdrDeadline(String tdrDeadline) {
		this.tdrDeadline = tdrDeadline;
	}

	public String getTdrAddress() {
		return tdrAddress;
	}

	public void setTdrAddress(String tdrAddress) {
		this.tdrAddress = tdrAddress;
	}

}
