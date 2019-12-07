package com.hasangzm;

import com.hasangzm.Controller.ExamController;
import com.hasangzm.Controller.StudentController;
import com.hasangzm.Model.Exam;
import com.hasangzm.Model.Student;


public class Main {

    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        ExamController examController = new ExamController();
        Student studentEntity = new Student();

        studentEntity.setStudentFirstName("HASAN");
        studentEntity.setStudentLastName("Gözüm");
        studentEntity.setStudentBirthDate("07/12/1998");
        studentEntity.setStudentGPA(2.64f);
        studentEntity.setStudentBranch("Bilgisayar Mühendisliği");


        Exam exam = examController.Get();
        exam.setExamType("Vize");
        exam.setLessonName("Bilgisayar Ağları");
        exam.setExamScore(68);
        exam.setStudentId(1);

        examController.Insert(exam);

        exam = examController.Get(1);

        //studentController.Insert(studentEntity);
        //Student s = studentController.Get(10);

        if(exam != null)
        System.out.println(exam.toString());
    }
}
