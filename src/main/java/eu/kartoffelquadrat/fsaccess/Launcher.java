/**
 * Minimal program to test write and read access to file system.
 *
 * @author Maximilian Schiedermeier
 */

package eu.kartoffelquadrat.fsaccess;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Collection;
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
    String greeting = "Hello, beautiful World!";
    String suffix = new String(String.valueOf(Math.random()));
    File location = new File("greeting-" + suffix + ".txt");
    FileUtils.writeStringToFile(location, greeting, StandardCharsets.UTF_8);

    // Attempt to load from disk
    String loadedString = FileUtils.readFileToString(location, StandardCharsets.UTF_8);
    System.out.println("Loaded String: " + loadedString);

    // Print everything else that possibly has been created before
    Collection<File> allSuffixedFiles =
        FileUtils.listFiles(new File(Paths.get(".").toAbsolutePath().toUri()), new String[] {"txt"},
            true);
    for (File file : allSuffixedFiles) {
      System.out.println(file.getAbsolutePath());
    }
  }
}
