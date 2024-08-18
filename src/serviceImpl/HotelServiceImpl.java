package serviceImpl;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeSet;

import dao.HotelRepo;
import entity.Address;
import entity.Customer;
import service.HotelService;

public class HotelServiceImpl implements HotelService, HotelRepo {
	private Scanner sc = new Scanner(System.in);
	
	{
		for (int i = 1; i <= 10; i++) {
			cm.put(i, null);
			if (i <= 8)
				sm.put(i, null);
			if (i <= 5)
				dm.put(i, null);
		}
//		for (int i = 1; i <= 8; i++) {
//			sm.put(i, null);
//		}
//		for (int i = 1; i <= 5; i++) {
//			sm.put(i, null);
//		}
	}

	@Override
	public void roomInfo() {
		System.out.println("\n=============== Classic Rooms ===============");
		System.out.println("Hot Water : Yes");
		System.out.println("AC : No");
		System.out.println("TV : No");
		System.out.println("Wi-Fi : No");
		System.out.println("Price : Rs. 2000");

		System.out.println("\n=============== Standard Rooms ===============");
		System.out.println("Hot Water : Yes");
		System.out.println("AC : No");
		System.out.println("TV : Yes");
		System.out.println("Wi-Fi : No");
		System.out.println("Price : Rs. 2500");

		System.out.println("\n=============== Deluxe Rooms ===============");
		System.out.println("Hot Water : Yes");
		System.out.println("AC : Yes");
		System.out.println("TV : Yes");
		System.out.println("Wi-Fi : Yes");
		System.out.println("Price : Rs. 3500");
	}

	public void checkRoom(LinkedHashMap<Integer, Customer> map) {
		boolean flag = false;
		for (int roomId : map.keySet()) {
			if (map.get(roomId) == null) {
				System.out.print(roomId + " ");
				flag = true;
			}
		}
		System.out.println();
		if (!flag)
			System.out.println("Not rooms are available");
	}

	@Override
	public void availableRooms() {
		System.out.println("======== Available Rooms ==========");
		System.out.println("======== Classic Rooms =========");
		checkRoom(cm);
		System.out.println("======== Standard Rooms =========");
		checkRoom(sm);
		System.out.println("======== Deluxe Rooms =========");
		checkRoom(dm);

	}

	@Override
	public void allocateRoom() {
		System.out.println("=========== MENU ==============");
		System.out.println("1. Classic Room\n2. Standard Room\n3. Deluxe Rooms");
		System.out.print("Enter you choice : ");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			System.out.print("Enter the room number : ");
			int roomNo1 = sc.nextInt();
			if (roomNo1 >= 1 && roomNo1 <= 10) {
				mapRoom(cm, roomNo1, 2000);
			} else {
				System.out.println("Enter correct room number");
			}
			break;
		case 2:
			System.out.print("Enter the room number : ");
			int roomNo2 = sc.nextInt();
			if (roomNo2 >= 1 && roomNo2 <= 8) {
				mapRoom(sm, roomNo2, 2500);
			} else {
				System.out.println("Enter correct room number");
			}
			break;
		case 3:
			System.out.print("Enter the room number : ");
			int roomNo3 = sc.nextInt();
			if (roomNo3 >= 1 && roomNo3 <= 5) {
				mapRoom(dm, roomNo3, 3500);
			} else {
				System.out.println("Enter correct room number");
			}
			break;
		default:
			System.err.println("\nInvalid choice");
		}

	}

	void mapRoom(LinkedHashMap<Integer, Customer> map, int roomNo, double amount) {
		if (map.get(roomNo) == null) {
			Customer customer = createCustomer();
			list.add(customer);
			customer.setCamt(amount);
			map.put(roomNo, customer);

			System.out.println(roomNo + " is allocated to " + customer.getCname());

		} else {
			System.out.println("Room is not available");
		}
	}

	Customer createCustomer() {
		System.out.println("========= ENTER CUSTOMER DETAILS ==========");
		System.out.print("Enter ID : ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Name : ");
		String name = sc.next();
		sc.nextLine();

		System.out.print("Enter your phone number: ");
		long phone = sc.nextLong();
		sc.nextLine();

		System.out.print("Enter your email: ");
		String email = sc.next();
		sc.nextLine();

		System.out.print("Enter your PAN number : ");
		String pan = sc.next();

		Address address = createAddress();

		return new Customer(id, name, phone, email, pan, address);
	}

	Address createAddress() {
		System.out.print("Enter Door No : ");
		String doorno = sc.next();
		sc.nextLine();

		System.out.print("Enter Street : ");
		String street = sc.next();
		sc.nextLine();

		System.out.print("Enter District : ");
		String dist = sc.next();
		sc.nextLine();

		System.out.print("Enter State : ");
		String state = sc.nextLine();

		System.out.print("Enter Country : ");
		String country = sc.nextLine();

		System.out.print("Enter PIN Code : ");
		int pincode = sc.nextInt();
		sc.nextLine();

		return new Address(doorno, street, dist, state, country, pincode);
	}

	@Override
	public void checkout() {
		System.out.println("============= MENU =============");
		System.out.println("1. Classic Room\n2. Standard Room\n3. Deluxe Room");
		int roomType = sc.nextInt();
		System.out.println("Enter the room no :");
		int roomNo = sc.nextInt();
		switch (roomType) {
		case 1:
			if (roomNo >= 1 && roomNo <= 10) {
				unMapRoom(cm, roomNo);
			} else {
				System.out.println("Invalid Room No");

			}
			break;
		case 2:
			if (roomNo >= 1 && roomNo <= 8) {
				unMapRoom(sm, roomNo);
			} else {
				System.out.println("Invalid Room No");
			}
			break;
		case 3:
			if (roomNo >= 1 && roomNo <= 5) {
				unMapRoom(dm, roomNo);
			} else {
				System.out.println("Invalid Room No");
			}
			break;
		default:
			System.out.println("Invalid choice");
		}

	}

	public void unMapRoom(LinkedHashMap<Integer, Customer> map, int roomNo) {
		if (map.get(roomNo) != null) {
			Customer c1 = map.get(roomNo);
			System.out.println(c1);
			System.out.println(c1.getCname() + " need to pay Rs. " + c1.getCamt());
			map.put(roomNo, null);
		} else {
			System.out.println("Invalid Room Number !!!!!");
		}
	}

	@Override
	public void findAllCustomer() {
		if (list.size() == 0) {
			System.out.println("Database is empty");
		} else {
			for (Customer cust : list) {
				System.out.println(cust);
			}
		}
	}

	@Override
	public void getCustomerByID() {
		boolean flag = false;
		System.out.println("Enter the customer ID:");
		int id = sc.nextInt();
		for (Customer cust : list) {
			if (cust.getCid() == id) {
				System.out.println(cust);
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("Invalid Customer ID");
		}
	}

}
