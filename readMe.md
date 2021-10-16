# Assignment of Scalable Services
# Online Book Service

# Contributors
Sreedevi Chittoor - 2020mt93105 <br />
Pushpal Chatterjee - 2020mt93216 <br />
Amanpreet Singh - 2020mt93115 <br />
Neeraj Choudhary - 2020mt93056 <br />


# About Project
The main objective of Online Book service has three autonomous services such as order,inventory and payment service. Each are independently deployable and has separate databases.
Order service is responsible for placing the order. It calls payment service, generates the payment id, updates order database and publishes updated order details to kafka.
Each time order is placed stock gets updated in inventory service by using kafka. Payment Service handles bill payements that can be done by using Debit/Credit card or by Cash.


# Deployement Steps




