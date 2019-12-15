package com.hasangzm.Controller;

import com.hasangzm.Abstract.IController;
import com.hasangzm.Abstract.IDBManager;
import com.hasangzm.DB.SQLiteDBManager;
import com.hasangzm.Factory.ExamFactory;
import com.hasangzm.Factory.StudentFactory;
import com.hasangzm.Model.Exam;
import com.hasangzm.Model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamController implements IController<Exam> {

    IDBManager db = SQLiteDBManager.Instance();
    ExamFactory examFactory = new ExamFactory();

    private static volatile ExamController _instance = null;

    private ExamController(){}

    public static ExamController Instance(){
        if(_instance == null)
        {
            synchronized (ExamController.class){
                if(_instance == null){
                    _instance = new ExamController();
                }
            }
        }
        return _instance;
    }

    @Override
    public void Insert(Exam entity) {
        if(!db.ConnectDatabase())
            throw new RuntimeException("Veritabanına bağlanılamadı");

        String sql = "INSERT INTO exam(studentId,examScore,lessonName,examType) VALUES( " +
                "\"" + entity.getStudentId() + "\", "+
                "\"" + entity.getExamScore() + "\", "+
                "\"" +entity.getLessonName() + "\", "+
                "\"" +entity.getExamType() + "\" "+
                ")";
        db.ExecuteSQL(sql);
    }

    @Override
    public Exam Get(int id) {
        return null;
    }

    public Exam Get(int studentId, String lessonName) {
        if(!db.ConnectDatabase())
            throw new RuntimeException("Veritabanına bağlanılamadı");

        String sql = "SELECT * FROM exam WHERE studentId="+studentId + " and lessonName=\"" + lessonName+"\"";
        ResultSet res = db.ExecuteSQL(sql);
        try {
            if(res.isClosed())
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Exam) examFactory.ExecuteFactory("exam",res);
    }

    @Override
    public Exam Get(){
        return (Exam) examFactory.ExecuteFactory("emptyExam",null);
    }
}
