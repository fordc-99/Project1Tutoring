
public class Scheduler {
	public static void main (String[] args) {
		Schedule s = new Schedule();
		s.addPeriod("M", 900);
		s.printSchedule();
	}
}
