package com.me.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.me.bean.Product;
import com.me.bean.User;

public class ProductDao extends Dao {
	public Product createproduct(Product product)
	{
		try {
	        begin();
	        
	        getSession().save(product);
	        commit();
	        return product;
	    } catch (HibernateException e) {
	        rollback();
	        //throw new AdException("Could not create the category", e);
	        throw new HibernateException("Exception while creating category: " + e.getMessage());
	    }

		}
	
	public List<Product> getAllProducts() {
		begin();
		//List<Product> products = session.createQuery("from Product").list();
		Query q = getSession().createQuery("from product");
	 List<Product> products=q.list();
	 
	 
	 commit();
	 	
		return products;
	}

	public Product getProductById(int productId) {

		// Reading the records from the table
		begin();
		// select * from Product where isbn=i
		Query q=getSession().createQuery("from product where productId =:productId ");
		q.setInteger("productId", productId);
		Product product=(Product)q.uniqueResult();
		
		
		commit();
		return product;
	}
/*	public Product updateproduct(int quantity) {

		// Reading the records from the table
		begin();
		// select * from Product where isbn=i
		Query q=getSession().createQuery("update product set stock =:stock-:quantity where productId=:productId");
		q.setInteger("", productId);
		Product product=(Product)q.uniqueResult();
		
		
		commit();
		return product;
	}
*/
}
