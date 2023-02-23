/**
 * Minimal program to test write and read access to file system.
 *
 * @author Maximilian Schiedermeier
 */

package eu.kartoffelquadrat.fsaccess;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;

/**
 * Main launcher class.
 */
public class Launcher {

  /**
   * Main method to test access to file system write and read using apache commons.
   *
   * @param args not used
   * @throws IOException in case of read or write error.
   */
  public static void main(String[] args) throws IOException {

    // Attempt to write to disk
    String greeting = "Hello, World!";
    File location = new File("greeting.txt");
    FileUtils.writeStringToFile(location, greeting, StandardCharsets.UTF_8);

    // Attempt to load from disk
    String loadedString = FileUtils.readFileToString(location, StandardCharsets.UTF_8);
    System.out.println("Loaded String: " + loadedString);
  }
}
