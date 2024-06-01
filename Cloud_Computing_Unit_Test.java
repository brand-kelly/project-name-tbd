/*****************************************************************************/
/*Author: Brandon Kelly                                                      */
/*Last Date Updated: 03.25.2016                                              */
/*Version: 1.35                                                              */
/*Title: CMPS 280 Program Four, Spring 2016                                  */
/*Description: This program reads in a .csv with information of professors   */
/* 	           and writes their information to an organized .text file       */
/*****************************************************************************/
package cmucs280;

import javax.swing.JOptionPane;

public class Cloud_Computing_Unit_Test{
	public static void main(String args[]){
		new Cloud_Computing_Unit_Test();
	}

	public Cloud_Computing_Unit_Test(){
		// variables for the main class constructor
		boolean done=false;
		while(!done){
			done=true;
			String professorName, researchInterest, iDentification;
			Double hourlyRate;
			int contract;
			boolean isCS;		
			String[] rank={
					"Assistant",
					"Associate",
			"Full"};
			try{
				int professorNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "How many professors would you like to add?","Professors",
						JOptionPane.QUESTION_MESSAGE));
				Professor[] profs = new Professor[100];
				// for loop for GUI interface to pass arguments to the abstract Professor Class
				for (int i = 0; i < professorNumber; i++) {
					int rankNumber=JOptionPane.showOptionDialog(null,"What is the Professor's rank?",
							"Professor's rank",0,JOptionPane.QUESTION_MESSAGE,null,rank,0);
					professorName = JOptionPane.showInputDialog(null,"What is the professor's name? (ie: Dr. Ihssan Alkadi)",
							JOptionPane.QUESTION_MESSAGE);
					iDentification = JOptionPane.showInputDialog(null,"What is the professor's identification number? (ie: 1234567989)",
							JOptionPane.QUESTION_MESSAGE);
					contract = Integer.parseInt(JOptionPane.showInputDialog(null,"What is the professor's contract?","Professors",
							JOptionPane.QUESTION_MESSAGE));
					isCS = Boolean.parseBoolean(JOptionPane.showInputDialog(null,"Is the professor cs?","Professors",
							JOptionPane.QUESTION_MESSAGE));
					hourlyRate = Double.parseDouble(JOptionPane.showInputDialog(null,"What is the professor's hourly rate?","Professor's Hourly Rate",
							JOptionPane.QUESTION_MESSAGE));
					researchInterest = JOptionPane.showInputDialog(null,"What is the professor's research interest?","Professor's Research Interest",
							JOptionPane.QUESTION_MESSAGE);
					 // First field is "1","2","3" to check for Professor rank for creating Professor[] array appropriately
					if (rankNumber == 0){
						// Entry is an Assistant Professor
						profs[i] = new AssistantProfessor(professorName, iDentification, contract, isCS, hourlyRate, researchInterest);
					}else if(rankNumber == 1){
						// Entry is an Associate Professor
						profs[i] = new AssociateProfessor(professorName, iDentification, contract, isCS, hourlyRate, researchInterest);
					}else{
						// Entry is a Full Professor
						profs[i] = new FullProfessor(professorName, iDentification, contract, isCS, hourlyRate, researchInterest);
					}
				}
				// for loop that test the output for the profs[j] objects of the Professor type
				for (int j = 0; j < professorNumber; j++){
					System.out.println(String.format("%-25s %-12s %-16s %-13s %-14s %-12s", profs[j].professorName, profs[j].getPay(), profs[j].calculate_netpay(), profs[j].iDentification, isCSIT(profs[j].isCS), profs[j].hourlyRate));
					profs[j].toString();
					System.out.println("\n");
				}
			} catch(NullPointerException npe){
				System.out.println("Null Pointer Exception");
			}
		}
	}
	/** isCSIT method that checks to see if Professor is in CSIT department or not */
	public static String isCSIT(boolean i){
		if (i == true){
			return "CSIT";
		}
		else{
			return "N/A";
		}
	}
}
