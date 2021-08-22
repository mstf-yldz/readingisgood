# readingisgood
Online Book Stock App Wtih Spring Boot Data Rest MVC Security

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

>> First take a jwt token by supplying one of the following credentials:
[{username:user, password:user},{username:admin,password:admin},{username:getir,password:gotur}]
http://localhost:8080/login

then add the jwt token to Authorization header of all requests like: Bearer $token

>> add a new customer (POST REQUEST)
http://localhost:8080/customer/add
{"firstName":"mehmet","lastName":"yilmaz","email":"mehmetyilmaz@gmail.com", "tel":"5551117899","address":"Ankara"}

>> add a new author
http://localhost:8080/author/add (POST REQUEST)
{
	"firstName": "Şemsettin",
	"lastName": "Sami"
}

{
	"firstName": "Ahmet Mithat",
	"lastName": "Efendi"
}

>> add a new publisher (POST REQUEST)
{
	"name": "Türkiye İş Bankası Kültür Yayınları",
	"ssn": "SS45678JKLM"
}
>> add a new book (POST REQUEST)
{
	"title": "Ömer in Çocukluğu",
	"price":12,
	"author":{
		"id":1
	},
	"publisher":{
		"id":1
	}
}

{
	"title": "Zehra",
	"price":8,
	"author":{
		"id":2
	},
	"publisher":{
		"id":1
	}
}

>> add a new order (POST REQUEST)
{
	"customer":{
		"id":1
	},
	"orderBooks":[{
		"count": 1,
		"book":{
			"id": 1
		}},
		{
		"count": 1,
		"book":{
			"id":2
		}}
	]
}

>> get customer orders
http://localhost:8080/customer/orders/{customerID}/{pageSize}/{pageIndex} (GET REQUEST)

>> update book stock count
http://localhost:8080/book/updateStock/{bookId}/{newStockCount} (PUT REQUEST)

>> get order details
http://localhost:8080/order/get/{orderId} (GET REQUEST)

>> get orders between dates
http://localhost:8080/order/list/2021-08-21T17:00:00/2021-08-21T17:20:00 (GET REQUEST)

>> get monthly statistics
http://localhost:8080/statistics/stats






