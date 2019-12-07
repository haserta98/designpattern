package com.hasangzm.Controller;

import com.hasangzm.Abstract.IController;
import com.hasangzm.Abstract.IDBManager;
import com.hasangzm.DB.SQLiteDBManager;
import com.hasangzm.Factory.StudentFactory;
import com.hasangzm.Model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentController implements IController<Student> {

    IDBManager db = SQLiteDBManager.Instance();
    StudentFactory studentFactory = new StudentFactory();
    @Override
    public void Insert(Student entity) {
        if(!db.ConnectDatabase())
            throw new RuntimeException("Veritabanına bağlanılamadı");

        String sql = "INSERT INTO students(first_name,last_name,birth_date,gpa,branch) VALUES( " +
                "\"" + entity.getStudentFirstName() + "\", "+
                "\"" + entity.getStudentLastName() + "\", "+
                "\"" +entity.getStudentBirthDate() + "\", "+
                "\"" +entity.getStudentGPA() + "\", "+
                "\"" +(entity.getStudentBranch()) + "\""+
                ")";
        db.ExecuteSQL(sql);
    }

    @Override
    public Student Get(int id) {
        if(!db.ConnectDatabase())
            throw new RuntimeException("Veritabanına bağlanılamadı");

        String sql = "SELECT * FROM students WHERE student_id="+id;
        ResultSet res = db.ExecuteSQL(sql);
        try {
            if(res.isClosed())
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Student) studentFactory.ExecuteFactory("student",res);
    }
}
