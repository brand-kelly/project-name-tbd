/*****************************************************************************/
/*Author: Brandon Kelly                                                      */
/*Last Date Updated: 03.25.2016                                              */
/*Version: 1.35                                                              */
/*Title: CMPS 280 Program Four, Spring 2016                                  */
/*Description: This program reads in a .csv with information of professors   */
/* 	           and writes their information to an organized .text file       */
/*****************************************************************************/
package cmucs280;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;

import javax.swing.JFileChooser;

/** Main class Cloud_Computing_University_CMPS 280 */
public class Cloud_Computing_University_CMPS280 {                               // begin main class
	/** Main method */
    public static void main (String[] args) throws IOException {
        String splitBy = ",";
        
        // Creates chooser object of the JFileChooser type to allow browsing for the needed input file
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
            try {
            	// creates all local variables for the Main Method
                java.util.Date date = new java.util.Date();
            	FileReader fr = new FileReader(chooser.getSelectedFile().getPath());
                BufferedReader readIn = new BufferedReader(fr);
                Professor[] profs = new Professor[42];
                String line;
                DecimalFormat df = new DecimalFormat("#.00");
        		Writer outfile = new BufferedWriter(new FileWriter("outfile.txt"));
        		outfile.write(Header());
                int i = 0;
                double paySum = 0;
                // starts reading .csv input file
                while((line = readIn.readLine()) != null) {

                    String[] b = line.split(splitBy);

                    // First field is "1","2","3" to check for Professor rank for creating Professor[] array appropriately
                    if (b[0].equals("1")) {
                        // entry is an Assistant Professor
                        profs[i] = new AssistantProfessor(b[1], b[2], Integer.parseInt(b[3]), Boolean.parseBoolean(b[4]), Double.parseDouble(b[5]), b[6]);
                    } else if (b[0].equals("2")) {
                    	// entry is an Associate Professor
                        profs[i] = new AssociateProfessor(b[1], b[2], Integer.parseInt(b[3]), Boolean.parseBoolean(b[4]), Double.parseDouble(b[5]), b[6]);
                    } else if (b[0].equals("3")) {
                    	// entry is an Full Professor
                        profs[i] = new FullProfessor(b[1], b[2], Integer.parseInt(b[3]), Boolean.parseBoolean(b[4]), Double.parseDouble(b[5]), b[6]);
                    } else {
                    	// returns an error if not a valid professor type
                        System.out.println("Entry is not a valid professor type");
                    }
                    String outputAlignment = String.format("%-25s %-12s %-16s %-13s %-14s %-12s", profs[i].professorName, profs[i].iDentification, professorRank(b[0]), isCSIT(profs[i].isCS), df.format(profs[i].hourlyRate), 
            				profs[i].researchInterest);
                    outfile.write(outputAlignment + "\n");
                    i++;
                }

                outfile.write("\n\nMonthly Pay\n\n");
                for (int j = 0; j < 21; j++){
                	outfile.write(String.format("%-25s %12s", profs[j].professorName,"$" + df.format(profs[j].getPay())) + "\n");
                	paySum += profs[j].calculate_netpay();
                }
                outfile.write("\nTotal Salary for all professors on campus for the month (" + date.toString() + "):  $");

                outfile.write(df.format(paySum));
                outfile.close();
                readIn.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    /** Header method that organizes header for outfile writing */
	public static String Header(){
		/** Created to align header of the text file */
		String header = String.format("%-25s %-12s %-16s %-13s %-14s %-12s"
				, "Professor", "ID", "Rank", "Department", "Pay rate", 
				"Research Interest");

		String mainHeader = ("               CMPS 280 Program Four, Spring 2016, Brandon Kelly\n"
				+"		      ---------------------------------------------------\n\n" +
				header + "\n" + "=========================================="
				+ "===================================================================\n");
		return mainHeader;
	}
	/** professorRank method that compares their rank number to appropriate professor title */
	public static String professorRank(String i){
		if (i.equals("1")){
			return "Assistant";
		} else if (i.equals("2")){
			return "Associate";
		} else if (i.equals("3")){
			return "Full Professor";
		} else {
			return "Error";
		}
	}
	/** isCSIT method that checks to see if Professor is in CSIT department or not */
	public static String isCSIT(boolean i) {
		if (i == true){
			return "CSIT";
		}
		else
			return "N/A";
	}
}