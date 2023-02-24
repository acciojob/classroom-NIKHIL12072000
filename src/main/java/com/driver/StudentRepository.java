package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class StudentRepository {

    HashMap<String, Student> studentHashMap;
    HashMap<String, Teacher> teacherHashMap;
    HashMap<String, ArrayList<String>> studentTeacherMap;

    StudentRepository(){
        studentHashMap=new HashMap<>();
        teacherHashMap=new HashMap<>();
        studentTeacherMap=new HashMap<>();
    }


    public void addStudent(Student student) {
        studentHashMap.put(student.getName(),student);
    }


    public void addTeacher(Teacher teacher) {
        teacherHashMap.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentTeacherMap.get(teacher).add(student);
    }

    public Student getStudentByName(String name) {
        return studentHashMap.get(name);
    }


    public Teacher getTeacherByName(String name) {
        return teacherHashMap.get(name);
    }


    public List<String> getStudentByTeacherName(String teacher) {
        return studentTeacherMap.get(teacher);
    }

    public List<String> getAllStudents() {
        List<String> students=new ArrayList<>();
        for(String student:studentHashMap.keySet()) students.add(student);
        return students;
    }

    public void deleteTeacherByName(String teacher) {
        if(teacherHashMap.containsKey(teacher))teacherHashMap.remove(teacher);
        List<String> al=new ArrayList<>();;
        if(studentTeacherMap.containsKey(teacher)){
            al=studentTeacherMap.get(teacher);
            studentTeacherMap.remove(teacher);
        }
        for(String student:al) studentHashMap.remove(student);
    }

    public void deleteAllTeachers() {
        Set<String> set=teacherHashMap.keySet();
        for(String teacher:set){
            List<String> al;
            al=studentTeacherMap.get(teacher);
            for(String student:al) studentHashMap.remove(student);
            studentTeacherMap.remove(teacher);
            studentHashMap.remove(teacher);
        }
    }
}
