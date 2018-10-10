package com.infogain.main;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infogain.beans.InvalidQuantityInHandException;
import com.infogain.beans.Product;
import com.infogain.dao.ProductDao;

public class ProductManagementSystem {
	ProductDao dao=new ProductDao();
	public static void main(String[] args) throws InvalidQuantityInHandException, BeansException, SQLException {
		ProductManagementSystem managementSystem=new ProductManagementSystem();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter choice : ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				System.out.println("1. Add Product  :: ");
				managementSystem.add();
				break;
			case 2:managementSystem.sale();
				System.out.println("2. Sale Product :: ");
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("wrong choice ");
				break;
			}
		}
	}

	public void sale() throws InvalidQuantityInHandException, BeansException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id : ");
		int id=sc.nextInt();
//		System.out.println("enter name : ");
//		String name=sc.nextLine();
		System.out.println("unit sold : ");
		int unit=sc.nextInt();
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/Spring-cong.xml");
		ProductDao dao=ctx.getBean("productDao", ProductDao.class);
		Product p=dao.searchProduct(id);
		if(p.isValidquantityInHand()) {
			dao.updateProduct(id,unit);
		}
	}

	private void add() throws BeansException, SQLException{
		//String name;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id : ");
		int id=sc.nextInt();	
//		System.out.println("enter name : ");
//		name=sc.nextLine();
		System.out.println("enter cost : ");
		int cost=sc.nextInt();
		System.out.println("enter quantity : ");
		int quantity=sc.nextInt();	
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/Spring-cong.xml");
		ProductDao dao=ctx.getBean("productDao", ProductDao.class);
		Product p=ctx.getBean("product",Product.class);
		p.setpId(id);
		//p.setpName(name);
		p.setpCost(cost);
		p.setQuantityInHand(quantity);
		dao.addProduct(p);
		
	}
}
