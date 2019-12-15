package com.hasangzm;

import com.hasangzm.Abstract.ICommand;
import com.hasangzm.Abstract.ICommandCallback;
import com.hasangzm.Abstract.IEntity;
import com.hasangzm.Command.CommandControl;
import com.hasangzm.Command.Exam.GetExamCommand;
import com.hasangzm.Command.Exam.InsertExamCommand;
import com.hasangzm.Command.Student.GetStudentCommand;
import com.hasangzm.Command.Student.InsertStudentCommand;
import com.hasangzm.Controller.ExamController;
import com.hasangzm.Controller.StudentController;
import com.hasangzm.Factory.ExamFactory;
import com.hasangzm.Factory.StudentFactory;
import com.hasangzm.Model.Exam;
import com.hasangzm.Model.Student;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {
    private static int choose;
    private static Scanner s;
    private static ICommand command;
    private static CommandControl commandControl = new CommandControl();

    public static void main(String[] args) throws InterruptedException {
        Console();
    }

    private static void Console() throws InterruptedException {
        System.out.println("Otomasyon başlatılıyor.......");
        Thread.sleep(1000);
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz. \n " +
                "1.Öğrenci İşlemri " +
                "\n 2.Sınav İşlemleri");
        s = new Scanner(System.in).useDelimiter("\n");
        choose = s.nextInt();
        Thread.sleep(1000);
        switch (choose) {
            case 1:
                ConsoleStudentChoose();
                break;
            case 2:
                ConsoleExamChoose();
                break;
            default:
                System.out.println("Eksik seçim yaptınız");
                Console();
        }
    }

    private static void ConsoleExamChoose() throws InterruptedException {
        System.out.println("Lütfen yapmak istediğiniz işlem iseçiniz. \n" +
                " 1. Sınav yap \n" +
                " 2. Sınav görüntüle \n" +
                " 3. Bir üst menüye çık");
        choose = s.nextInt();

        switch (choose) {
            case 1:

                Exam exam = ExamController.Instance().Get();
                System.out.println("Ders adını giriniz");
                exam.setLessonName(s.next());
                System.out.println("Sınav türünü giriniz \n Vize \n Final");
                exam.setExamType(s.next());
                System.out.println("Öğrenci numarasını giriniz");
                exam.setStudentId(s.nextInt());
                System.out.println("Sınav sonucunu giriniz");
                exam.setExamScore(s.nextInt());

                InsertExam(exam);

                break;
            case 2:
                System.out.println("Öğrenci numarasını giri niz.");
                int studentId = s.nextInt();

                System.out.println("Ders adını giriniz");
                String lessonName = s.next();

                GetExam(studentId, lessonName);

                break;
            case 3:
                Console();
                break;
            default:
                System.out.println("Hatalı seçim yaptınız");
                ConsoleExamChoose();
        }
    }

    private static void ConsoleStudentChoose() throws InterruptedException {
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz. \n" +
                " 1. Öğrenci Ekle \n" +
                " 2. Öğrenci Bilgisi Getir \n" +
                " 3. Üst Menüye Dön");
        choose = s.nextInt();

        switch (choose) {
            case 1:
                Student student = StudentController.Instance().Get();
                System.out.println("Adınızı giriniz");
                student.setStudentFirstName(s.next());
                System.out.println("Soyadınızı giriniz");
                student.setStudentLastName(s.next());
                System.out.println("Doğum tarihinizi giriniz");
                student.setStudentBirthDate(s.next());
                System.out.println("Branşınızı giriniz");
                student.setStudentBranch(s.next());
                System.out.println("Not ortalamanızı giriniz");
                student.setStudentGPA(Float.parseFloat(s.next()));

                System.out.println("Öğrenci Ekleniyor....");
                InsertStudent(student);
                break;
            case 2:
                System.out.println("Öğrenci numarasını giriniz.");
                GetStudent(s.nextInt());
                break;
            case 3:
                Console();
                break;
            default:
                System.out.println("Hatalı seçim yaptınız");
                ConsoleStudentChoose();
        }
    }

    public static void InsertStudent(Student student) {
        command = new InsertStudentCommand(student);
        commandControl.SetCommand(command);
        commandControl.Execute(new ICommandCallback() {
            @Override
            public void onSuccess(IEntity entity) {
                System.out.println(entity.toString());
            }
        });
    }

    public static void GetStudent(int studentId) {
        command = new GetStudentCommand(studentId);
        commandControl.SetCommand(command);
        commandControl.Execute(new ICommandCallback() {
            @Override
            public void onSuccess(IEntity entity) {
                if(entity == null)
                    System.out.println("Hatalı giriş !");
                else
                    System.out.println(entity.toString());
            }
        });
    }

    public static void InsertExam(Exam exam) {
        command = new InsertExamCommand(exam);
        commandControl.SetCommand(command);
        commandControl.Execute(new ICommandCallback() {
            @Override
            public void onSuccess(IEntity entity) {
                System.out.println(entity.toString());
            }
        });
    }

    public static void GetExam(int studentId, String lessonName) {
        command = new GetExamCommand(studentId, lessonName);
        commandControl.SetCommand(command);
        commandControl.Execute(new ICommandCallback() {
            @Override
            public void onSuccess(IEntity entity) {
                if(entity == null)
                    System.out.println("Hatalı giriş !");
                else
                    System.out.println(entity.toString());
            }
        });
    }
}
