package com.hasangzm.Command.Student;

import com.hasangzm.Abstract.ICommand;
import com.hasangzm.Controller.StudentController;
import com.hasangzm.Model.Student;

public class InsertCommand implements ICommand {
    private StudentController controller = new StudentController();
    private Student student;
    public InsertCommand(Student student){
        this.student = student;
    }

    @Override
    public void Execute() {
        controller.Insert(student);
    }
}
