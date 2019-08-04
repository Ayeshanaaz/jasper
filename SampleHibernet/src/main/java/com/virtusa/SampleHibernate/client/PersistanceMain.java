package com.virtusa.SampleHibernate.client;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.virtusa.SampleHibernet.model.Product;

public class PersistanceMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
			Product product=new Product();
			product.setProductId(101);
			product.setProductName("Product1");
			product.setPrice(500);
			
			Product product3=new Product();
			product3.setProductId(103);
			product3.setProductName("Fan");
			product3.setPrice(6000);
			Configuration configuration=new Configuration();
			configuration.configure("hibernate.cfg.xml");
			SessionFactory sessionFactory=configuration.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(product);//Insert
			//session.delete(product1);//delete
			session.saveOrUpdate(product3);//update

					//HQL
			/*Query query = session.createQuery("select p from Product p where p.price > 500");
			List<Product> productList = query.list();
			for(Product prod:productList){
				System.out.println(prod);
			}
			product=(Product)session.get(Product.class,101);
			System.out.println(product);*/
			
			
					// Projections selecting a particular column
			/*Query query = session.createQuery("select max(p.price),Avg(p.price) from Product p ");
			List<Object[]> productList=query.list();
			for(Object[] objArray:productList)
			{
				for(Object obj:objArray)
				{
					System.out.println(obj);
				}
				System.out.println();
			}*/
			/*Query query = session.createQuery("select max(p.price) from Product p ");
			List<Float> productList=query.list();
			for(float obj:productList)
			{
				System.out.println(obj);
			}
			Scanner sc=new Scanner(System.in);*/
//			Query query1 = session.createQuery("from Product p where price>:sal");
//			query1.setParameter("sal", new Scanner(System.in).nextFloat());
//			query1.setFirstResult(1);
//			query1.setMaxResults(2);
//			List<Float> productList=query1.list();
//			for(float obj:productList)
//			{
//				System.out.println(obj);
//			}
					// Native SQL-->just like writing JDBC
//			SQLQuery sqlQuery = session.createSQLQuery("select * from producttab");
//			sqlQuery.addEntity(Product.class);
//			List<Product> productList = sqlQuery.list();
//			for(Product prod:productList){
//				System.out.println(prod);
//			}
					//Criteria API only done with select queries
					//criteria means by default select * from tablename with where orderby 
//			Criteria criteria=session.createCriteria(Product.class);
//			//SimpleExpression cond=Restrictions.gt("price",500.0);
//			Criterion cond1=Restrictions.between("price",1100.0, 7000.0);
//			Criterion cond2=Restrictions.eq("productName","TV");
//			Criterion cond3=Restrictions.and(cond1,cond2);
//			LogicalExpression cond4=Restrictions.or(cond1,cond2);
//			criteria.add(cond4);
//			criteria.addOrder(Order.asc("productName"));
//			List<Product> productList=criteria.list();
//			for(Product prod:productList){
//				System.out.println(prod);
//			}
			
				//Projections -->select particular columns from database and add to projection list
			Criteria criteria=session.createCriteria(Product.class);
			ProjectionList projectionList=Projections.projectionList();
			projectionList.add(Projections.property("productName")).add(Projections.property("price"));
			criteria.setProjection(projectionList);
			
			List<Object[]> productList = criteria.list();
			for (Object[] objArray : productList) {
				for (Object obj : objArray) {
					System.out.print(obj);
				}
				System.out.println();
			}
			transaction.commit();
			session.close();
	}

}
