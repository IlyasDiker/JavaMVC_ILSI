package com.example.ILSIweb.Models;

import com.example.ILSIweb.Providers.DBContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

    private int StudentId;
    private String FirstName;
    private String LastName;
    private String Sexe;

    public Student(String firstName, String lastName, String sexe) {
        FirstName = firstName;
        LastName = lastName;
        Sexe = sexe;
    }

    public int getStudentId() {
        return StudentId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    public void save() {
        String DB_NAME = "students";

        String Query = "INSERT INTO "+DB_NAME+" (firstname, lastname, sexe) " +
                "VALUES ('"+this.FirstName+"', '"+this.LastName+"', '"+this.Sexe+"')";

        DBContext.AMS_request(Query);
    }

    public Student get(int StudentIdIndex) {
        String DB_NAME = "students";

        String Query = "SELECT * FROM "+DB_NAME+" WHERE studentid = "+String.valueOf(StudentIdIndex);

        ResultSet rs = DBContext.Select_request(Query);

        try {
            if(rs.next()){
                this.StudentId = rs.getInt("studentid");
                this.FirstName = rs.getString("firstname");
                this.LastName = rs.getString("lastname");
                this.Sexe = rs.getString("sexe");

                Student index = Student.this;

                return index;
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }
}
