
public class Scheduler {
	public static void main (String[] args) {
		Schedule s = new Schedule();
		s.addPeriod("M", 900);
		s.addPeriod("M", 900);
		s.addPeriod("M", 900);
		s.addPeriod("T", 1000);
		s.addPeriod("T", 1000);
		s.addPeriod("F", 1500);
		s.addPeriod("F", 1500);
		s.addPeriod("H", 2100);
		s.addPeriod("F", 2100);
		s.addPeriod("F", 2100);
		s.addPeriod("F", 2100);
		s.addPeriod("F", 2100);
		s.printSchedule();
		s.findTimes();
	}
}
