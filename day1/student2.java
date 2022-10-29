package day1;

public class student2{
String name;
int age;
String course;
public student2
(String name) {
this.name = name;
}
public void studentAge(int sage) {
age = sage;
}
public void studentCourse(String scourse) {
course = scourse;
}
/* Print the details */
public void printStudent() {
System.out.println("Name:"+ name );
System.out.println("Age:" + age );
System.out.println("Course:" + course );
}
public static void main(String [] args)
{
student2
 s1 = new student2
("Soumyaneel");
s1.studentAge(21);
s1.studentCourse("MCA");
s1.printStudent();
}
}