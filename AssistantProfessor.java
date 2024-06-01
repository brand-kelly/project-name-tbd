package cmucs280;

import java.util.Calendar;

class AssistantProfessor extends Professor {
    java.util.Date date; // your date
    Calendar cal = Calendar.getInstance();
    int month = cal.get(Calendar.MONTH) + 1;

	// creates default values if arguments fail to next constructor
	AssistantProfessor(){
        this.professorName = "";
        this.iDentification = null;
        this.contract = 9;
        this.isCS = true;
        this.hourlyRate = 1.0;
        this.researchInterest = null;
	}
	// sets variables from passing arguments
    AssistantProfessor(String assistProfessorName, String iDentification, 
            int contract, boolean isCS, double hourlyRate, String researchInterest){
        this.professorName = assistProfessorName;
        this.iDentification = iDentification;
        this.contract = contract;
        this.isCS = isCS;
        this.hourlyRate = hourlyRate;
        this.researchInterest = researchInterest;
    }
 // calculates professors monthly net pay
    @Override    
    public double calculate_netpay() {
        return (4 * (7 * 40)) * hourlyRate;
    }
    public String toString() {
        return String.format("%-25s %-12s %-16s %-13s %-14s %-12s",this.professorName + this.iDentification + this.contract + this.isCS + this.hourlyRate + this.researchInterest);
    }
    public double getPay() {
		return (2*(8 * 7 * 40 * this.hourlyRate)) + ((this.contract - 2) * 4 * 7 * 40 * this.hourlyRate);	
    }
    double Annual_Salary() {
    	return (2*(8 * 7 * 40 * this.hourlyRate)) + ((this.contract - 2) * 4 * 7 * 40 * this.hourlyRate);
    }
    double Monthly_Pay() {
    	if (month == 1){
    		return 2*(4*7*40*this.hourlyRate);
    	} else if (month == 2){
    		return 2*(4*7*40*this.hourlyRate);
    	}
    	else{
    		return 4*7*40*this.hourlyRate;
    	}
    		
    }
    String isCSIT(boolean isCS){
    	if (isCS == true)
    		return "CSIT";
    	else
    		return "N/A";
    }
}