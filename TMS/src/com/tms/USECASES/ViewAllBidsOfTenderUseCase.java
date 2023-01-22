package com.tms.USECASES;

import java.util.List;
import java.util.Scanner;

import com.tms.DAO.AdministratorDao;
import com.tms.DAO.AdministratorDaoImpl;
import com.tms.MODEL.Bidder;

public class ViewAllBidsOfTenderUseCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your tenderId: ");
		int tid = sc.nextInt();

		AdministratorDao admin = new AdministratorDaoImpl();

		try {

			List<Bidder> bids = admin.ViewAllBidsOfTender(tid);
			System.out.println(bids);
			bids.forEach(b -> System.out.println(b));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
