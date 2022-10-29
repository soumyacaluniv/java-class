package day1;

class Studentinheritance{
String name;
int age;
String course;
public void studentName(String sname) {
name=sname;
}
public void studentAge(int sage) {
age = sage;
}
public void studentCourse(String scourse) {
course = scourse;
}
}
public class student5 extends Studentinheritance{
/* Print the details */
public void printStudent() {
System.out.println("Name:" + name);
System.out.println("Age:" + age );
System.out.println("Course:" + course );
}
public static void main(String [] args)
{
student5 s1 = new student5();
s1.studentName("A");
s1.studentAge(21);
s1.studentCourse("MCA");
s1.printStudent();
}
}