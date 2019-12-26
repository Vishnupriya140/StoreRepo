package com.book.domain;

import java.util.List;

public class Response {

	private Customer customerDetails;
	private List<Product> productList;
	private double salesTax;
	private double vatTax;
	private double discount;
	private Long total;
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public double getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}
	public double getVatTax() {
		return vatTax;
	}
	public void setVatTax(double vatTax) {
		this.vatTax = vatTax;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long l) {
		this.total = l;
	}
	public Customer getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}
	
}
