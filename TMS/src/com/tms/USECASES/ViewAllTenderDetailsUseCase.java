package com.tms.USECASES;

import java.util.List;

import com.tms.DAO.AdministratorDao;
import com.tms.DAO.AdministratorDaoImpl;
import com.tms.MODEL.Tender;

public class ViewAllTenderDetailsUseCase {

	public static void main(String[] args) {

		AdministratorDao admin = new AdministratorDaoImpl();

		try {

			List<Tender> tendors = admin.ViewAllTenderDetails();
			tendors.forEach(t -> System.out.println(t));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
