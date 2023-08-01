package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.StudentDao;
import com.spring.entities.Student;

public class App {
    public static void main( String[] args ) {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	StudentDao studentDao = context.getBean("studentdao",StudentDao.class);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	boolean b = true;
    	try {
    		while(b) {
    			System.out.println("PRESS 1 for Add student");
    			System.out.println("PRESS 2 for Delete student");
    			System.out.println("PRESS 3 for Update student");
    			System.out.println("PRESS 4 for Get single student");
    			System.out.println("PRESS 5 for Get all student");
    			System.out.println("PRESS 6 for Exit");
    			System.out.println("\nEnter Your Choice: ");
    			int n = Integer.parseInt(br.readLine());
    			int id;
    			String name;
    			String city;
    			switch (n) {
    			case 1:
    				System.out.println("Enter Student Id");
    				id = Integer.parseInt(br.readLine());
    				System.out.println("Enter Student Name");
    				name = br.readLine();
    				System.out.println("Enter Student City Name");
    				city = br.readLine();
    				studentDao.insert(new Student(id,name,city));
    				break;
    			case 2:
    				System.out.println("Enter Student Id");
    				id = Integer.parseInt(br.readLine());
    				studentDao.deleteStudent(id);
    				break;
    			case 3:
    				System.out.println("Enter Student Id Where You Want to Update");
					id = Integer.parseInt(br.readLine());
					System.out.println("Enter Student New Name");
					name = br.readLine();
					System.out.println("Enter Student New City Name");
					city = br.readLine();
					studentDao.updateStudent(new Student(id,name,city));
					break;
    			case 4:
    				System.out.println("Enter Student Id");
					id = Integer.parseInt(br.readLine());
					System.out.println(studentDao.getStudent(id));
					break;
    			case 5:
    				List<Student> list = studentDao.getAllStudents();
    				for(Student i : list) {
    					System.out.println("___________________________");
    					System.out.println("Id: "+i.getId());
    					System.out.println("Name: "+i.getName());
    					System.out.println("City: "+i.getCity());
    				}
    				System.out.println("___________________________");
    				break;
    			case 6:
    				b = false;
    				break;
    			default:
    				break;
    			}
    			System.out.println("\n\n");
    		}
    	  }catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	System.out.println("You Closed Application");
    }
}
