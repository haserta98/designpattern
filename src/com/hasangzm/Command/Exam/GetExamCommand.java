package com.hasangzm.Command.Exam;

import com.hasangzm.Abstract.ICommand;
import com.hasangzm.Abstract.ICommandCallback;
import com.hasangzm.Controller.ExamController;
import com.hasangzm.Model.Exam;

public class GetExamCommand implements ICommand {
    private int studentId;
    private String lessonName;
    public GetExamCommand(int studentId, String lessonName){
        this.studentId = studentId;
        this.lessonName = lessonName;
    }

    @Override
    public void Execute(ICommandCallback callback) {
        Exam exam = ExamController.Instance().Get(studentId, lessonName);
        if(exam != null)
            callback.onSuccess(exam);
        else
            callback.onSuccess(null);
    }
}
