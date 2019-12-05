package com.hasangzm.Abstract;

public interface IEntity <T>{
    void ReadEntity(IPayload payload);
    T GetEntity();
}
