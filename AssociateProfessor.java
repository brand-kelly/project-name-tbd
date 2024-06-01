package cmucs280;

// Subclass of the abstract Professor Class
class AssociateProfessor extends Professor {
	// creates default values if arguments fail to next constructor
	AssociateProfessor(){
        this.professorName = "";
        this.iDentification = null;
        this.contract = 9;
        this.isCS = true;
        this.hourlyRate = 1.0;
        this.researchInterest = null;
	}
	// sets variables from passing arguments
    AssociateProfessor(String assocProfessorName, String iDentification, 
            int contract, boolean isCS, double hourlyRate, String researchInterest){
        this.professorName = assocProfessorName;
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
		return ((this.contract) * 4 * 7 * 40* this.hourlyRate);	
    }
    double Annual_Salary() {
    	return this.contract*4*7*40*this.hourlyRate;
    }
    String isCSIT(boolean isCS){
    	if (isCS == true)
    		return "CSIT";
    	else
    		return "N/A";
    }
}