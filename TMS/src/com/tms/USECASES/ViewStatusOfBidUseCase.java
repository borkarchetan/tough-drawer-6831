package com.tms.USECASES;

import java.util.Scanner;

import com.tms.DAO.VendorDao;
import com.tms.DAO.VendorDaoImpl;

public class ViewStatusOfBidUseCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Your Bidder ID : ");
		int bid = sc.nextInt();

		VendorDao vendor = new VendorDaoImpl();

		try {

			String str = vendor.ViewStatusOfBid(bid);
			System.out.println(str);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
