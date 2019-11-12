package com.iwec.snaptest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "students")
public class Student implements Comparable<Student> {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Column(name = "first_name")
	@JsonProperty("first_name")
	private String firstName;

	@NonNull
	@Column(name = "last_name")
	@JsonProperty("last_name")
	private String lastName;

	@NonNull
	@Column(name = "email")
	@JsonProperty("email")
	private String email;

	public int compareTo(Student that) {
		int byLastName = this.lastName.compareTo(that.lastName);
		int byFirstName = this.firstName.compareTo(that.firstName);
		return byLastName != 0 ? byLastName : byFirstName;
	}

}
