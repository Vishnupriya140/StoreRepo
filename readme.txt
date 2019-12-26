Application Configuration
---------------------------
-->Add dependencies for mysql,tomcat,jpa in pom.xml
-->Add properties to connect mysql in application.properties

Connecting mysql database
--------------------------
-->create database for the application
create database book_store

-->creat tables product and customer with below fields

create table customer
(
  customer_id int not null,
  customer_name varchar(30)
 );
create table product
(
  customer_id int not null,
  product_id int not null,
  product_name varchar(30),
  price double

);

To run the api's
-----------------------
http://localhost:8080/addToCart
Sample post request:

{
    "customerId":12,
    "customerName":"Vishnu",
    "contactNumber:"8937584539",
    "productDetailsList":
    [
     {
      "productId":12,
     "productName":"Pen",
     "price":50,
     "categoryId":25,
     "categoryName":"Management"
     }
    ]
} 

Sample get Request:

http://localhost:8080/receipt?customerId=12

Get response:


{
    "customerDetails": {
        "customerId": 12,
        "customerName": "Vishnu"
        "contactNumber":"8937584539"
    },
    "productList": [
        {
            "customerId": 12,
            "productId": 101,
            "productName": "PENCIL",
            "price": 50.0
            "categoryId":25,
    		"categoryName":"Management"
        }
    ],
    "salesTax": 3.5000000000000004,
    "vatTax": 2.0,
    "discount": 0.0,
    "total": 56
}



