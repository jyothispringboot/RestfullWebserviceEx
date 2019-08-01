package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Student;
import com.app.repo.StudentRepository;
import com.app.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;
	
	@Transactional
	public Integer saveStudent(Student student) {		 
		return  repo.save(student).getStdId();
	}
	@Transactional
	public void deleteStudent(Integer id) {
		repo.deleteById(id);

	}

	@Transactional(readOnly = true)
	public List<Student> getAllStudent() {
		List<Student> st=repo.findAll();
		return st;
	}
	@Transactional
	public Integer updateStudent(Student student) {
		Integer result = null;
		if(repo.save(student)!=null)
			{
			 result=1;
			}
		return result;
	}
	
}
