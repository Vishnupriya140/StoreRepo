package com.book.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.book.domain.Customer;
import com.book.domain.Product;

/**
 * @author VishnupriyaSrikakolapu
 *
 */
@Repository
public class JpaBookRepository implements BookRepository {

    @PersistenceContext
    private EntityManager em;
	
    /**
     * created a record in customerTable with customer details
     */
    @Override
    @Transactional
    public Customer addCustomerDetails(Customer customer) {
    	em.persist(customer);
		return customer;
		
	}
    
	/**
	 *Retreives data from customer table using customerId
	 */
	@Override
	public Customer getCustomerDetails(Long customerId) {
		Customer customer=new Customer();
		Query qry = em.createQuery("Select c from Customer c where c.customerId=:customerId ");
		qry.setParameter("customerId", customerId);
		customer=(Customer)qry.getSingleResult();
		return customer;
	}
	
	/**
	 * Gets list of records from product table using customer details
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductDetails(Long customerId) {
		List<Product> productList=null;
		Query qry = em.createQuery("Select p from Product p where p.customerId=:customerId ");
		qry.setParameter("customerId", customerId);
		productList=qry.getResultList();
	return productList;
	}


	/**
	 * creates a record in Product table with product details
	 */
	@Override
	public Product addProductDetails(Product product) {
		em.persist(product);
		return product;
		
	}
	
}
