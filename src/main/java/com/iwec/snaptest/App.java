 package com.iwec.snaptest;

import java.io.File;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iwec.snaptest.model.Student;
import com.iwec.snaptest.model.StudentList;
import com.iwec.snaptest.sorter.BubbleSorter;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		BubbleSorter bl = new BubbleSorter();
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Student> list = new ArrayList<>();

		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();

		try {
			
			StudentList students = mapper.readValue(new File("students.json"), StudentList.class);
			list = students.getStudent();
			bl.sorter(list);
			for (Student student : list) {
				System.out.println(student + " ");
				entityManager.persist(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
