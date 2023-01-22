package com.tms.MODEL;

public class Administrator {

	private int adminId;
	private String adminUserName;
	private String adminEmail;
	private String adminPassword;

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(int adminId, String adminUserName, String adminEmail, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUserName = adminUserName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Administrator [adminId=" + adminId + ", adminUserName=" + adminUserName + ", adminEmail=" + adminEmail
				+ ", adminPassword=" + adminPassword + "]";
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
