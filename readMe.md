# Assignment of Scalable Services
# Online Book Service

# About Project
The main objective of Online Books service has three autonomous services such as order, inventory and payment service. Each service is independently deployable and has separate databases. Database that has been used is PostgreSQL. Ordering service is responsible for placing the order. It calls payment service, generates the payment id, updates order database and publishes updated order details to Kafka. Each time an order is placed stock gets updated in inventory service by using Kafka asynchronously. Payment Service handles bill payments that can be done by using Debit/Credit card or by Cash. Docker container is used to deploy all the services. Each service has a separate Docker image.

Technologies and dependencies:
Java, PostgreSQL, Kafka, Zookeeper, Docker


# Individual Contributions
»	Sreedevi Chittoor – 2020mt93105 - Design, Development, Documentation <br />
»	Amanpreet Singh – 2020mt93115 - Design, Development, Docker Deployment, Video Making <br />
»	Neeraj Chaudhary – 2020mt93056 - Design, Development, Video Making, Documentation <br />
»	Pushpal Chatterjee – 2020mt93216 - Design, Development, Docker Deployment <br />



# Steps
1)	Install Eclipse/STS and using the git repository mentioned above download the project or clone it.
2)	Need Java JDK 1.8 or higher and import the maven project in IDE.
3)	Install Kafka and PostgreSQL Database and run it.
4)	Run create-multiple-postgresql-databases.sh to create multiple databases.
5)	Run the DB scripts i.e V1_inventory.sql under db/migration folder containing sample data in PostgreSQL database.
6)	Run individual services in IDE.
7)	Install Postman.
8)	Run order service using url - http://localhost:8080/orders
Sample Request 
POST - http://localhost:8080/orders
{
 "totalAmount": "100",
 "payerName": "Sreedevi",
 "itemId": "123",
 "paymentId": "123224356"
}
9)	Verify the count of items available in inventory table.
10)	Now, run docker-compose.yaml file to run the services in Docker containers.
11)	Again run the order service in Postman and validate the count of items in inventory database.

