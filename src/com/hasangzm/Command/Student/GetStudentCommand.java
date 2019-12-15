package com.hasangzm.Command.Student;

import com.hasangzm.Abstract.ICommand;
import com.hasangzm.Abstract.ICommandCallback;
import com.hasangzm.Abstract.IEntity;
import com.hasangzm.Controller.ExamController;
import com.hasangzm.Controller.StudentController;
import com.hasangzm.Model.Student;

public class GetStudentCommand implements ICommand {

    private Student student;
    private int studentId;
    public GetStudentCommand(int studentId){
        this.studentId = studentId;
    }

    @Override
    public void Execute(ICommandCallback callback) {
        student = StudentController.Instance().Get(studentId);
        if(student != null) {
            callback.onSuccess(student);
        }
        else{
            callback.onSuccess(null);
        }

    }
}
