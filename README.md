# Travel-Agency-Booking

1. Clone Repo and open it in Visual Studio Code
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
