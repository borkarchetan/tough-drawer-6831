package com.tms.USECASES;

import java.text.ParseException;
import java.util.Scanner;

import com.tms.DAO.AdministratorDao;
import com.tms.DAO.AdministratorDaoImpl;
import com.tms.MODEL.Tender;

public class CreateNewTendersUseCase {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		AdministratorDao admin = new AdministratorDaoImpl();

		System.out.println("Enter Tender Name : ");
		String tdrName = sc.nextLine();

		System.out.println("Enter Tender Type : ");
		String tdrType = sc.nextLine();

		System.out.println("Enter Tender Amount : ");
		int tdrAmount = sc.nextInt();

		sc.nextLine();
		System.out.println("Enter Tender DeadLine" + " YYYY-MM-DD");
		String tdrDeadline = sc.nextLine();

		System.out.println("Enter tender Address: ");
		String tdrAddress = sc.nextLine();

		try {

			String str = admin.CreateNewTenders(new Tender(tdrName, tdrType, tdrAmount, tdrDeadline, tdrAddress));
			System.out.println(str);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
