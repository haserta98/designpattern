package com.hasangzm.Factory;

import com.hasangzm.Abstract.IEntity;
import com.hasangzm.Abstract.IFactory;
import com.hasangzm.Model.Exam;

import java.sql.ResultSet;

public class ExamFactory implements IFactory {

    @Override
    public IEntity ExecuteFactory(String choose, ResultSet resultSet) {
         switch (choose)
         {
             case "exam":
                 return new Exam(resultSet);
             case "emptyExam":
                 return new Exam();
             default:
                 return null;
         }
    }
}
