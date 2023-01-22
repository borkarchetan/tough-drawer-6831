package com.tms.MODEL;

public class Bidder {

	private int bidId;
	private int vdrId;
	private int tdrId;
	private int bidAmount;
	private String bidDeadLine;
	private String status;

	public Bidder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bidder(int vdrId, int tdrId, int bidAmount, String bidDeadLine, String status) {
		super();

		this.vdrId = vdrId;
		this.tdrId = tdrId;
		this.bidAmount = bidAmount;
		this.bidDeadLine = bidDeadLine;
		this.status = status;
	}

	public Bidder(int bidId, int vdrId, int tdrId, int bidAmount, String bidDeadline, String status) {
		super();
		this.bidId = bidId;
		this.vdrId = vdrId;
		this.tdrId = tdrId;
		this.bidAmount = bidAmount;
		this.bidDeadLine = bidDeadline;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bidder [bidId=" + bidId + ", vdrId=" + vdrId + ", tdrId=" + tdrId + ", bidAmount=" + bidAmount
				+ ", bidDeadline=" + bidDeadLine + ", status=" + status + "]";
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public int getVdrId() {
		return vdrId;
	}

	public void setVdrId(int vdrId) {
		this.vdrId = vdrId;
	}

	public int getTdrId() {
		return tdrId;
	}

	public void setTdrId(int tdrId) {
		this.tdrId = tdrId;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getBidDeadline() {
		return bidDeadLine;
	}

	public void setBidDeadline(String bidDeadline) {
		this.bidDeadLine = bidDeadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
