package com.edu.itheima.info.manager.dao;

import com.edu.itheima.info.manager.domain.Student;

public class StudentDao {
    private static Student[] arrStu = new Student[5];


    //添加：
    public boolean addStudent(Student stu) {
        int index=-1;
        for (int i = 0; i <arrStu.length; i++) {
            Student student = arrStu[i];
            if(student==null){
                index=i;
                break;
            }
        }
        if(index==-1){
            //数组已满！
            return false;
        }else{
            //数组未满，将stu对象放入数组中
            StudentDao.arrStu[index]=stu;
            return true;
        }
    }

     //删除：
    public void deleteStudentById(String delId) {
        int index=getIndex(delId);
        arrStu[index]=null;
    }

   //修改：
    public void updateStudent(String updateId,Student newStu) {
        int index=getIndex(updateId);
        arrStu[index]=newStu;
    }

    //查看：
    public static Student[] findAllStudent() {
        return arrStu;
    }

    //查找修改和删除id的索引的方法：
    public int getIndex(String id) {
        int index=-1;
        for (int i = 0; i < arrStu.length; i++) {
            Student stu = StudentDao.arrStu[i];
            if(stu!=null&&stu.getId().equals(id)){
                index=i;
            }
        }
        return index;
    }
}
