package com.SimpleExample;

public class Stud{

	 int id_stud = 0;
	 String first_name = "";
	 String last_name = "";
	//Constructor  
	 public Stud(){
		 
	 }
	
	//method get
	public int get_id(){
		return id_stud;
	}
	public String get_first_name(){
		return first_name;
	}
	public String get_last_name(){
		return last_name;
	}
	
	 //method set
	public void set_id(int i){
		id_stud = i;
	}
	public void set_first_name(String first){
		first_name = first;
	}
	public void set_last_name(String last){
		last_name = last;
	}
}
