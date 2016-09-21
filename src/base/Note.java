package base;

import java.util.*;

public class Note implements Comparable<Note> {

 private Date date;
 private String title;

 public Note(String title){

   this.title = title;
   date = new Date(System.currentTimeMillis());

 }

 public String getTitle(){

   return this.title;

 }

 public boolean equals(Note inputNote){

   if ( title.equals( inputNote.getTitle() ))
     return true;

   return false;

 }

 public int compareTo(Note o){
 
	if ( date.before(o.date) )
		return 1;
	else if ( date.after(o.date) )
		return -1;
	
	return 0;
	 
// return !(date.compareTo(o.date));
 }
 
 public String toString(){
 
	 return date.toString() + "\t" + title;
 
 }
 
 
}

