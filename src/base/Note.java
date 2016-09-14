package base;

import java.util.Date;

public class Note {


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

	/*  public int hashCode(){


	  }
	*/

	/*  public boolean equals(Object inputObject){


	  }
	*/
	}
