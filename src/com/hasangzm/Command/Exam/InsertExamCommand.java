package com.hasangzm.Command.Exam;

import com.hasangzm.Abstract.ICommand;
import com.hasangzm.Abstract.ICommandCallback;
import com.hasangzm.Controller.ExamController;
import com.hasangzm.Model.Exam;

public class InsertExamCommand implements ICommand {
    private Exam exam;

    public InsertExamCommand(Exam exam){
        this.exam = exam;
    }

    @Override
    public void Execute(ICommandCallback callback) {
        ExamController.Instance().Insert(exam);
        callback.onSuccess(exam);
    }
}
