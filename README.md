# readingisgood
Online Book Stock App Wtih Spring Boot Data Rest MVC Security

# Getting Started

to run in docker run following commands:

mvnw -Dmaven.test.skip=true spring-boot:build-image -Dspring-boot.build-image.imageName=springio/readingisgood-docker
docker run -p 8080:8080 -t springio/readingisgood-docker

I have to skip tests when building docker image because maven cannot access mongodb when my hostname is mongo://mongo:27017.
When you take build with maven if you change the hostname to mongo://localhost:27017/local it can run tests and build successfully.
The problem is only with docker build.

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






