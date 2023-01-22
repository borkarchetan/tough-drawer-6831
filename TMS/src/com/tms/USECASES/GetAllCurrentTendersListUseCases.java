package com.tms.USECASES;

import java.util.List;

import com.tms.DAO.VendorDao;
import com.tms.DAO.VendorDaoImpl;
import com.tms.MODEL.Tender;

;

public class GetAllCurrentTendersListUseCases {

	public static void main(String[] args) {

		VendorDao vendor = new VendorDaoImpl();

		try {

			List<Tender> tendors = vendor.getAllCurrentTendersList();
			tendors.forEach(t -> System.out.println(t));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
