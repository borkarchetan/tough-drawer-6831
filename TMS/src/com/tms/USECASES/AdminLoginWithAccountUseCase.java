package com.tms.USECASES;

import java.util.Scanner;

import com.tms.DAO.AdministratorDao;
import com.tms.DAO.AdministratorDaoImpl;

public class AdminLoginWithAccountUseCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Admin Username: ");
		String adminUserName = sc.next();

		System.out.println("Enter Addmin Password: ");
		String adminPassword = sc.next();

		try {

			AdministratorDao admin = new AdministratorDaoImpl();

//			Boolean adminIsPresent = admin.adminLogin(adminUserName, adminPassword);

			Boolean adminIsPresent = admin.adminLoginWithAccount(adminUserName, adminPassword);
			if (adminIsPresent) {

				while (true) {
					System.out.println();
					System.out.println("==========================================================");
					System.out.println();

					System.out.println("Enter 1 to register new vendor");
					System.out.println("Enter 2 to view all vendors");
					System.out.println("Enter 3 to Create new tenders.");
					System.out.println("Enter 4 to view all tendors");
//					System.out.println("Enter 5 to view all bids");
					System.out.println("Enter 5 to View All the Bids of a tender.");
					System.out.println("Enter 6 to Assign tender to a vendor");

					System.out.println("Enter 0 to Logout");
					System.out.println();
					System.out.println("==========================================================");
					System.out.println();

					int num = sc.nextInt();

					switch (num) {

					case 1:
						RegisterNewVendorDetailsUseCases.main(args);
						break;
					case 2:
						ViewAllVendorsDetailsUseCase.main(args);
						break;
					case 3:
						CreateNewTendersUseCase.main(args);
						break;
					case 4:
						ViewAllTenderDetailsUseCase.main(args);
						break;
//					case 5:
//						GetAllBids.main(args);
//						break;
					case 5:
						ViewAllBidsOfTenderUseCase.main(args);
						break;
					case 6:
						AssignTendorToVendorUseCases.main(args);
						break;
					case 0: {
						System.out.println("Logout Succsfull....");
						return;
					}
					default:
						System.out.println("Select valid option");

					}

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
