package com.tms.USECASES;

import java.util.List;
import java.util.Scanner;

import com.tms.DAO.VendorDao;
import com.tms.DAO.VendorDaoImpl;
import com.tms.MODEL.Bidder;

public class ViewVendorBidHistoryUseCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your vendor id: ");
		int vid = sc.nextInt();

		VendorDao vendor = new VendorDaoImpl();

		try {

			List<Bidder> bids = vendor.viewVendorBidHistory(vid);

			bids.forEach(b -> System.out.println(b));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
