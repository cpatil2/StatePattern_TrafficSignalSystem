package fourWayStreetLights.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
* <h1> Access your file! </h1>
* The FileProcessor class implements reading a given file
* line by line
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class FileProcessor{
  FileReader reader;
  BufferedReader bufferedReader;
  String line;

  /**
   * ------------------------------------------------------------------
   * This is the class constructor to open given file
   *
   * @param fileName is the actual name of input file
   * @return Nothing.
   * @exception Nothing.
   * @see Nothing
   * ------------------------------------------------------------------
   */

  public FileProcessor(String fileName){
      try {
        reader = new FileReader(fileName);
        bufferedReader = new BufferedReader(reader);
      }
      catch(FileNotFoundException FNFE){
        System.out.println("Sorry! Input File Not Found");
        System.exit(0);
      }
  }

  /**
  * -------------------------------------------------------------------
   * This is the method to read the given file line by line.
   *
   * @param Nothing is the actual name of input file.
   * @return line which is a string of line read from input file.
   * @exception IOException.
   * @see Nothing
   * ------------------------------------------------------------------
   */

  public String readLine(){

    try{
          if((line = bufferedReader.readLine())!=null) {
            //no action
          }
          else{
            reader.close();
          }
          return line;
    }
    catch (IOException e) {
      e.printStackTrace();
    }

      return line;
  }


}
