public class GradeCalc {
	
	static String[] letters={"A","A-","B+","B","C","I"};
	static double[] seventyfiverequirements={3.3,3.3,2.6,2.6,2.2,0};
	static double[] minRequirement={3,2.5,2.5,0,0,0};

	public static void main(String[] args) {
		
		Outcome testOutcome= new Outcome(new float[] {3,2,1,1},"test");
		System.out.println(testOutcome.toString());
		System.out.print("Unweight: ");
		System.out.println(testOutcome.getUnweightedAverage());
		System.out.print("Weighted: ");
		System.out.println(testOutcome.getWeightedAverage(65, 35));
		System.out.print("Highest: ");
		System.out.println(testOutcome.getHighestAverage(65, 35)+"\n");
		
		Subject testClass=new Subject(35,65);
		testClass.addOutcome(new Outcome(new float[] {4,4,1,2,4},"Analyze multiple perspectives"));
		testClass.addOutcome(new Outcome(new float[] {2,2,1,1},"test1"));
		testClass.addOutcome(new Outcome(new float[] {2,3,4,1},"test2"));
		testClass.addOutcome(new Outcome(new float[] {3,4,1,1},"test3"));
		testClass.addOutcome(new Outcome(new float[] {2,2,1,1},"test4"));
		testClass.addOutcome(new Outcome(new float[] {1,1,1,1,1,1,1,1,1,4},"test5"));
		testClass.revSort();
		for(Outcome x: testClass.getOutcomeArray()){
			System.out.print(x.toString()+" ");
			System.out.print(x.getUnweightedAverage()+" ");
			System.out.print(x.getWeightedAverage(35, 65)+" ");
			System.out.print(x.getHighestAverage(35, 65)+"\n");
		}
		
		System.out.println();
		System.out.println(); 	
		String output=getLetter(new double[] {3.7,3.6,3.4,3.2,3.2,3.2,3.18,3.1,2.6,2.2,2.0,1.75,1.6});
		System.out.println(output);
	}
	
	public static String getLetter(double[] outcomed){
		
		double s75=get75Score(outcomed);
		double low=getLowestScore(outcomed);
		int s75letter;
		for(s75letter =0; s75letter!=5;s75letter++){
			if(s75>=seventyfiverequirements[s75letter]){
				break;
			}
		}
		int lowletter;
		for(lowletter =0; lowletter!=5;lowletter++){
			if(low>=minRequirement[lowletter]){
				break;
			}
		}
		System.out.println(s75letter);
		System.out.println(lowletter);
		if(s75letter<lowletter){
			return letters[lowletter];
		}return letters[s75letter];
	}
	
	public static double getLowestScore(double[] outcomed){
		return outcomed[outcomed.length-1];
	}
	
	public static double get75Score(double[] outcomed){
		int NumRequired=(int) Math.floor(outcomed.length*0.75);
		double top=10;
		for(int x=0;x!=NumRequired;x++){
			if(outcomed[x]<top){
				top=outcomed[x];
			}
		}
		return top;
	}

}
