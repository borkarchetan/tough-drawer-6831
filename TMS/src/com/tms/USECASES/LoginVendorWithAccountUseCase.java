package com.tms.USECASES;

import java.util.Scanner;

import com.tms.DAO.VendorDao;
import com.tms.DAO.VendorDaoImpl;
import com.tms.MODEL.Vendor;

public class LoginVendorWithAccountUseCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Vendor Username: ");
		String vendorUserName = sc.next();

		System.out.println("Enter Vendor Password: ");
		String vendorPassword = sc.next();

		try {

			VendorDao vendor = new VendorDaoImpl();

			Vendor vendor1 = vendor.loginVendorWithAccount(vendorUserName, vendorPassword);

			System.out.println("=========== Welcome " + vendorUserName + " ===========");

			System.out.println(vendor1);
			if (vendor1 != null) {

				while (true) {

					System.out.println();
					System.out.println(" =========================================================== ");
					System.out.println();

					System.out.println("Press 1 to view all the current Tenders.");
					System.out.println("Press 2 to place a Bid against a Tender.");
					System.out.println("Press 3 to view status of a Bid(Whether Selected or Not)");
					System.out.println("Press 4 to view his own Bid History.");
					System.out.println("Enter 5 to Logout");

					System.out.println();
					System.out.println(" =========================================================== ");
					System.out.println();

					int num = sc.nextInt();

					switch (num) {

					case 1:
						ViewAllTenderDetailsUseCase.main(args);
						break;
					case 2:
						BidAgainstTenderUseCases.main(args);
						break;
					case 3:
						ViewStatusOfBidUseCase.main(args);
						break;
					case 4:
						ViewVendorBidHistoryUseCase.main(args);
						break;
					case 5: {
						System.out.println("Vendor " + vendorUserName + " Logout Succsfull....");
						return;
					}
					default:
						System.out.println("Please Try Again..");

					}

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
