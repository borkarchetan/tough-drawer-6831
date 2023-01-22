package com.tms.MODEL;

public class Vendor {

	private int vdrId;
	private String vdrPassword;
	private String vdrName;
	private String vdrMobile;
	private String vdrEmail;
	private String vdrCompany;
	private String vdrAddress;

	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vendor(String vdrPassword, String vdrName, String vdrMobile, String vdrEmail, String vdrCompany,
			String vdrAddress) {
		super();

		this.vdrPassword = vdrPassword;
		this.vdrName = vdrName;
		this.vdrMobile = vdrMobile;
		this.vdrEmail = vdrEmail;
		this.vdrCompany = vdrCompany;
		this.vdrAddress = vdrAddress;
	}

	public Vendor(int vdrId, String vdrPassword, String vdrName, String vdrMobile, String vdrEmail, String vdrCompany,
			String vdrAddress) {
		super();
		this.vdrId = vdrId;
		this.vdrPassword = vdrPassword;
		this.vdrName = vdrName;
		this.vdrMobile = vdrMobile;
		this.vdrEmail = vdrEmail;
		this.vdrCompany = vdrCompany;
		this.vdrAddress = vdrAddress;
	}

	@Override
	public String toString() {
		return "Vendor [vdrId=" + vdrId + ", vdrPassword=" + vdrPassword + ", vdrName=" + vdrName + ", vdrMobile="
				+ vdrMobile + ", vdrEmail=" + vdrEmail + ", vdrCompany=" + vdrCompany + ", vdrAddress=" + vdrAddress
				+ "]";
	}

	public int getVdrId() {
		return vdrId;
	}

	public void setVdrId(int vdrId) {
		this.vdrId = vdrId;
	}

	public String getVdrPassword() {
		return vdrPassword;
	}

	public void setVdrPassword(String vdrPassword) {
		this.vdrPassword = vdrPassword;
	}

	public String getVdrName() {
		return vdrName;
	}

	public void setVdrName(String vdrName) {
		this.vdrName = vdrName;
	}

	public String getVdrMobile() {
		return vdrMobile;
	}

	public void setVdrMobile(String vdrMobile) {
		this.vdrMobile = vdrMobile;
	}

	public String getVdrEmail() {
		return vdrEmail;
	}

	public void setVdrEmail(String vdrEmail) {
		this.vdrEmail = vdrEmail;
	}

	public String getVdrCompany() {
		return vdrCompany;
	}

	public void setVdrCompany(String vdrCompany) {
		this.vdrCompany = vdrCompany;
	}

	public String getVdrAddress() {
		return vdrAddress;
	}

	public void setVdrAddress(String vdrAddress) {
		this.vdrAddress = vdrAddress;
	}

}
