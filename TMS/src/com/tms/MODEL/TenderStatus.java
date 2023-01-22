package com.tms.MODEL;

public class TenderStatus {

	private int tsTdrId;
	private int tsbidId;
	private String status;
	private int tsVdrId;

	public TenderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TenderStatus(int tsTdrId, int tsbidId, String status, int tsVdrId) {
		super();
		this.tsTdrId = tsTdrId;
		this.tsbidId = tsbidId;
		this.status = status;
		this.tsVdrId = tsVdrId;
	}

	@Override
	public String toString() {
		return "TenderStatus [tsTdrId=" + tsTdrId + ", tsbidId=" + tsbidId + ", status=" + status + ", tsVdrId="
				+ tsVdrId + "]";
	}

	public int getTsTdrId() {
		return tsTdrId;
	}

	public void setTsTdrId(int tsTdrId) {
		this.tsTdrId = tsTdrId;
	}

	public int getTsbidId() {
		return tsbidId;
	}

	public void setTsbidId(int tsbidId) {
		this.tsbidId = tsbidId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTsVdrId() {
		return tsVdrId;
	}

	public void setTsVdrId(int tsVdrId) {
		this.tsVdrId = tsVdrId;
	}

}
