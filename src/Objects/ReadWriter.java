package Objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWriter {

	public Worker readworker(String file) throws FileNotFoundException {
		ArrayList<String> input = new ArrayList<>();

		File file1 = new File(file);
		Scanner reader = new Scanner(file1);
		while (reader.hasNextLine()) {
			input.add(reader.nextLine());

		}
		reader.close();

		Worker tmp = new Worker(input.get(0), Boolean.valueOf(input.get(1)),
				Boolean.valueOf(input.get(2)), Boolean.valueOf(input.get(3)),
				Double.valueOf(input.get(4)));

		if (input.size() > 4) {
			for (int i = 5; i < input.size(); i++) {
				String[] splitinput = input.get(i).split("\\s+");
				if (isInteger(input.get(i))) {
					tmp.cannotworkonday(Integer.parseInt(input.get(i)));

				}
				
				else if(isInteger(splitinput[0]) && isInteger(splitinput[1])){
					tmp.cannotwork(Integer.parseInt(splitinput[0]), Integer.parseInt(splitinput[1]));
				}
			}

		}

		return tmp;
	}

	public boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception a) {
			return false;
		}
	}
	
	public void printtofile(String filename, String dir ){
		File output = new File(filename);
		File folder = new File(dir);
		if (!folder.exists()) { new File(dir).mkdir();}
		
	}

}
