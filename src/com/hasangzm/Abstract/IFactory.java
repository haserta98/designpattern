package com.hasangzm.Abstract;

import java.sql.ResultSet;

public interface IFactory {

    IEntity ExecuteFactory(String choose, ResultSet resultSet);

}
