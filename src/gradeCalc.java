public class gradeCalc {

	public static void main(String[] args) {
		
		outcome testOutcome= new outcome(new float[] {3,2,1,1},"test");
		System.out.println(testOutcome.toString());
		System.out.print("Unweight: ");
		System.out.println(testOutcome.getUnweightedAverage());
		System.out.print("Weighted: ");
		System.out.println(testOutcome.getWeightedAverage(65, 35));
		System.out.print("Highest: ");
		System.out.println(testOutcome.getHighestAverage(65, 35));
		
		classButTheSchoolKind testClass=new classButTheSchoolKind(35,65);
		testClass.addOutcome(new outcome(new float[] {4,4,1,2,4},"Analyze multiple perspectives"));
		testClass.addOutcome(new outcome(new float[] {2,2,1,1},"test1"));
		testClass.addOutcome(new outcome(new float[] {2,3,4,1},"test2"));
		testClass.addOutcome(new outcome(new float[] {3,4,1,1},"test3"));
		testClass.addOutcome(new outcome(new float[] {2,2,1,1},"test4"));
		testClass.addOutcome(new outcome(new float[] {1,1,1,1,1,1,1,1,1,4},"test5"));
		testClass.revSort();
		for(outcome x: testClass.getOutcomeArray()){
			System.out.print(x.toString()+" ");
			System.out.print(x.getUnweightedAverage()+" ");
			System.out.print(x.getWeightedAverage(35, 65)+" ");
			System.out.print(x.getHighestAverage(35, 65)+"\n");
		}
	}

}
