package com.bvk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student100")

public class Student1 {
		@Id
		private int studentId;
		
		@Column
		private String name;
		
		public Student1() {
			super();
		}

		public Student1(int studentId, String name) {
			super();
			this.studentId = studentId;
			this.name = name;
		}

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Student [studentId=" + studentId + ", name=" + name + "]";
		}
}