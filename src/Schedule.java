
public class Schedule {
	
	private int[][] schedule;
	private String[] days = {"M", "T", "W", "H", "F"};
	
	public Schedule() {
		schedule = new int[13][5];
	}
	
	public void addPeriod(String day, int time) {
		for (int i=0; i<days.length; i++) {
			if (day.equals(days[i])) {
				schedule[i][(time/100) - 9]++;
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
		
	}
}
