package com.cisc181.core;

import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import com.cisc181.eNums.eTitle;


public class Staff_Test {
	
	static ArrayList<Staff> staff = new ArrayList<Staff>();

	@BeforeClass
	public static void setup() throws PersonException {
		
		
		
		Staff a = new Staff("Jesse", "William", "Nelson", new Date(), "19 Pierce Rd.", "9734772093", "jessenel@udel.edu","4:00-4:30", 1, 120000, new Date(), eTitle.MR);
		Staff b = new Staff("Jesse","William", "Nelson", new Date(), "19 Pierce Rd.", "9734772093", "jessenel@udel.edu", "4:00-4:30", 1, 130000, new Date(), eTitle.MR);
		Staff c = new Staff("Jesse","William", "Nelson", new Date(), "19 Pierce Rd.", "9734772093", "jessenel@udel.edu", "4:00-4:30", 1, 140000, new Date(), eTitle.MR);
		Staff d = new Staff("Jesse","William", "Nelson", new Date(), "19 Pierce Rd.", "9734772093", "jessenel@udel.edu", "4:00-4:30", 1, 150000, new Date(), eTitle.MR);
		Staff e = new Staff("Jesse","William", "Nelson", new Date(), "19 Pierce Rd.", "9734772093", "jessenel@udel.edu", "4:00-4:30", 1, 160000, new Date(), eTitle.MR);
		
		staff.add(a);
		staff.add(b);
		staff.add(c);
		staff.add(d);
		staff.add(e);
	}
	
	@Test 
	public void test_Salary() {
		double sum = 0;
		for (Staff i: staff)
			sum += i.getSalary();
		
		assertEquals(140000,(sum/5.0), 0);
	}
	
	@Test
	public void test_PhoneNumber() throws PersonException {
		Staff f = new Staff("Jesse", "William", "Nelson", new Date(), "19 Pierce Rd.", "973477", "jessenel@udel.edu","4:00-4:30", 1, 120000, new Date(), eTitle.MR);
	
	}
	
	@Test
	public void test_Date() throws PersonException {
		Staff g = new Staff("Jesse", "William", "Nelson", new Date(2011, 14, 3), "19 Pierce Rd.", "9734772093", "jessenel@udel.edu","4:00-4:30", 1, 120000, new Date(), eTitle.MR);

	}
}
