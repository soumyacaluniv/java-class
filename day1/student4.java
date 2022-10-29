package day1;
public class student4{
String name;
student4(String sname) {
name=sname;
}
public static void main(String [] args){
student4 s1 = new student4("A");
student4 s2 = new student4("B");
System.out.println(s1.name + " " + s2.name);
}
}