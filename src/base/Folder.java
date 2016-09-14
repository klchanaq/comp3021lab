package base;

import java.util.*;

public class Folder {

  private ArrayList<Note> notes;
  private String name;

  public Folder ( String name ){

    this.name = name;
    notes = new ArrayList<Note>();

  }

  public void addNote(Note newNote){

    notes.add(newNote);

  }

  public String getName(){
	  
    return this.name;
    
  }

  public ArrayList<Note> getNotes(){
	  
    return this.notes;
    
  }


  public String toString(){

    int nText = 0;
    int nImage = 0;

    // TODO

    for ( Note note : notes  ){

      if ( note instanceof TextNote )
        nText++;
      else if ( note instanceof ImageNote )
        nImage++;

    }

    return name + ":" + nText + ":" + nImage;

  }

  public boolean equals(Object anotherObject){

    if ( name.equals( ((Folder)anotherObject).getName() ))
    return true;

    return false;

  }




}
