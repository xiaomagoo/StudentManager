package com.edu.itheima.info.manager.entry;

import com.edu.itheima.info.manager.controller.StudentController;
import com.edu.itheima.info.manager.controller.TeacherController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("--------欢迎来到黑马信息管理系统--------");
        System.out.println("请输入您的选择: 1.学生管理  2.老师管理  3.退出");
        String choice=sc.next();
        switch (choice){
            case "1":
                //controller中开启学生信息系统
                StudentController studentController = new StudentController();
                studentController.start();
                break;
            case "2":
                //controller中开启老师信息系统
                TeacherController teacherController = new TeacherController();
                teacherController.start();
                break;
            case "3":
                System.out.println("欢迎使用，程序已结束！");
                System.exit(0);
                break;
            default:
                System.out.println("输入有误，请重新输入！");
                break;
        }
        }

    }
}
