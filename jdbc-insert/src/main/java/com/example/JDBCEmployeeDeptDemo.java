package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCEmployeeDeptDemo {
    public static void main(String[] args) {
        // Database details
        String url = "jdbc:mysql://localhost:3306/fsads52";
        String user = "root";
        String password = "root";

        try {
            // 1. Load MySQL Driver (optional in latest versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Database!");

            // 3. Create Statement
            Statement st = con.createStatement();

            // 4. Create Dept table
            String createDept = "CREATE TABLE IF NOT EXISTS dept1 (" +
                                "dept_id INT PRIMARY KEY, " +
                                "dept_name VARCHAR(50))";
            st.executeUpdate(createDept);
            System.out.println("Dept table created.");

            // 5. Create Employee table
            String createEmp = "CREATE TABLE IF NOT EXISTS emp1 (" +
                               "emp_id INT PRIMARY KEY, " +
                               "emp_name VARCHAR(50), " +
                               "salary DOUBLE, " +
                               "dept_id INT, " +
                               "FOREIGN KEY (dept_id) REFERENCES dept1(dept_id))";
            st.executeUpdate(createEmp);
            System.out.println("Employee table created.");

            // 6. Insert values into dept
            
            st.executeUpdate("INSERT INTO dept1 VALUES (2,'HR')");
            st.executeUpdate("INSERT INTO dept1 VALUES (3,'Finance')");
            st.executeUpdate("INSERT INTO emp1 VALUES (102, 'Bob', 60000, 2)");
            st.executeUpdate("INSERT INTO emp1 VALUES (103, 'Charlie', 70000, 3)");
            System.out.println("Employee values inserted.");

            // 8. Close connection
            con.close();
            System.out.println("Done and Connection Closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}