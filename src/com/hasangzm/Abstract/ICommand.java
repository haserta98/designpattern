package com.hasangzm.Abstract;

public interface ICommand {
    void Execute(ICommandCallback callback);
}
