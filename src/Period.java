import java.util.ArrayList;
import java.util.Arrays;

public class Period implements Comparable<Period>{
	
	private String day;
	private int time;
	private ArrayList<String> students;
	
	public Period(String d, int t, String[] studs) {
		day = d;
		time = t;
		students = new ArrayList<String>(Arrays.asList(studs));
	}
	
	public String getDay() {
		return day;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getNumStudents() {
		return students.size();
	}
	
	public ArrayList<String> getStudents() {
		return students;
	}
	
	public void removeStudents(ArrayList<String> toRemove) {
		//System.out.println("students in period: " + students);
		//System.out.println("students to remove:"  + toRemove);
		for (int i=0; i<toRemove.size(); i++) {
			if (students.indexOf(toRemove.get(i)) != -1) {
				students.remove(toRemove.get(i));
			}
		}
		//System.out.println("students left: " + students + "\n");
	}
	
	@Override     
	public String toString() {         
		return day + " at " + time + " has " + getNumStudents() + " new students: " + getStudents();     
	} 
	
	@Override     
	public int compareTo(Period period) {          
	    return (this.getNumStudents() > period.getNumStudents() ? -1 : 
	            (this.getNumStudents() == period.getNumStudents() ? 0 : 1));     
	}
}
