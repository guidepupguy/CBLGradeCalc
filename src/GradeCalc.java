import java.util.Scanner;

public class GradeCalc {
	
	static String[] letters={"A","A-","B+","B","C","I"};
	static double[] seventyfiverequirements={3.3,3.3,2.6,2.6,2.2,0};
	static double[] minRequirement={3,2.5,2.5,0,0,0};
	
	static Scanner input=new Scanner(System.in);
	
	public static boolean debugmode=true;

	public static void main(String[] args) {
	
		Subject testClass=new Subject(35,65);
		testClass.addOutcomes(new double[][] {{4,4,3},{4,3},{4,3,4,4,2,2},{4,4,1,2,4,2.5},{4,2,1,3,3,4},{4,2,2,2,3,3,4,2},{4,2,4,1,2,1,4,4},{4,1,1,3,3,2.5},{2,4,1,4,3},{3,2,3,1,3,2,2,3},{1,2},{1}},new String[]{"Success Skill: Self Direction","Success Skills: Collaboration","Explain what happened:","Analyze multiple perspectives","Evidence to support a claim","Asking Questions","Evaluate Arguments","Critical Reading","Claims","Speaks Publicly","Human Geography","Evaluate Sources"});
		testClass.revSort();
		for(Outcome x: testClass.getOutcomeArray()){
			System.out.print(x.toString()+" ");
			System.out.print(x.getUnweightedAverage()+" ");
			System.out.print(x.getWeightedAverage(35, 65)+" ");
			System.out.print(x.getHighestAverage(35, 65)+"\n");
		}
		
		System.out.println();
		System.out.println(); 	
		System.out.println(getLetter(testClass.getOutcomeAverages()));
//		String output=getLetter(new double[] {3.7,3.6,3.4,3.2,3.2,3.2,3.18,3.1,2.6,2.2,2.0,1.75,1.6});
//		System.out.println(output);
	}
	
	
	
	/**Calculates and returns the grade letter based on the double array input of grades.
	 * @param outcomed Array of outcome averages sorted highest to lowest(RTL)
	 * @return Grade letter for the given class
	 */
	public static String getLetter(double[] outcomed){
		
		double s75=get75Score(outcomed);
		double low=getLowestScore(outcomed);
		int s75letter;
		for(s75letter =0; s75letter!=5;s75letter++){ // loop the array of requirements for 75% of outcomes, and break at the correct one to set s75letter to the correct position in the array 
			if(s75>=seventyfiverequirements[s75letter]) break;
		}
		int lowletter;
		for(lowletter =0; lowletter!=5;lowletter++){// loop the array of requirements for lowest outcome, and break at the correct one to set s75letter to the correct position in the array 
			if(low>=minRequirement[lowletter]) break;
		}
		if(debugmode){
			System.out.println(s75letter);
			System.out.println(lowletter);
		}
		return (s75letter<lowletter) ?  letters[lowletter] :  letters[s75letter] ;
	}
	
	public static double getLowestScore(double[] outcomed){
		return outcomed[outcomed.length-1];
	}
	
	public static double get75Score(double[] outcomed){
		int NumRequired=(int) Math.floor(outcomed.length*0.75);
		double top=10;
		for(int x=0;x!=NumRequired;x++){
			if(outcomed[x]<top) top=outcomed[x];
		}
		return top;
	}

}
