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

		System.out.println("Enter tender name: ");
		String tdrName = sc.next();

		System.out.println("Enter tender type: ");
		String tdrType = sc.next();

		System.out.println("Enter tender price: ");
		int tdrAmount = sc.nextInt();

//		System.out.println("Enter tender Description: ");
//		String tdesc = sc.nextLine();

		sc.nextLine();
		System.out.println("dd-mm-yyyy");

		String tdrDeadline = sc.nextLine();

		System.out.println("Enter tender location: ");
		String tdrAddress = sc.next();

		try {

			String str = admin.CreateNewTenders(new Tender(tdrName, tdrType, tdrAmount, tdrDeadline, tdrAddress));
			System.out.println(str);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
