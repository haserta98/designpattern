package com.hasangzm.Factory;

import com.hasangzm.Abstract.IEntity;
import com.hasangzm.Abstract.IFactory;
import com.hasangzm.Model.Exam;
import com.hasangzm.Model.Student;

import java.sql.ResultSet;

public class StudentFactory implements IFactory {

    @Override
    public IEntity ExecuteFactory(String choose, ResultSet resultSet) {
         switch (choose)
         {
             case "student":
                 return new Student(resultSet);
             case "emptyStudent":
                 return new Student();
             default:
                 return null;
         }
    }
}
