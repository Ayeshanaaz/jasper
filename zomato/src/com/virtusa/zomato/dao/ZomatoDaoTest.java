package com.virtusa.zomato.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.virtusa.zomato.exception.ZomatoException;
import com.virtusa.zomato.model.CustomerDetail;
import com.virtusa.zomato.model.LoginDetail;

public class ZomatoDaoTest {
	private static ZomatoDao dao=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao=new ZomatoDao();
		System.out.println("@before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao=null;
		System.out.println("@after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@before method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@after method");
	}

	/*@Test(expected=ZomatoException.class)
	public void testZomatoDao() {
		fail("Not yet implemented");
	}*/

	@Test()
	public void testDoLoginCheck() {
		System.out.println("Do login check");
		LoginDetail detail=new LoginDetail("shuhaam@gmail.com","12345766");
		try {
			int flag=dao.doLoginCheck(detail);
			//System.out.println("flag=="+flag);
			assertEquals(1,flag);
		} catch (ZomatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test()
	public void testRegisterCustomer() {
		System.out.println("Do login check");
		CustomerDetail customerDetail=new CustomerDetail(0,"shuhaam","punjab","shuaam@gmail.com","702818844","12345766");
		int flag=0;
		try {
			flag=dao.registerCustomer(customerDetail);
			//System.out.println("flag=="+flag);
		//	System.out.println("cu_id=="+customerDetail.getCustomerId());
			assertTrue(flag>0);
			//assertEquals(flag, flag);
		} catch (ZomatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*	@Test(expected=ZomatoException.class)
	public void testSearchRestautants() {
		fail("Not yet implemented");
	}*/

}
