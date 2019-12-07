package com.hasangzm.Model;

import com.hasangzm.Abstract.IEntity;
import com.hasangzm.Abstract.IPayload;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student implements IEntity<Student> {

    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentBirthDate;
    private float studentGPA;
    private String studentBranch;
    private IPayload payload;


    @Override
    public String toString() {
        return "ID: " + getStudentId() + " " +
                " FirstName:" + getStudentFirstName() +
                " LastName:" + getStudentLastName() +
                " BirthDate" + getStudentBirthDate() +
                " GPA" + getStudentGPA() +
                " Branch" + getStudentBranch();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(String studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public float getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(float studentGPA) {
        this.studentGPA = studentGPA;
    }

    public String getStudentBranch() {
        return studentBranch;
    }

    public void setStudentBranch(String studentBranch) {
        this.studentBranch = studentBranch;
    }

    public Student(ResultSet resultSet){
        if(resultSet != null)
            ReadEntity(resultSet);
    }
    public Student(){

    }

    @Override
    public void ReadEntity(ResultSet res) {
        try {
            setStudentId(res.getInt("student_id"));
            setStudentFirstName(res.getString("first_name"));
            setStudentLastName(res.getString("last_name"));
            setStudentGPA(res.getFloat("gpa"));
            setStudentBranch(res.getString("branch"));
            setStudentBirthDate(res.getString("birth_date"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student GetEntity() {
        return this;
    }
}
