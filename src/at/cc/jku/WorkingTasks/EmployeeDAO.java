package at.cc.jku.WorkingTasks;

import java.sql.*;

public class EmployeeDAO {

    private String url;

    public EmployeeDAO() {
        this.url = "jdbc:mysql://localhost:3306/workingtasks?user=root";
    }


    public EmployeeVO getEmployeeByPersonalNumber(int personalNumber){

        EmployeeVO employee = null;

        try {

            // Employee in der Datenbank suchen

            Connection connection = DriverManager.getConnection(this.url);
            final String sql = "SELECT * FROM `employee` WHERE personalnumber = ? ";

            PreparedStatement ps = null ;
            ps = connection.prepareStatement(sql);
            ps.setInt(1,personalNumber);


            // ps.executeUpdate(); -- für Update, daten ändern

            ResultSet rs = ps.executeQuery(); // Daten abfragen

            if (rs.next()) {
                // user gibt es in der Datenbank UserVO anlegen;
                int userid = rs.getInt("id");
                String firstNameFromDB = rs.getString("firstName");
                String familyNameFromDB = rs.getString("familyName");
                int personalNumberFromDB = rs.getInt("personalnumber");

                employee = new EmployeeVO(userid, personalNumberFromDB, firstNameFromDB, familyNameFromDB);

            }

            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }

        return employee;

    }
    public EmployeeVO getEmployee(String firsName, String familyName) {


        return searchEmployee(firsName, familyName);

    }

    private EmployeeVO searchEmployee(String firstName, String familyName) {

        EmployeeVO employee = null;
        try {

            // Employee in der Datenbank suchen

            Connection connection = DriverManager.getConnection(this.url);
            final String sql = "SELECT * FROM employee WHERE firstname = ? and familyname = ? ";// "SELECT * FROM `employee` WHERE firstname = '" + firstName + "' and familyname = '" +

            PreparedStatement ps = null ;
            ps = connection.prepareStatement(sql);
            ps.setString(1,firstName);
            ps.setString(2,familyName);

           // ps.executeUpdate(); -- für Update, daten ändern

            ResultSet rs = ps.executeQuery(); // Daten abfragen

            if (rs.next()) {
                // user gibt es in der Datenbank UserVO anlegen;
                int userid = rs.getInt("id");
                String firstNameFromDB = rs.getString("firstName");
                String familyNameFromDB = rs.getString("familyName");
                int personalNumber = rs.getInt("personalnumber");

                employee = new EmployeeVO(userid, personalNumber, firstNameFromDB, familyNameFromDB);

            }

            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }

        return employee;

    }

    public void addEmployee(EmployeeVO employee) {

        try {

            // Employee in der Datenbank suchen

            Connection connection = DriverManager.getConnection(this.url);
            final String sql = "INSERT INTO `employee`(`personalnumber`, `firstname`, `familyname`) VALUES ( ? , ? , ? )";

            PreparedStatement ps = null ;

            ps = connection.prepareStatement(sql);
            ps.setInt(1,employee.getPersonalNumber());
            ps.setString(2,employee.getFirstName());
            ps.setString(3,employee.getFamilyName());

            ps.executeUpdate(); // für Update, daten ändern

            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Keine Verbindung zu MySQL!!!");
        }

    }
}
