package com.hasangzm.Abstract;

import java.sql.ResultSet;

public interface IEntity <T>{
    void ReadEntity(ResultSet resultSet);
    T GetEntity();
    String toString();
}
