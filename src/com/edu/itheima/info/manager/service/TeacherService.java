package com.edu.itheima.info.manager.service;

import com.edu.itheima.info.manager.dao.TeacherDao;
import com.edu.itheima.info.manager.domain.Teacher;

public class TeacherService {
  private  static TeacherDao teacherDao=new TeacherDao();
  private static Teacher[] tch=TeacherDao.findAllTeacher();

//查看教师的方法：
    public static Teacher[] findAllTeacher(){
        boolean flag=false;
        for (int i = 0; i < tch.length; i++) {
            Teacher Tch=TeacherService.tch[i];
            if(Tch!=null){
                flag=true;
            }else{
                break;
            }
        }
        if(flag){
            return tch;
        }else{
            return null;
        }
    }
    //判断id是否存在：
    public static boolean isExists(String id) {
        boolean exists=false;
        for (int i = 0; i < tch.length; i++) {
            Teacher Tch=tch[i];
            if(Tch!=null&&tch[i].getId().equals(id)){
                exists =true;
            }
        }
        return exists;
    }

    public static boolean addTeacher(Teacher tch) {
        return TeacherDao.addTeacher(tch);
    }
}
