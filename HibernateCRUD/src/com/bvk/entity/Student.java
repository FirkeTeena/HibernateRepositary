package com.bvk.entity;

public class Student {
	private int studentId;
	private String name;
	private float percent;
	
	public Student() {
		super();
	}

	public Student(int studentId, String name) {
		super();
		this.studentId = studentId;
		this.name = name;
	}

	public Student(int studentId, String name, float percent) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.percent = percent;
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

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", percent=" + percent + "]";
	}
}