package base;

import java.io.*;
import java.util.*;

//Child Class TextNote

public class TextNote extends Note implements Serializable {

	private String content;

	public TextNote(String title) {
		super(title);
	}

	public TextNote(String title, String content) {
		super(title);
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public TextNote(File f) {
		super(f.getName());
		this.content = getTextFromFile(f.getAbsolutePath());
	}

	private String getTextFromFile(String absolutePath) {
		String result = "";

		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(absolutePath));
			while (br.readLine() != null) {
				System.out.println(br.readLine());
			}
			br.close();

		} catch (IOException e) {
			return result;
		}

		return result;
	}

	public void exportTextToFile(String pathFolder) {
		// TODO

		String thisTitle = this.getTitle().replaceAll(" ", "_");
		FileWriter fw = null;
		BufferedWriter bw = null;
		File file = new File(thisTitle + ".txt");
		// TODO
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			// Exception or IOException
			e.printStackTrace();
		}

	}
}