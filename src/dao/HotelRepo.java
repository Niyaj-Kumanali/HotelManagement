package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import entity.Customer;

public interface HotelRepo {
	ArrayList<Customer> list = new ArrayList<>();
	LinkedHashMap<Integer, Customer> cm = new LinkedHashMap<>();
	LinkedHashMap<Integer, Customer> sm = new LinkedHashMap<>();
	LinkedHashMap<Integer, Customer> dm = new LinkedHashMap<>();
}
