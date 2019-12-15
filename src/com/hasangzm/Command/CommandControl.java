package com.hasangzm.Command;

import com.hasangzm.Abstract.ICommand;
import com.hasangzm.Abstract.ICommandCallback;

public class CommandControl {

    ICommand command;

    public CommandControl()
    {

    }

    public void SetCommand(ICommand command)
    {
        this.command = command;
    }

    public void Execute(ICommandCallback commandCallback)
    {
        command.Execute(commandCallback);
    }
}
