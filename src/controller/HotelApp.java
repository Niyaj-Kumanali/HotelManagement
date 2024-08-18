package controller;

import java.util.Scanner;

import service.HotelService;
import serviceImpl.HotelServiceImpl;

public class HotelApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HotelService app = new HotelServiceImpl();

		System.out.println("=============== Welcome to Management System ===============");
		while (true) {
			System.out.println("=============== MENU ================");
			System.out.println(
					"1. Room Details\n2. Available Rooms\n3. Allocate Room\n4. Checkout\n5. Find All Customers\n6. Find Customer By ID\n7. Exit");
			System.out.print("Enter you option : ");
			int option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				app.roomInfo();
				break;
			case 2:
				app.availableRooms();
				break;
			case 3:
				app.allocateRoom();
				break;
			case 4:
				app.checkout();
				break;

			case 5:
				app.findAllCustomer();
				break;
			case 6:
				app.getCustomerByID();
				break;
			case 7:
				sc.close();
				System.exit(0);
			default:
				System.err.println("Invalid option");
			}
		}
	}

}
