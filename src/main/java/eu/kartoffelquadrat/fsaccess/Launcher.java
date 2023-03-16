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
import org.apache.commons.codec.digest.DigestUtils;
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
    DigestUtils.md5(Long.toString(System.currentTimeMillis()));

    File location = new File(getRandomHexString() + ".txt");
    FileUtils.writeStringToFile(location, greeting, StandardCharsets.UTF_8);

    // Attempt to load from disk
    String loadedString = FileUtils.readFileToString(location, StandardCharsets.UTF_8);
    System.out.println("Loaded String: " + loadedString);

    // Print listing of all files created before. List will grow on program restart, if file system
    // is persistent.
    Collection<File> allSuffixedFiles =
        FileUtils.listFiles(Paths.get(".").toFile(), new String[] {"txt"}, false);
    for (File file : allSuffixedFiles) {
      System.out.println(file.getAbsolutePath());
    }
  }

  /**
   * Convenient helper method to create a reandom hexadecimal string.
   *
   * @return MD5 hash of random number.
   */
  private static String getRandomHexString() {
    return DigestUtils.md5Hex(Long.toString(System.currentTimeMillis()));
  }
}
