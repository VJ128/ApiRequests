package com.din;

public class Employee {
int Empid;
String Empname;
public Employee(int empid, String empname) {
	super();
	Empid = empid;
	Empname = empname;
}
public int getEmpid() {
	return Empid;
}
public void setEmpid(int empid) {
	Empid = empid;
}
public String getEmpname() {
	return Empname;
}
public void setEmpname(String empname) {
	Empname = empname;
}
@Override
public String toString() {
	return "Employee [Empid=" + Empid + ", Empname=" + Empname + "]";
}

}