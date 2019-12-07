package com.hasangzm.Model;

import com.hasangzm.Abstract.IEntity;
import com.hasangzm.Abstract.IPayload;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam implements IEntity<Exam> {

    private int studentId;
    private int examId;
    private Student student;
    private String lessonName;
    private int examScore;
    private String examType;

    public Exam(){

    }

    public Exam(ResultSet resultSet)
    {
        if(resultSet != null)
            ReadEntity(resultSet);
    }

    @Override
    public void ReadEntity(ResultSet res) {
        try {
            setExamId(res.getInt("examId"));
            setStudentId(res.getInt("studentId"));
            setLessonName(res.getString("lessonName"));
            setExamScore(res.getInt("examScore"));
            setExamType(res.getString("examType"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Exam GetEntity() {
        return this;
    }

    @Override
    public String toString() {
        return " Exam ID:" + getExamId() + " "+
                " Student ID:" + getStudentId() +
                " Exam Score:" + getExamScore() +
                " Lesson Name:" + getLessonName() +
                " Exam Type:" + getExamType();
    }

    public String getExamType()
    {
        return examType;
    }

    public void setExamType(String examType)
    {
        this.examType = examType;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getExamScore() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }
}
