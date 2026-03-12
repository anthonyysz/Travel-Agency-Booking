# Travel-Agency-Booking
## 1. Introduction
&nbsp;&nbsp;&nbsp;&nbsp;For this assignment, I was given a working front-end of a vacation booking website and a MySQL database. My task was to create a working back-end using Spring framework, simulating a migration from an old, outdated back-end framework to a newer one.

## 2. My work
&nbsp;&nbsp;&nbsp;&nbsp;I needed to create 4 new packages for controllers, entities, data access objects (dao), and services. The only controller I made was a checkout controller. All entities were created with columns to match the MySQL database provided. I made a dao for each of the entities except for [StatusType.java](https://github.com/anthonyysz/Travel-AgencyBooking/blob/main/backend/src/main/java/com/example/demo/entities/StatusType.java), an enumerative class used to provide the status of the cart during checkout. I finally made checkout service that would checkout and purchase the items added to the cart. 

## 3. How to view locally
1. Clone the repository and open it in Visual Studio Code
2. In the command line, navigate to the front-end folder and run
   * npm install -g @angular/cli
   * npm install @angular-devkit/build-angular --save-dev
3. Add Spring Boot Extension Pack and Maven for Java (comes inside Extension Pack for Java)
4. Go to MySQL Workbench
   * Administration
   * Users and Privileges
   * Add Account
     * Login Name: ecommerceapp
     * Authentication Type: chaching_sha2_password
     * Limit to hosts matching: localhost
     * Password: ecommerceapp
     * In Schema Privileges: Give permission to SELECT INSERT UPDATE DELETE EXECUTE CREATE and DROP
5. Open and execute create_and_populate_db.sql
6. Back in VS Code, run 'ng serve' on the front end folder
7. Navigate the the back end folder in a separate terminal and run 'mvn spring-boot:run'
8. In your browser, visit localhost:4200

## 4. Looking forward
&nbsp;&nbsp;&nbsp;&nbsp;I had a lot of fun working with Spring and integrating a database with a separate front and back end. I learned the most about how front ends and back ends commmunicate with each other and how much goes into making everything run smoothly. While working on this and picking my way through the front end, I realized that well thought-out front ends have a lot more to them than I'd thought. I'd love to do something similar in the future, perhaps with some kind of sports statistics like how the ESPN app integrates them. 
