package com.tms.RUN;

import java.util.Scanner;

import com.tms.USECASES.AdminLoginWithAccountUseCase;
import com.tms.USECASES.LoginVendorWithAccountUseCase;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*WELCOME TO RK TENDER MANAGEMENT STYSTEM*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println();
		while (true) {

			System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
			System.out.println("*                                                           +");

			System.out.println("PRESS 1 FOR ADMINISTRATOR LOGIN");

			System.out.println("PRESS 2 FOR VENDOR LOGIN INTO APPLICATION");

			System.out.println("PRESS 3 TO CLOSE THE APPLICATION");

			System.out.println("+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+**+*+*");
			System.out.println();

			int n = sc.nextInt();

			if (n == 1) {

				AdminLoginWithAccountUseCase.main(args);

			} else if (n == 2) {
				LoginVendorWithAccountUseCase.main(args);
			} else {
				System.out.println("Application closed successfully...");
				return;
			}

		}

	}

}
