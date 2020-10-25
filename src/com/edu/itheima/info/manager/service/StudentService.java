package com.edu.itheima.info.manager.service;

import com.edu.itheima.info.manager.dao.StudentDao;
import com.edu.itheima.info.manager.domain.Student;

public class  StudentService {
    private static StudentDao studentDao = new StudentDao();
    private static Student[] stu = StudentDao.findAllStudent();


    //添加：
    public static boolean addStudent(Student stu) {
        return studentDao.addStudent(stu);
    }
   //删除：
    public static void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    //修改：
    public static void updateStudent(String updateId,Student newStu) {
        studentDao.updateStudent(updateId,newStu);
    }

    //查看：
    public static Student[] findAllStudent() {
        boolean flag=false;
        for (int i = 0; i < stu.length; i++) {
            Student Stu = StudentService.stu[i];
            if(stu!=null){
                flag=true;
                break;
            }
        }
        if(flag){
            return stu;
        }else{
            return null;
        }
    }

    //判断学号是否存在的方法
    public static boolean isExists(String id) {
        boolean exists = false;
        for (int i = 0; i < stu.length; i++) {
            Student student = stu[i];
            if(student!=null&&student.getId().equals(id)){
                exists=true;
                break;
            }
        }
        return exists;
    }


}
