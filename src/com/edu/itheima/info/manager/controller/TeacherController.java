package com.edu.itheima.info.manager.controller;
import com.edu.itheima.info.manager.domain.Teacher;
import com.edu.itheima.info.manager.service.TeacherService;
import java.util.Scanner;


public class TeacherController {
    Scanner sc=new Scanner(System.in);

   public void start() {
        Scanner sc=new Scanner(System.in);
        teacherLoop:while(true){
            System.out.println("--------欢迎来到<教师>信息管理系统--------");
            System.out.println("请输入您的选择: 1.添加教师  2.删除教师  3.修改教师  4.查看教师  5.退出");
            String choice=sc.next();
            switch (choice){
                case "1":
                    addTeacher();
//                    System.out.println("添加");
                    break;
                case "2":
//                    deleteTeacher();
                    System.out.println("删除");
                    break;
                case "3":
//                    updateTeacher();
                    System.out.println("修改");
                    break;
                case "4":
                    findAllTeacher();
                    System.out.println("查看");
                    break;
                case "5":
                    System.out.println("退出");
                    break teacherLoop;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }
//查看：
    public void findAllTeacher() {

    }

    public void addTeacher() {
       String id;
       while(true){
           System.out.println("输入老师id:");
           id=sc.next();
           boolean exists = TeacherService.isExists(id);
           if(exists){
               System.out.println("该老师id已被占用！请重新输入");
           }else{
               break;
           }
       }
       Teacher tch=inputTeacherInfo(id);
       boolean Result=TeacherService.addTeacher(tch);
       if(Result){
           System.out.println("添加成功！");
       }else{
           System.out.println("添加失败！");
       }

    }

    private String inputTeacherId() {
       String id;
       while(true){
           System.out.println("请输入教师的id:");
           id=sc.next();
           boolean exists=TeacherService.isExists(id);
           if(!exists){
               System.out.println("该学号不存在！");
           }else{
               break;
           }
       }
        return id;
    }

    private Teacher inputTeacherInfo(String id) {
        System.out.println("输入教师姓名：");
        String name=sc.next();
        System.out.println("输入教师年龄：");
        int age=sc.nextInt();
        System.out.println("输入教师生日：");
        String birthday=sc.next();
        Teacher teacher=new Teacher(id,name,age,birthday);
        return teacher;

    }
}
