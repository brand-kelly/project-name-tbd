package cmucs280;
/** Abstract superclass */
abstract class Professor {
	public abstract double calculate_netpay();
    public abstract String toString();
    public String researchInterest, professorName, iDentification;
    public double Annual_Salary, hourlyRate;
    public int contract;
    public boolean isCS;
    public abstract double getPay();
}