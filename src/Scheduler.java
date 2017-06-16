import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Scheduler {
	public static void main (String[] args) throws StackUnderflowException, ExpressionUnbalancedError {
		Schedule s = new Schedule();
		
		File folder = new File("src/data");
		File[] files = folder.listFiles();
		Scanner userInput = new Scanner(System.in);
		
		while (true) {
			System.out.println("would you like to add a file? (y/n)");
			if (userInput.next().toLowerCase().equals("y")) {
				System.out.println("which file would you like to add? (1st file, 2nd file, 3rd file, etc)");
				System.out.println(Arrays.toString(files));
				try {
					Scanner scanner = new Scanner(files[userInput.nextInt() - 1]);
					while (scanner.hasNextLine()) {
						try {
							isValid(scanner.nextLine(), s);
						} catch (ExpressionUnbalancedError e) {
							e.printStackTrace();
						}
					}
					scanner.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("end of input");
				userInput.close();
				break;
			}
		}
		s.printSchedule();
		s.findTimes();
	}
	
	public static void parseValid(String line, Schedule s) {
		String[] exp = line.split("<|>");
		System.out.println(Arrays.toString(exp));
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
	}
	
	public static void isValid(String dataSet, Schedule s) throws StackUnderflowException, ExpressionUnbalancedError {
		Stack<Character> stack = new Stack<Character>();
		int startVal = 0;
		for (int i=0; i<dataSet.length(); i++) {
			switch(dataSet.charAt(i)){
			case '[' :
				stack.push('[');
				//System.out.println(dataSet.charAt(i) + " detected");
				break;
			case '(' :
				stack.push('(');
				//System.out.println(dataSet.charAt(i) + " detected");
				break;
			case '<' :
				stack.push('<');
				//System.out.println(dataSet.charAt(i) + " detected");
				break;
			case ']':
				if (stack.top() == '[') {
					//System.out.println("Match found for [");
					stack.pop();
				} else {
					throw new ExpressionUnbalancedError();
				}
				break;
			case ')':
				if (stack.top() == '(') {
					//System.out.println("Match found for (");
					stack.pop();
					parseValid(dataSet.substring(startVal+1, i), s);
					startVal = i+1;
				} else {
					throw new ExpressionUnbalancedError();
				}
				break;
			case '>':
				if (stack.top() == '<') {
					//System.out.println("Match found for <");
					stack.pop();
				} else {
					throw new ExpressionUnbalancedError();
				}
				break;
			}
		}
	}
}
