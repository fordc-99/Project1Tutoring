import java.util.ArrayList;
import java.util.Collections;


public class Schedule {
	
	private int[][] schedule;
	private String[] days = {"M", "T", "W", "H", "F"};
	
	public Schedule() {
		schedule = new int[13][5];
	}
	
	public void addPeriod(String day, int time) {
		for (int i=0; i<days.length; i++) {
			if (day.equals(days[i])) {
				schedule[(time/100) - 9][i]++;
			}
		}
	}
	
	public void printSchedule() {
		System.out.println("     M  T  W  H  F");
		for (int i=0; i<schedule.length; i++){
			System.out.print(String.format("%04d", i*100 + 900));
			for (int j=0; j<schedule[i].length; j++) {
				System.out.print(" " + schedule[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void findTimes() {
		ArrayList<Period> studentTimes = new ArrayList<Period>();
		for (int i=0; i<schedule.length; i++) {
			for (int j=0; j<schedule[i].length; j++) {
				if (schedule[i][j] != 0) {
					studentTimes.add(new Period(days[j], i*100 + 900, schedule[i][j]));
				}
			}
		}
		Collections.sort(studentTimes);
		
		System.out.println(studentTimes.get(0));
		ArrayList<String> studentsToRemove = studentTimes.get(0).getStudents();
		studentTimes.remove(0);
		for (int i=0; i<studentTimes.size(); i++) {
			
		}
	}
}
