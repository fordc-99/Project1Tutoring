
public class Period implements Comparable<Period>{
	
	private String day;
	private int time;
	private int numStudents;
	
	public Period(String d, int t, int numStud) {
		day = d;
		time = t;
		numStudents = numStud;
	}
	
	public String getDay() {
		return day;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getNumStudents() {
		return numStudents;
	}
	
	@Override     
	public String toString() {         
		return day + " at " + time + " has " + numStudents + " students.";     
	} 
	
	@Override     
	public int compareTo(Period period) {          
	    return (this.getNumStudents() > period.getNumStudents() ? -1 : 
	            (this.getNumStudents() == period.getNumStudents() ? 0 : 1));     
	}
}
