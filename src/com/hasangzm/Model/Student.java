package com.hasangzm.Model;

import com.hasangzm.Abstract.IEntity;
import com.hasangzm.Abstract.IPayload;

public class Student implements IEntity<Student> {

    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentBirthDate;
    private float studentGPA;
    private String studentBranch;

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

    public Student(){

    }

    @Override
    public void ReadEntity(IPayload payload) {
        try {
            this.studentId = Integer.parseInt(payload.GetValues().get("studentId"));
            this.studentFirstName = payload.GetValues().get("studentFirstName");
            this.studentLastName = payload.GetValues().get("studentLastName");
            this.studentBirthDate = payload.GetValues().get("studentBirthDate");
            this.studentBranch = payload.GetValues().get("studentBranch");
            this.studentGPA = Float.parseFloat(payload.GetValues().get("studentGPA"));
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public Student GetEntity() {
        return this;
    }
}
