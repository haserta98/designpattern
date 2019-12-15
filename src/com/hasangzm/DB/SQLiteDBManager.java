package com.hasangzm.DB;

import com.hasangzm.Abstract.IDBManager;

import javax.xml.transform.Result;
import java.sql.*;

public class SQLiteDBManager implements IDBManager {

    /* SINGLETON */
    private static volatile SQLiteDBManager _instance = null;

    private SQLiteDBManager() {
        ConnectDatabase();
        CreateTables();
    }

    public static SQLiteDBManager Instance()
    {
        if(_instance == null)
        {
            synchronized (SQLiteDBManager.class)
            {
                if(_instance == null)
                {
                    _instance = new SQLiteDBManager();
                }
            }
        }
        return _instance;
    }

    private Connection connection = null;

    public boolean ConnectDatabase(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:project.db");
            return connection.isValid(10);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void CreateTables(){
        String studentSQL = "CREATE TABLE IF NOT EXISTS students (" +
                " student_id INTEGER PRIMARY KEY," +
                " first_name TEXT," +
                " last_name TEXT,"+
                " birth_date TEXT,"+
                " gpa REAL,"+
                " branch TEXT )";

        String examSQL = "CREATE TABLE IF NOT EXISTS exam (" +
                " examId INTEGER PRIMARY KEY," +
                " studentId INTEGER ," +
                " examScore INTEGER ," +
                " lessonName TEXT," +
                " examType TEXT," +
                " FOREIGN KEY(studentId) REFERENCES students(student_id))";
        try {
            Statement stm = connection.createStatement();
            stm.execute(studentSQL);
            stm.execute(examSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet ExecuteSQL(String sql)
    {
        try {
            Statement sqlStm = connection.createStatement();
            return sqlStm.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }
}
