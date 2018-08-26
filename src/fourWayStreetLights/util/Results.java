package fourWayStreetLights.util;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
* <h1>Operations on Results!</h1>
* This class templates the structure of results obtained after performing
* various operations on trafficSignal. It provides the functions that can
* store results locally and write those results to console and files.
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class Results implements FileDisplayInterface, StdoutDisplayInterface{
    private ArrayList<String> testResults;
    FileWriter writer;
    BufferedWriter bufferedWriter;
    String line;
    
    public Results() {
    	
    }
   /**
   * ----------------------------------------------------------
   * This is the class constructor to open given file
   *
   * @param Nothing.
   * @return Nothing.
   * @exception Nothing.
   * @see Nothing
   * ------------------------------------------------------------------
   */

  public Results(String fileName){


    testResults=new ArrayList<String>();
    try {
      writer = new FileWriter(fileName);
      bufferedWriter = new BufferedWriter(writer);
    }
    catch (IOException e) {
      e.printStackTrace();
    }


  }

  /**
  * -------------------------------------------------------------------
   * This is the method to access all results strings of all tests
   *
   * @param Nothing
   * @return Nothing.
   * @exception Nothing.
   * @see Nothing
   * ------------------------------------------------------------------
   */

  public void accessResultsToPrint(){

    for(String s:testResults){
      writeToFile(s);
    }

    // All Test Results are written to output files
    // So closing the output stream
    try{
        bufferedWriter.close();
    }
    catch (IOException e) {
     e.printStackTrace();
    }

  }

  /**
  * -------------------------------------------------------------------
   * This is the method to store resul strings within results instance
   * for future use
   * @param str is the actual result string to be stored
   * @return Nothing.
   * @exception Nothing.
   * @see Nothing
   * ------------------------------------------------------------------
   */

  public void storeNewResult(String str){
	  str+= "\n";
      testResults.add(str);
  }

  /**
  * -------------------------------------------------------------------
   * This is the method to write results to outputfile
   *
   * @param s is the actual result to be wriiten to file.
   * @return Nothing.
   * @exception Nothing.
   * @see Nothing
   * ------------------------------------------------------------------
   */

  public void writeToFile(String s){
    //File write code goes here
    try{
      bufferedWriter.write(s);
    }
    catch (IOException e) {
     e.printStackTrace();
    }

  }

  /**
  * -------------------------------------------------------------------
   * This is the method to write results to console
   *
   * @param str is the actual result to be wriiten to console.
   * @return Nothing.
   * @exception Nothing.
   * @see Nothing
   * ------------------------------------------------------------------
   */

  public void writeToStdout(String str){
    System.out.println(str);
  }
}
