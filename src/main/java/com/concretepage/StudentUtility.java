package com.concretepage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.concretepage.soap.Student;

@Component
public class StudentUtility {
	private Map<Integer,Student> studentMap = new HashMap<Integer,Student>();
	public StudentUtility(){
		Student s1 = new Student();
		s1.setStudentId(1);
		s1.setName("Ram");
		s1.setAge(20);
		s1.setClazz("ABC");
		studentMap.put(1, s1);
		Student s2 = new Student();
		s2.setStudentId(2);
		s2.setName("Shyam");
		s2.setAge(22);
		s2.setClazz("EFG");
		studentMap.put(2, s2);
	}
	public Student getStudent(int studentId){
		return studentMap.get(studentId);
	}
	
	public List<Student> getAllStudents()
	{
		List<Student> list = new ArrayList<Student>();
		
		for(Map.Entry<Integer, Student> entry : studentMap.entrySet())
		{
			list.add(entry.getValue());
		}
		return list;		
	}
}
