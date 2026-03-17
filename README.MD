**Project Title:**
Product Inventory Management System

**Brief Descrption of the project:**
A product management system built on REST APIs using Spring Boot. Follows the traditional Model -> Repository -> Service -> Controller implementation. 

**How to run:**
Built on Visual Studio Code. This command may be used: mvn spring-boot:run
                            OR 
Navigate to the DemoApplication.java file and press the "Run" button above the main method 
                            OR 
Type in the search bar ">run" and the "Spring Boot Dashboard: Run..." option will appear. You may select that option to run the application

**API Endpoints:**
Method:                URL:                         Description:              Status Codes:
GET                 /api/products                 Get all products               200 OK
GET       /api/products/getProductById/{id}       Get a product by ID         200 OK, 404 Not Found
POST      /api/products/createProduct             Create a new product         201 created
PUT       /api/products/updateProduct/{id}        Update an existing product  200 OK, 404 Not Found
DELETE    /api/products/deleteProduct/{id}     Delete a product by ID - 204 No Content, 404 Not Found


**curl examples:**
To bee used in the IDE's build in CMD
 To get all products: 
 curl http://localhost:8080/api/products

 To get products by ID: 
 curl http://localhost:8080/api/products/getProductById/1

 To create a new product:
 curl -X POST http://localhost:8080/api/products/createProduct -H "Content-Type: application/json" -d "{\"name\":\"Computer\",\"category\":\"Electronics\",\"price\":700.00,\"quantity\":5}"

 To update an existing product:
 curl -X PUT http://localhost:8080/api/products/updateProduct/1 -H "Content-Type: application/json" -d "{\"name\":\"Computer\",\"category\":\"Electronics\",\"price\":800.00,\"quantity\":10}"

 To delete a product:
 curl -X DELETE http://localhost:8080/api/products/deleteProduct/1

 To search by keyword:
 curl http://localhost:8080/api/products/search?keyword=laptop

 To search by category:
 curl http://localhost:8080/api/products/category/Electronics

Sample JSON body:
[{"id":**prodId**,"name":"**prodName**","category":"**prodCat**","price":"prodPrice","quantity":**prodquantity**}]

**Sample Responses**
curl http://localhost:8080/api/products
[{"id":2,"name":"Computer","category":"Electronics","price":700.0,"quantity":5},{"id":3,"name":"keyboard","category":"Ergonomics","price":99.99,"quantity":3}]

curl http://localhost:8080/api/products/getProductById/2
[{"id":2,"name":"Computer","category":"Electronics","price":700.0,"quantity":5}]

curl -X POST http://localhost:8080/api/products/createProduct -H "Content-Type: application/json" -d "{\"name\":\"keyboard\",\"category\":\"Ergonomics\",\"price\":99.99,\"quantity\":3}"
[{"id":3,"name":"keyboard","category":"Ergonomics","price":99.99,"quantity":3}]


