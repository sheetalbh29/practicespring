package com.infogain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.infogain.dao.ProductDao;
import com.infogain.beans.Product;

public class ProductDao {
DataSource dataSource;
public ProductDao() {
	super();
}

public ProductDao(DataSource dataSource) {
	super();
	this.dataSource = dataSource;
}

public DataSource getDataSource() {
	return dataSource;
}
public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}

@Override
public String toString() {
	return "ProductDao [dataSource=" + dataSource + "]";
}
public void addProduct(Product p) throws BeansException, SQLException{
	ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/Spring-cong.xml");
	Connection con=ctx.getBean("productDao",ProductDao.class).getDataSource().getConnection();
	System.out.println("After Connection");
		PreparedStatement ps=con.prepareStatement("insert into product values (?,?,?)");
		ps.setInt(1, p.getpId());
		//ps.setString(2, p.getpName());
		ps.setInt(2, p.getpCost());
		ps.setInt(3, p.getQuantityInHand());
		int rs=ps.executeUpdate();
		if(rs>0) {
			System.out.println("Inserted...");
		}
		else 
			System.out.println("Not Inserted...");
	} 

public Product searchProduct(int id) throws BeansException, SQLException{
	ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/Spring-cong.xml");
	Connection con=ctx.getBean("productDao",ProductDao.class).getDataSource().getConnection();
	Product p=ctx.getBean("product",Product.class);
		PreparedStatement ps=con.prepareStatement("select * from product where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			p.setpId(id);
			//p.setpName(rs.getString(2));
			p.setpCost(rs.getInt(2));
			p.setQuantityInHand(rs.getInt(3));
			System.out.println(p);
		}
	return p;	
}
public void updateProduct(int id, int unit) throws BeansException, SQLException {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("com/infogain/res/Spring-cong.xml");
	Connection con=ctx.getBean("productDao",ProductDao.class).getDataSource().getConnection();
		con=dataSource.getConnection();
		PreparedStatement ps=con.prepareStatement("update product set quanityInHand=quanityInHand-? where pid=?");
		ps.setInt(1, id);
		ps.setInt(2, unit);
		int rs=ps.executeUpdate();
		if(rs>0) {
			System.out.println("Updated...");
		}
		else 
			System.out.println("Not Updated...");
}
}
