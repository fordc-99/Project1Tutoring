import java.util.ArrayList;
import java.util.Collections;

public class Schedule {

	private String[][] schedule;
	private String[] days = { "M", "T", "W", "H", "F" };

	public Schedule() {
		schedule = new String[13][5];
	}

	public void addPeriod(String day, int time, String name) {
		for (int i = 0; i < days.length; i++) {
			if (day.equals(days[i])) {
				if (schedule[(time / 100) - 9][i] == null)
					schedule[(time / 100) - 9][i] = name;
				else
					schedule[(time / 100) - 9][i] += "," + name;
			}
		}
	}

	public void printSchedule() {
		System.out.println("     M  T  W  H  F");
		for (int i = 0; i < schedule.length; i++) {
			System.out.print(String.format("%04d", i * 100 + 900));
			for (int j = 0; j < schedule[i].length; j++) {
				String x = schedule[i][j];
				if (x == null)
					x = "";
				System.out.print("[" + x + "]");
			}
			System.out.println();
		}
	}

	public void findTimes() {
		System.out.println("\nBest three times:\n");
		ArrayList<Period> studentTimes = new ArrayList<Period>();
		for (int i = 0; i < schedule.length; i++) {
			for (int j = 0; j < schedule[i].length; j++) {
				if (schedule[i][j] != null) {
					studentTimes.add(new Period(days[j], i * 100 + 900,
							schedule[i][j].split(",")));
				}
			}
		}
		for (int x = 0; x < 3; x++) {
			Collections.sort(studentTimes);

			System.out.println(studentTimes.get(0));

			if (x != 2) {
				ArrayList<String> toRemove = studentTimes.get(0).getStudents();
				studentTimes.remove(0);
				
				System.out.println("Need to remove follwing students from schedule: " + toRemove + "\n");
			

				for (int i = 0; i < studentTimes.size(); i++) {
					studentTimes.get(i).removeStudents(toRemove);
				}
			}
			
			
		}
	}
}
