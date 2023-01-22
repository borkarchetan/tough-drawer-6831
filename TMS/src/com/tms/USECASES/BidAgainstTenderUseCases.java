package com.tms.USECASES;

import java.util.Scanner;

import com.tms.DAO.VendorDao;
import com.tms.DAO.VendorDaoImpl;

public class BidAgainstTenderUseCases {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Vendor id: ");
		int vid = sc.nextInt();

		System.out.println("Enter tender id: ");
		int tid = sc.nextInt();

		System.out.println("Enter bid Amount: ");
		int bidAmt = sc.nextInt();

		System.out.println("Enter bid deadline: ");
		String biddeadline = sc.next();

		try {

			VendorDao vendor = new VendorDaoImpl();

			String str = vendor.bidAgainstTender(tid, vid, bidAmt, biddeadline);
			System.out.println(str);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
