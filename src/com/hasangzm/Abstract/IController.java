package com.hasangzm.Abstract;

public interface IController <T>{
    void Insert(T entity);
    T Get(int id);
    T Get();
}
