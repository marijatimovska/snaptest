package com.iwec.snaptest;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iwec.snaptest.model.Student;
import com.iwec.snaptest.model.StudentList;
import com.iwec.snaptest.sorter.BubbleSorter;
import com.jayway.jsonpath.JsonPath;

public class Tests {

	public static void main(String[] args) {
		BubbleSorter bl = new BubbleSorter();
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("students.json"));
			JSONObject user = (JSONObject) obj;
			JSONArray data = (JSONArray) user.get("student");

			ObjectMapper mapper = new ObjectMapper();
			StudentList students = mapper.readValue(new File("students.json"), StudentList.class);
			for (Student it : students.getStudent()) {
				System.out.println(it);
				
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

			Iterator<StudentList> iterator = data.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");

			ArrayList<String> ln = JsonPath.read(user, "$.student[*].last_name");
			ln.forEach(System.out::println);
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			ArrayList<JSONObject> fn = JsonPath.read(user, "$.student[?(@.first_name == 'Michael')]");
			fn.forEach(System.out::println);
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			ArrayList<Student> list = students.getStudent();
			bl.sorter(list);
			for (Student student : list) {
				System.out.println(student + " ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
