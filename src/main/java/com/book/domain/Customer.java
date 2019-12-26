package com.book.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author VishnupriyaSrikakola
 *
 */
@Entity
@Table(name="customer")
public class Customer {

	   @Id
	   @Column(name ="customer_id")
	   private Long customerId;

	   @Column(name ="customer_name")
	   private String customerName;

	   @Column(name="contact_number")
	   private Long contactNumber;
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	   
}
