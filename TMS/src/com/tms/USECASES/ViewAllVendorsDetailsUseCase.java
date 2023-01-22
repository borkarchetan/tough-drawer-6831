package com.tms.USECASES;

import java.util.List;

import com.tms.DAO.AdministratorDao;
import com.tms.DAO.AdministratorDaoImpl;
import com.tms.MODEL.Vendor;

public class ViewAllVendorsDetailsUseCase {

	public static void main(String[] args) {

		AdministratorDao admin = new AdministratorDaoImpl();

		try {

			List<Vendor> vendors = admin.ViewAllVendorsDetails();
			vendors.forEach(v -> System.out.println(v));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
