package com.hasangzm.Command.Student;

import com.hasangzm.Abstract.ICommand;
import com.hasangzm.Abstract.ICommandCallback;
import com.hasangzm.Controller.StudentController;
import com.hasangzm.Model.Student;

public class InsertStudentCommand implements ICommand {
    private Student student;
    public InsertStudentCommand(Student student){
        this.student = student;
    }

    @Override
    public void Execute(ICommandCallback callback) {
        StudentController.Instance().Insert(student);
        callback.onSuccess(student);
    }


}
