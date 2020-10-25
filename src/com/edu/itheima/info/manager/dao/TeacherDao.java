package com.edu.itheima.info.manager.dao;

import com.edu.itheima.info.manager.domain.Teacher;

public class TeacherDao {
    private static Teacher[] arrTch=new Teacher[5];
    public static Teacher[] findAllTeacher() {
      return arrTch;
    }

    //添加方法：
    public static boolean addTeacher(Teacher tch) {
        int index=-1;
        for (int i = 0; i < arrTch.length; i++) {
            Teacher teacher = TeacherDao.arrTch[i];
            if(teacher==null){
                index=i;
              break;
            }
        }
        if(index==-1){
            return false;
        }else {
            arrTch[index]=tch;
            return true;
        }
    }
}
