package com.iwec.snaptest.sorter;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.iwec.snaptest.model.Student;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BubbleSorterTest {

	@InjectMocks
	private BubbleSorter sorter;

	@Mock
	private Student student;

	@Test
	public void testWhenListEmpty() {
		ArrayList<Student> list = new ArrayList<>();
		sorter.sorter(list);
	}
	
	@Test
	public void testWhenThereIsOneStudent() {
		student = new Student(1, "Marija", "Timovska", "marijatimovska@gmail.com");
		ArrayList<Student> list = new ArrayList<>();
		list.add(student);
		sorter.sorter(list);
	}
	@Test
	public void testWhenMultipleStudents() {	
		student = new Student();
		student.setId(1);
		student.setFirstName("Marija");
		student.setLastName("TImovska");
		student.setEmail("marijatimovska@gmail.com");
		
		Student studenttwo = new Student();
		studenttwo.setId(1);
		studenttwo.setFirstName("Krume");
		studenttwo.setLastName("Krumev");
		studenttwo.setEmail("krumekrumevski@gmail.com");
		
		Student st= new Student();
		st.setId(1);
		st.setFirstName("Ana");
		st.setLastName("Anushevska");
		st.setEmail("krumekrumevski@gmail.com");
		
		ArrayList<Student> list = new ArrayList<>();
		list.add(student);
		list.add(studenttwo);
		list.add(st);
		sorter.sorter(list);		
		
	
		
	}
}
