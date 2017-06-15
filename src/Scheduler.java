import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Scheduler {
	public static void main (String[] args) {
		Schedule s = new Schedule();
		
		File myFile = new File("D:/NYU Summer 2017 Data Structs/projects/Project1Tutoring/src/data/hw1_set1.txt");
		try {
			Scanner scanner = new Scanner(myFile);
			while (scanner.hasNextLine()) {
				//System.out.println(scanner.nextLine());
				System.out.println(Arrays.toString(scanner.nextLine().split("\\(")));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*String expression = "Mario<T[1100][2000]><H[2000]>";
		String[] exp = expression.split("<|>");
		
		for (int i=0; i<exp.length; i++) {
			if (exp[i].indexOf("[") != -1) {
				String[] newexp = exp[i].split("\\[");
				for (int x=0; x<newexp.length; x++) {
					if (newexp[x].length() >= 4) {
						s.addPeriod(newexp[0], Integer.parseInt(newexp[x].substring(0, 4)), exp[0]);
					}
				}
			}
		}
		
		s.printSchedule();
		s.findTimes();*/
	}
}
