package com.virtusa.zomato.dao;

import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;
import com.virtusa.zomato.exception.ZomatoException;
import com.virtusa.zomato.model.CustomerDetail;
import com.virtusa.zomato.model.LoginDetail;
import com.virtusa.zomato.model.MenuDetail;
import com.virtusa.zomato.model.OrderDetail;
import com.virtusa.zomato.model.PaymentDetail;
import com.virtusa.zomato.model.Restaurant;
import com.virtusa.zomato.model.RestaurantMenuDetail;
import com.virtusa.zomato.service.IZomato;
import com.virtusa.zomato.util.ConnectionUtil;

public class ZomatoDao implements IZomato {
	public ZomatoDao() {
		// TODO Auto-generated constructor stub
	}

	Logger logger = Logger.getLogger("ZomatoDAO");

	@Override
	public int doLoginCheck(LoginDetail loginDetail) throws ZomatoException {
		// TODO Auto-generated method stub
		int flag = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("select cu_email ,password  " + "from customer where cu_email=? and password=? ");
			preparedStatement.setString(1, loginDetail.getUsername());

			preparedStatement.setString(2, loginDetail.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				flag = 1;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("error with SQL", e);
			throw new ZomatoException("Some internal error contact to admin");
		} catch (Exception exception) {

			logger.error("error with system", exception);
			throw new ZomatoException("Some internal error contact to admin");

		}

		finally {

			// close pstmt,connection,result set also
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				throw new ZomatoException(" error while closing a resource contact to admin");

			}

		}
		return flag;
	}

	@Override
	public int registerCustomer(CustomerDetail customerDetail) throws ZomatoException {

		ResultSet resultSet = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int customerNo = 0;
		try {
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(
					"insert into customer (cu_name,cu_address,cu_contact,cu_email,password) values(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS

			);
			preparedStatement.setString(1, customerDetail.getCustomerName());
			preparedStatement.setString(2, customerDetail.getCustomerAddress());
			preparedStatement.setString(3, customerDetail.getCustomerContact());
			preparedStatement.setString(4, customerDetail.getCustomerEmail());
			preparedStatement.setString(5, customerDetail.getPassword());
			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {

				customerNo = resultSet.getInt(1);
				System.out.println(customerNo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("sql error", e);
			throw new ZomatoException(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("internal error", e);
			throw new ZomatoException(e.getMessage());
		}

		finally {

			// close pstmt,connection,result set also
			try {

				if (resultSet != null) {

					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				logger.error("sql error", e);
				// TODO: handle exception
				throw new ZomatoException(" error while closing a resource contact to admin");

			} catch (Exception e) {
				// TODO: handle exception

				logger.error("internal error", e);
				throw new ZomatoException("  contact to admin");

			}

		}

		// TODO Auto-generated method stub
		return customerNo;
	}

	@Override
	public List<RestaurantMenuDetail> searchRestautants(String text) throws ZomatoException {
		// TODO Auto-generated method stub

		String query = "select * from restaurant r join menu m" + " join restarant_menu_detail md "
				+ " on r.re_id=md.rm_re_fk and m.me_id=md.rm_me_fk " + " where r.re_name like ? or m.me_name like ?  ";

		List<RestaurantMenuDetail> list=new ArrayList<>();
		ResultSet resultSet = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int customerNo = 0;
		try {
			System.out.println(connection);
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, "%" + text + "%");
			preparedStatement.setString(2, "%" + text + "%");
			resultSet = preparedStatement.executeQuery();
            
			while (resultSet.next()) {

				String menuName = resultSet.getString("me_name");
				float menuPrice = resultSet.getFloat("me_price");
				MenuDetail menuDetail = new MenuDetail();
				menuDetail.setMenuName(menuName);
				menuDetail.setMenuPrice(menuPrice);

				String restName = resultSet.getString("re_name");
				String restAddress = resultSet.getString("re_address");
				String restContact = resultSet.getString("re_contact");
				String restEmail = resultSet.getString("re_email");

				Restaurant restaurant = new Restaurant();

				restaurant.setRestaurantAddress(restAddress);
				restaurant.setRestaurantContact(restContact);
				restaurant.setRestaurantEmail(restEmail);

				restaurant.setRestaurantName(restName);

				RestaurantMenuDetail detail = new RestaurantMenuDetail();
                 detail.setMenuDetail(menuDetail);
                 detail.setRestaurant(restaurant);
                 
                 System.out.println(detail);
                 list.add(detail);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("sql error", e);
			throw new ZomatoException(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("internal error", e);
			throw new ZomatoException(e.getMessage());
		}

		finally {

			// close pstmt,connection,result set also
			try {

				if (resultSet != null) {

					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				logger.error("sql error", e);
				// TODO: handle exception
				throw new ZomatoException(" error while closing a resource contact to admin");

			} catch (Exception e) {
				// TODO: handle exception

				logger.error("internal error", e);
				throw new ZomatoException("  contact to admin");

			}

		}

		// TODO Auto-generated method stub
		return list;

		
	}

	@Override
	public int placeOrder(OrderDetail orderDetail) throws ZomatoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doPayment(PaymentDetail paymentDetail) throws ZomatoException {
		// TODO Auto-generated method stub
		return 0;
	}

}
