package services;

import models.dao.StudentDao;
import models.pojo.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentService {

    public static ArrayList<Student> getAllStudents(){
        return StudentDao.getAllStudents();
    }

    public static Student getStudentById(int id){
        return StudentDao.getStudentById(id);
    }

    public static Student updateStudent(Student student){
        return StudentDao.updateStudent(student);
    }

    public static void deleteStudent(int id){
        StudentDao.deleteStudent(id);
    }

}