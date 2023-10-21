package co.edu.uptc.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uptc.model.Level;

public class Persistence {
	public ArrayList<Object> readLevelInfo() {
		ArrayList<Object> fileAll = new ArrayList<Object>();
		try (FileReader fileReader = new FileReader(new File("data/level.txt"));
				BufferedReader process = new BufferedReader(fileReader)) {
			String line;
			while ((line = process.readLine()) != null) {
				if (!line.isEmpty()) {
					String[] h = line.split("	");
					for (String string : h) {
						fileAll.add(string);
					}
				}
			}
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return fileAll;

	}

	public static void main(String[] args) {
		Persistence p = new Persistence();
		System.out.println(p.readLevelInfo().toString());
		for (int i = 0; i < p.readLevelInfo().size(); i += 4) {
			System.out.println(p.readLevelInfo().get(i));
		}

//		for (int i = 3; i < p.readLevelInfo().size(); i+=4) {
//			System.out.println(p.readLevelInfo().get(i));
//		}

		for (int i = 0; i < p.readLevelInfo().size(); i++) {
			if (i % 4 == 0) {
				Level level = new Level((String)p.readLevelInfo().get(i),
						Integer.parseInt((String) p.readLevelInfo().get(i + 1)),
						Integer.parseInt((String) p.readLevelInfo().get(i + 2)),
						Integer.parseInt((String) p.readLevelInfo().get(i + 3)));
				System.out.println(level.toString());
			}

		}
	}

}
