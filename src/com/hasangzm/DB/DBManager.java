package com.hasangzm.DB;

import java.sql.*;

public class DBManager {

    /* SINGLETON */
    private static volatile DBManager _instance = null;

    private DBManager() {
        ConnectDatabase();
        CreateTables();
    }

    public static DBManager Instance()
    {
        if(_instance == null)
        {
            synchronized (DBManager.class)
            {
                if(_instance == null)
                {
                    _instance = new DBManager();
                }
            }
        }
        return _instance;
    }

    private Connection connection = null;

    private void ConnectDatabase(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:project.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CreateTables(){
        String studentSQL = "CREATE TABLE IF NOT EXISTS students (" +
                " student_id INTEGER PRIMARY KEY," +
                " first_name TEXT," +
                " last_name TEXT,"+
                " birth_date TEXT,"+
                " gpa REAL,"+
                " branch TEXT )";


        try {
            Statement stm = connection.createStatement();
            stm.execute(studentSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
