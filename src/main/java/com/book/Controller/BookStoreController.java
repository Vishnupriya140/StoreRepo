package com.book.Controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.Service.BookStoreService;
import com.book.domain.Request;
import com.book.domain.Response;
/**
 * @author VishnupriyaSrikakolapu
 *
 */
@RestController
public class BookStoreController {
	
	@Autowired
	BookStoreService bookService;
	
	private Logger logger = LoggerFactory.getLogger(BookStoreController.class);
	/*Creates the cart
	 * @param Request Object
	 * @return the Response object
	 */
	@PostMapping(value="/addToCart")
	public Response addToCart(Request request) {
		
		logger.info("Entering into Add to Cart Details");
		Response response=bookService.addToCartDetails(request);
		return response;
	}
	
	/*Gets the cartDetails using CustomerId
	 * @param customerId
	 * @return the Response object
	 */
	@GetMapping(value="/receipt")
	public Response checkOut(@PathParam("customerId") Long customerId) {
		
		Response response=bookService.billReceipt(customerId);
		return response;
	}

}
