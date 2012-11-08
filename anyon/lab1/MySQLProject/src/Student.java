
public class Student {
int id_student;
String first_name;
String last_name;

Student()
{
	
}
///////////////////////method set///////
public void set_id_student(int nr)
{
	this.id_student = nr;	
}
public void set_first_name(String Fname)
{
	this.first_name = Fname;
}
public void set_last_name(String Lname)
{
	this.last_name=Lname;
}
////////////////////////////method get/////////
public int get_id_student()
{
return id_student;	
}
public String get_first_name()
{
return first_name;	
}
public String get_last_name()
{
return last_name;	
}

}
