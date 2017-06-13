import java.util.ArrayList;


public class Period implements Comparable<Period>{
	
	private String day;
	private int time;
	private int numStudents;
	private ArrayList<String> students;
	
	public Period(String d, int t, int numStud) {
		day = d;
		time = t;
		numStudents = numStud;
		students = new ArrayList<String>();
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
	
	public ArrayList<String> getStudents() {
		return students;
	}
	
	public void addStudent(String student) {
		students.add(student);
	}
	
	public void removeStudent(String student) {
		students.remove(student);
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
