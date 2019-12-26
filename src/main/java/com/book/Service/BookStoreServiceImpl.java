package com.book.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.domain.Customer;
import com.book.domain.Product;
import com.book.domain.Request;
import com.book.domain.Response;
import com.book.repository.BookRepository;

/**
 * @author VishnupriyaSrikakolapu
 *
 */
@Service
public class BookStoreServiceImpl implements BookStoreService {
	
	@Autowired
	BookRepository bookRepo;

	/**
	 * Creates a record in database
	 *
	 */
	@Override
	public Response addToCartDetails(Request request) {
		
	  Response response=new Response();
	   Product product=new Product();
		Customer customer=new Customer();
		//setting the customer details in customer object
		customer.setCustomerId(request.getCustomerId());
		customer.setCustomerName(request.getCustomerName());
		customer.setContactNumber(request.getContactNumber());
		//retreiving the data from the request and storing into list
		List<Product> productList=request.getProductDetailsList();
		//creating the record in db 
		customer=bookRepo.addCustomerDetails(customer);
		//creating records in product table for list of products
		if(productList != null && productList.size()>0) {
			
			for(Product prod:productList) {
				product.setCustomerId(prod.getCustomerId());
				product.setProductId(prod.getProductId());
				product.setProductName(prod.getProductName());
				product.setPrice(prod.getPrice());
				product.setCategory_id(prod.getCategory_id());
				product.setCategory_name(prod.getCategory_name());
				product=bookRepo.addProductDetails(product);
				
			}
		}		
		//setting the values into response object
		response.setCustomerDetails(customer);
		response.setProductList(productList);
		
		return response;
		}


	/**
	 *Retreives the data from db and performs actions
	 */
	@Override
	public Response billReceipt(Long customerId) {
	
	   double total=0;
	   List<String> categoryList=new ArrayList<String>();
		Response response=new Response();
		//retreiving the data from the customer table using customerid
		Customer customer=bookRepo.getCustomerDetails(customerId);
		response.setCustomerDetails(customer);
		//retreiving data from product table using customerid
		List<Product> productList=bookRepo.getProductDetails(customerId);
		//for everyproduct total,discount,salestax,vat tax are calculated as below
		if(productList != null && productList.size()>0) {
			response.setProductList(productList);
			for(Product prod:productList) {
				total+=prod.getPrice();
				categoryList.add(prod.getCategory_name());
			}
			  double salesTax=(total*0.07);
			  double vatTax=(total*0.04);
			    response.setSalesTax(salesTax);
				response.setVatTax(vatTax);
			total+=salesTax+vatTax;
			double discount=0;
			//if category list is managed no discount is applicable
			if(categoryList!=null && categoryList.size()>0) {
			for(String category:categoryList) {
			if(!(category.equalsIgnoreCase("Management"))) {
			if(total >=500 && total <=1000) {
				discount=total-(total*0.05);
			}
			else if(total >=1000 && total <=1500){
				discount=total-(total*0.1);
			}
			else if(total >=1500 && total <=2000){
				discount=total-(total*0.15);
			}
			else if(total >=2000){
				discount=total-(total*0.2);
			}
		  }	
		}
	}	
			//setting the vales to the response object
			response.setDiscount(discount);
            response.setTotal(Math.round(total));
			return response;
	}
		else {
			return null;
		}
			
	
	}
	
}
