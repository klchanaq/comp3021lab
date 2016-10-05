package base;

import java.io.Serializable;
import java.util.*;

public class Folder implements Comparable<Folder>, Serializable {

	private ArrayList<Note> notes;
	private String name;
	private static final long serialVersionUID = 1L;
	
	public Folder(String name) {

		this.name = name;
		notes = new ArrayList<Note>();

	}

	public void addNote(Note newNote) {

		notes.add(newNote);

	}

	public String getName() {

		return this.name;

	}

	public ArrayList<Note> getNotes() {

		return this.notes;

	}

	public String toString() {

		int nText = 0;
		int nImage = 0;

		// TODO

		for (Note note : notes) {

			if (note instanceof TextNote)
				nText++;
			else if (note instanceof ImageNote)
				nImage++;

		}

		return name + ":" + nText + ":" + nImage;

	}

	public boolean equals(Object anotherObject) {

		if (name.equals(((Folder) anotherObject).getName()))
			return true;

		return false;

	}

	public int compareTo(Folder f) {

		return name.compareTo(f.name);

	}

	public void sortNotes() {

		Collections.sort(notes);

	}

	public List<Note> searchNotes(String keywords) {

		List<Note> List_notes = new ArrayList<Note>();
		String[] strSplit = keywords.split(" ", 0);

		List<String> andArr = new ArrayList<>();
		List<String> orArr = new ArrayList<>();

		for (int i = 0; i < strSplit.length; i++) {

			if (strSplit[i] != null && strSplit[i].equalsIgnoreCase("or")) {

				orArr.add(strSplit[i + 1].toLowerCase());
				orArr.add(strSplit[i - 1].toLowerCase());
				strSplit[i] = strSplit[i + 1] = strSplit[i - 1] = null;

			}

		}

		for (String s : strSplit) {
			if (s != null)
				andArr.add(s.toLowerCase());
		}

		for (Note n : notes) {

			boolean consistOfKeys = true;
			boolean consistOfContent = true;
			if (n instanceof ImageNote) {

				String nTitle = n.getTitle().toLowerCase();

				for (String s : andArr) {
					if (nTitle.contains(s))
						;
					else
						consistOfKeys = false;
				}

				for (int j = 0; j < orArr.size(); j += 2) {

					if (nTitle.contains(orArr.get(j)) || nTitle.contains(orArr.get(j + 1)))
						;
					else
						consistOfKeys = false;

				}

				consistOfContent = false;

			} else if (n instanceof TextNote) {

				String nTitle = n.getTitle().toLowerCase();
				String nContent = ((TextNote) n).getContent().toLowerCase();

				for (String s : andArr) {
					if (nTitle.contains(s))
						;
					else
						consistOfKeys = false;
				}

				for (int j = 0; j < orArr.size(); j += 2) {

					if (nTitle.contains(orArr.get(j)) || nTitle.contains(orArr.get(j + 1)))
						;
					else
						consistOfKeys = false;

				}

				for (String s : andArr) {

					if (s != null && nContent.contains(s))
						;
					else
						consistOfContent = false;

				}

				for (int j = 0; j < orArr.size(); j += 2) {

					if (nContent.contains(orArr.get(j)) || nContent.contains(orArr.get(j + 1)))
						;
					else
						consistOfContent = false;
				}

			}

			if (consistOfKeys || consistOfContent)
				List_notes.add(n);

		}

		return List_notes;
	}

}