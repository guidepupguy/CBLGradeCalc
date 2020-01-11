import java.util.ArrayList;

public class GradeList {
	protected ArrayList<Double> grades;
	protected String name;

	public GradeList(){
		grades=new ArrayList<Double>(0);
	}
	
	public GradeList(float[] gradesIn){
		grades=new ArrayList<Double>(0);
		for(float x:gradesIn){
			grades.add((double) x);
		}
	}
	
	public Double[] getGrades(){
		return grades.toArray(new Double[0]);
	}
	
	public double getGrade(int x){
		try{
			return grades.get(x);
		}catch(Exception error){
			return -1.0;
		}
	}
	
	public double getLatestGrade(){
		return grades.get(grades.size()-1);
	}
	
	public String toString(){
		String output="{"+name+",";
		for(Double x:grades){
			output+=(x.toString()+",");
		}
		output=output.substring(0, output.length()-1);
		output+="}";
		return output;
	}
	
	public int size(){
		return grades.size();
	}
}	
