package base;

import java.util.*;

public class NoteBook {

  private ArrayList<Folder> folders;

  public NoteBook(){
    folders = new ArrayList<Folder>();
  }

  public boolean createTextNote(String folderName, String title){

    TextNote note = new TextNote(title);
    return insertNote(folderName,note);

  }
   public boolean createTextNote(String folderName, String title, String content){

    TextNote note = new TextNote(title, content);
    return insertNote(folderName,note);

  } 

  public boolean createImageNote(String folderName, String title){

    ImageNote note = new ImageNote(title);
    return insertNote(folderName,note);

  }

  public ArrayList<Folder> getFolders(){
    return this.folders;
  }

  private boolean insertNote(String folderName, Note note){

    Folder f = null;

    // Check if an object Folder with name folderName already exists in the NoteBook
    for ( Folder f1 : folders ){

      if ( folderName.equals(   f1.getName()  )  ){
        // If yes, get the object Folder with name folderName
        f = f1;
      }

    }

      if ( f == null ){

        f = new Folder(folderName);
        folders.add(f);

      }

      for ( Note n : f.getNotes() ){

        if ( note.equals( n ) ){
          System.out.println("Creating note " + note.getTitle() + " under folder " + folderName + " failed");
          return false;
        }

      }

      f.addNote(note);
      return true;


    }

  public void sortFolders(){
	  
	for ( Folder f : this.folders ){
		f.sortNotes();
	}
		
	Collections.sort(folders);

}

public List<Note> searchNotes(String keywords){

	List<Note> listNotes = new ArrayList<>();
	
	for ( Folder f: folders ){
		listNotes.addAll(f.searchNotes(keywords));
	}
	return listNotes;

}


}

