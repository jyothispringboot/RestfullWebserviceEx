package com.app.service;

import java.util.List;

import com.app.model.Student;

public interface IStudentService {
	
	public Integer saveStudent(Student student);
	//all
	public List<Student> getAllStudent();
	//delete
	public void deleteStudent(Integer id);
	//update
	public Integer updateStudent(Student student);
	

}
