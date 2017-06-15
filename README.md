# Retail Web Application

A Spring MVC (Hibernate ORM, JSP view) application based on these requirements:

On a retail website, the following discounts apply: 
1. If the user is an employee of the store, he gets a 30% discount 
2. If the user is an affiliate of the store, he gets a 10% discount 
3. If the user has been a customer for over 2 years, he gets a 5% discount. 
4. For every $100 on the bill, there would be a $5 discount (e.g. for $990, you get $45 as a discount). 
5. The percentage based discounts do not apply on groceries. 
6. A user can get only one of the percentage based discounts on a bill. 
7. Write a program with test cases such that given a bill, it finds the net payable amount

# Requirements
- Java 8
- Maven 3+
- MySQL/MariaDB

# Building & Running
Setup a database on MySQL/MariaDB named `retailweb`.
To build & run the web application, simply execute:
```
mvn spring-boot:run
```
To view the web UI, browse `localhost:8080`.
