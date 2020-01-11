import java.util.ArrayList;

/**
 * @author A
 *
 */
public class Outcome extends GradeList {
	
	/**
	 * ID number for the outcome (unused)
	 */
	public int id;
	
	/**
	 * Constructor
	 * @param gradesIn Float array for the grades in the outcome.
	 * @param outcomeName String for the name of the outcome.
	 */
	public Outcome(float[] gradesIn, String outcomeName){
		grades=new ArrayList<Double>(0);
		for(float x:gradesIn){
			grades.add((double) x);
		}
		this.name=outcomeName;
	}
	
	/**Returns unweighted average of the outcome.
	 * @return Unweighted average
	 */
	public double getUnweightedAverage(){
		double total=0;
		for(double x:grades){//Sums up all of the elements of the array
			total+=x;
		}
		total/=this.size();//Div by the number of elements in the array
		return total;
	}
	
	/**Calculates and returns the weighted average of the outcome based on the inputted weights. (may write the weights into a variable)
	 * @param oldGradeWeight Weight out of 100 for all but the latest assignments
	 * @param latestGradeWeight Weight out of 100 for the latest assignment
	 * @return Weighted average of the outcome 
	 */
	public double getWeightedAverage(double oldGradeWeight, double latestGradeWeight){
		oldGradeWeight/=100;
		latestGradeWeight/=100;
		if(size()==1){ //If the array is only 1 element long, return the only grade.
			return this.getLatestGrade();
		}
		double oldGradeTotal=0;
		for(int x=0;x<this.size()-1;x++){ //Add up all the grades
			oldGradeTotal+=this.getGrade(x); 
		}
		oldGradeTotal/=this.size()-1; //Calculate the average and do the weighting things
		oldGradeTotal*=oldGradeWeight;
		double latestGradeTotal;
		latestGradeTotal=this.getLatestGrade();
		latestGradeTotal*=latestGradeWeight;
		return oldGradeTotal+latestGradeTotal;
	}
	
	/** Sets ID of the outcome (Unused)
	 * @param id ID to set the outcome to
	 * @return True
	 */
	public boolean setID(int id){
		this.id=id;
		return true;
	}
	
	/**Returns the ID of the outcome (Unused)
	 * @return ID of the outcome
	 */
	public int getID() {
		return id;
	}
	
	/** Calculates both weighted and unweighted averages and returns the highest of the two.
	 * @param oldGradeWeight Whole number. EX 65% as 65
	 * @param latestGradeWeight Whole number. EX 65% as 65
	 * @return Highest average of the calculated averages, weighted and unweighted
	 */
	public double getHighestAverage(double oldGradeWeight, double latestGradeWeight){
		double weight=getWeightedAverage(oldGradeWeight, latestGradeWeight);
		double unweight=getUnweightedAverage();
		
		if(weight>unweight){/*System.out.println(weight+">"+unweight);*/return weight;}
		else {/*System.out.println(weight+"<"+unweight);*/return unweight;} 
	}
	
}
