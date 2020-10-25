package com.edu.itheima.info.manager.controller;
import com.edu.itheima.info.manager.domain.Student;
import com.edu.itheima.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private Scanner sc=new Scanner(System.in);

    public void start() {
        Scanner sc=new Scanner(System.in);
        studentLoop:while(true){
            System.out.println("--------欢迎来到<学生>信息管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice=sc.next();
            switch (choice){
                case "1":
//                    System.out.println("添加");
                    addStudent();
                    break;
                case "2":
                    deleteStudent();
//                    System.out.println("删除");
                    break;
                case "3":
                    updateStudent();
//                    System.out.println("修改");
                    break;
                case "4":
                    findAllStudent();
//                    System.out.println("查看");
                    break;
                case "5":
                    System.out.println("退出");
                    break studentLoop;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
        }
    }

    //添加学生
    public void addStudent() {
        String id;
        while(true){
            System.out.println("请输入id：");
            id = sc.next();
            boolean flag = StudentService.isExists(id);
            if(flag){
                System.out.println("学号已被占用, 请重新输入");
            }else{
                break;
            }
        }
        Student stu = inputStudentInfo(id);
        boolean result=StudentService.addStudent(stu);
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");

        }
    }

     //删除：
    public void deleteStudent() {
        Student[]stus =StudentService.findAllStudent();
        if(stus==null){
            System.out.println("查无信息，请先添加后再删除！");
            return;
        }
        String delId;
        while(true){
        System.out.println("请输入要删除的学号：");
        delId = sc.next();
        boolean exists = StudentService.isExists(delId);
        if(!exists){
           System.out.println("查无信息，请重新输入！");
       }else{
            break;
        }
    }
        StudentService.deleteStudentById(delId);
        System.out.println("删除成功！");
    }


  //修改
    public void updateStudent() {
        Student[]stus =StudentService.findAllStudent();
        if(stus==null){
            System.out.println("查无信息，请先添加后再删除！");
            return;
        }

        String updateId = inputStudentId();
        Student newStu = inputStudentInfo(updateId);
        StudentService.updateStudent(updateId,newStu);
        System.out.println("修改成功！");
    }

    //查找方法：
    public void findAllStudent() {
        Student[]stus =StudentService.findAllStudent();
        if(stus==null){
            System.out.println("查无信息，请重新输入！");
            return;
        }
        System.out.println("学号\t\t姓名\t\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null) {
                System.out.println(stu.getId() + "\t\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }

    //输入学生ID的方法：
    private String inputStudentId() {
        String id;
        while(true){
            System.out.println("请输入学号id：");
            id=sc.next();
            boolean exists = StudentService.isExists(id);
            if(!exists){
                System.out.println("该学号不存在，请重新输入！");
            }else{
                break;
            }
        }
        return id;
    }
    //键盘录入学生信息的方法（id在上一个方法中）
    private Student inputStudentInfo(String id) {
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}
