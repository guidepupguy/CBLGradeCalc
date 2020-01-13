import java.util.Scanner;

public class GradeCalc {
	
	static String[] letters={"A","A-","B+","B","C","I"};
	static double[] seventyfiverequirements={3.3,3.3,2.6,2.6,2.2,0};
	static double[] minRequirement={3,2.5,2.5,0,0,0};
	
	static Scanner input=new Scanner(System.in);
	
	public static boolean debugmode=false;

	public static void main(String[] args) {
	
		Subject econClass=new Subject("Econ",35,65);
		econClass.addOutcomes(new double[][] {{4,4,3},{4,3},{4,3,4,4,2,2},{4,4,1,2,4,2.5},{4,2,1,3,3,4},{4,2,2,2,3,3,4,2},{4,2,4,1,2,1,4,4},{4,1,1,3,3,2.5},{2,4,1,4,3},{3,2,3,1,3,2,2,3},{1,2},{1}},new String[]{"Success Skill: Self Direction","Success Skills: Collaboration","Explain what happened:","Analyze multiple perspectives","Evidence to support a claim","Asking Questions","Evaluate Arguments","Critical Reading","Claims","Speaks Publicly","Human Geography","Evaluate Sources"});
		econClass.revSort();
		Subject englishClass=new Subject("English",40,60);
		englishClass.addOutcomes(new double[][]{{2,1},{4,1,1,1},{3,2,1},{1,1,4},{3,1,1,4},{1,4,4},{1.5,4,1,4,4},{2,3,2,1,4,4,4},{4,3,1,4},{3,4,1,4},{3,4,2,4},{3,3,4,4},{3,4,4}},new String[] {"ELA.1.4 - Literary Analysis","ELA 1.0 - Content/Literary Terms","ELA 4.4 -  Complex Author's Voice","SocS.1.2 - Historical Perspectives","ELA.1.2 - Evaluate Main Ideas","ELA.7.3 - Take Notes (Organize Information)","ELA.6.1 - Group Discussions (Lead/Participate)","SS.1 Self-Direction","ELA.2.4 - Editing Conventions (Spelling/Grammar and Writing Conventions)","ELA.6.2/6.3 - Prepare and Perform","SS.2 Collaboration","ELA.2.3 - Choose the appropriate medium","ELA.5.3 - Narratives (Reflective Narratives)","SS1. Self Direction","SS2. Collaboration","ELA.1.3 - Analyze Author's Argument","ELA.1.1 - Reading Strategies","ELA.4.2 - Embedding Internal Citations","ELA.2.1 - Establish a clear driving thesis","ELA.2.2 - Develop and Support Claims","ELA.3.2 - Rhetorical claims and counterclaims ","ELA.2.5 - Discuss, respond and reflect","SocS.1.3 - Historical Sources","SocS.1.1 - Historical Context","ELA.7.1 - Inquiry Essay Writing","ELA.7.2 - Marshall Evidence from Credible Sources ","ELA.7.4 - Synthesize Research Findings"});
		englishClass.revSort();
		for(Outcome x: econClass.getOutcomeArray()){
			System.out.print(x.toString()+" Unweighted:");
			System.out.print(x.getUnweightedAverage()+" Weighted:");
			System.out.print(x.getWeightedAverage(35, 65)+" Highest:");
			System.out.print(x.getHighestAverage(35, 65)+"\n");
		}
		System.out.println();
		System.out.println(); 
		for(Outcome x: englishClass.getOutcomeArray()){
			System.out.print(x.toString()+" Unweighted:");
			System.out.print(x.getUnweightedAverage()+" Weighted:");
			System.out.print(x.getWeightedAverage(35, 65)+" Highest:");
			System.out.print(x.getHighestAverage(35, 65)+"\n");
		}
		System.out.println();
		System.out.println();
		System.out.println("Econ:");
		System.out.println(getLetter(econClass.getOutcomeAverages()));
		System.out.println("English:");
		System.out.println(getLetter(englishClass.getOutcomeAverages()));
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
