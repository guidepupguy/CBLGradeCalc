
/**
 * @author A
 *
 */
public class Subject {
	
	protected Outcome[] outcomes;
	
	protected double oldGradeWeight;
	protected double latestGradeWeight;

	public Subject(){
		outcomes=new Outcome[0];
		oldGradeWeight=0;
		latestGradeWeight=0;
	}
	
	public Subject(double oldWeight, double latestWeight){
		outcomes=new Outcome[0];
		oldGradeWeight=oldWeight;
		latestGradeWeight=latestWeight;
	}
	
	
	/**Swaps the positions of 2 outcomes in the array
	 * @param outcome1Pos Position of the first outcome
	 * @param outcome2Pos Position of the second outcome
	 * @return true
	 */
	protected boolean swap(int outcome1Pos, int outcome2Pos){
		Outcome outcome1;
		Outcome outcome2;
		outcome1=outcomes[outcome1Pos];
		outcome2=outcomes[outcome2Pos];
		outcomes[outcome1Pos]=outcome2;
		outcomes[outcome2Pos]=outcome1;
		
		return true;
	}
	

	/**Add new outcome to the class, without any sorting.
	 * Probably will rewrite at some point
	 * @param newOutcome Outcome class to add to the class
	 * @return true
	 */
	public boolean addOutcome(Outcome newOutcome){
		
		Outcome[] tempOutcomeArray= outcomes;
		int tempOutcomeSize=outcomes.length;
		outcomes=new Outcome[tempOutcomeSize+1];
		for(int x=0;x<tempOutcomeSize;x++){
			outcomes[x]=tempOutcomeArray[x];
		}
		outcomes[tempOutcomeSize]=newOutcome;
		
		return true;
	}
	
	public Outcome getOutcome(int position){
		return outcomes[position];
	}
	
	/**
	 * Sorts the outcomes lowest to highest 
	 */
	public void sort(){
		boolean isSorted;
		do{
			isSorted=true;
			for(int x=0;x<outcomes.length-1;x++){
				if(outcomes[x].getHighestAverage(oldGradeWeight, latestGradeWeight)>outcomes[x+1].getHighestAverage(oldGradeWeight, latestGradeWeight)){
					swap(x,x+1);
					/*for(outcome y: this.getOutcomeArray()){
						System.out.print(y.toString()+" ");
						System.out.print(y.getUnweightedAverage()+" ");
						System.out.print(y.getWeightedAverage(35, 65)+" ");
						System.out.print(y.getHighestAverage(35, 65)+"\n");
					}
					System.out.println("Switch "+outcomes[x].getHighestAverage(oldGradeWeight, latestGradeWeight)+" and "+outcomes[x+1].getHighestAverage(oldGradeWeight, latestGradeWeight)+"\n");*/
					isSorted=false;
				}else{
					/*System.out.println("noswap");*/
				}
			}
		}while(!isSorted);
	}
	
	/**
	 *  Sorts the outcomes highest to lowest
	 */
	public void revSort(){
		boolean isSorted;
		do{
			isSorted=true;
			for(int x=0;x<outcomes.length-1;x++){
				if(outcomes[x].getHighestAverage(oldGradeWeight, latestGradeWeight)<outcomes[x+1].getHighestAverage(oldGradeWeight, latestGradeWeight)){
					swap(x,x+1);
					/*for(outcome y: this.getOutcomeArray()){
						System.out.print(y.toString()+" ");
						System.out.print(y.getUnweightedAverage()+" ");
						System.out.print(y.getWeightedAverage(35, 65)+" ");
						System.out.print(y.getHighestAverage(35, 65)+"\n");
					}
					System.out.println("Switch "+outcomes[x].getHighestAverage(oldGradeWeight, latestGradeWeight)+" and "+outcomes[x+1].getHighestAverage(oldGradeWeight, latestGradeWeight)+"\n");*/
					isSorted=false;
				}else{
					/*System.out.println("noswap");*/
				}
			}
		}while(!isSorted);
	}
	
	/**
	 * @return Array of outcomes
	 */
	public Outcome[] getOutcomeArray(){
		return outcomes;
	}
	
	public void setLatestGradeWeight(double latestGradeWeight) {
		this.latestGradeWeight = latestGradeWeight;
	}
	
	public void setOldGradeWeight(double oldGradeWeight) {
		this.oldGradeWeight = oldGradeWeight;
	}
}
