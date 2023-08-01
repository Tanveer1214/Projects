package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImp;
import com.spring.jdbc.entities.Student;

public class App {
    public static void main( String[] args ) {
//    	ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//    	JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
    	
    	// without xml configuration
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
    	
//    	
//    	String query="insert into student(id,name,city) values(?,?,?)";
//    	int result = template.update(query,035,"Tanveer Hussain","Mehrabpur");
//    	System.out.println("number of rows inserted.."+result);
    	
    	// INSERT a student
//    	StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//    	Student student = new Student();
//    	student.setId(39);
//    	student.setName("Zuabir");
//    	student.setCity("Karachi");
//    	System.out.println(studentDao.insert(student)+" Record Inserted Successfully :)");
    	
    	// UPDATE a student
//    	StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//    	Student student = new Student();
//    	student.setId(39);
//    	student.setName("Ateeq");
//    	student.setCity("Nawabshah");
//    	System.out.println(studentDao.update(student)+" Record updated Successfully :)");
    	
    	// DELETE a student
//    	StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//    	Student student = new Student();
//    	System.out.println(studentDao.delete(39)+" Record Deleted Successfully :)");
    	
    	// Get single object
//    	StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//    	Student student = studentDao.getStudent(35);
//    	System.out.println(student);
    	
    	// Get multiple objects
    	StudentDao studentDao = context.getBean("getStudentDao",StudentDao.class);
    	List<Student> list = studentDao.getAllStudents();
    	for(Student i : list) {
    		System.out.println("_______________________");
    		System.out.println("Id: "+i.getId());
    		System.out.println("Name: "+i.getName());
    		System.out.println("City: "+i.getCity());
    	}
    	
    	
    }
}
