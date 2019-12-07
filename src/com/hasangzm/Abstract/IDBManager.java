package com.hasangzm.Abstract;

import java.sql.ResultSet;

public interface IDBManager {
    boolean ConnectDatabase();
    void CreateTables();
    ResultSet ExecuteSQL(String sql);
}
