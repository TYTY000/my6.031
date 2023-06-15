package lesson26;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Words example: Java implementation with map/filter/reduce.
 */
public class Words2 {
    
    /**
     * Find all files in the filesystem subtree rooted at folder.
     * @param folder root of subtree, requires folder.isDirectory() == true
     * @return stream of all ordinary files (not folders) that have folder as
     *         their ancestor
     */
    static Stream<File> allFilesIn(File folder) {
        File[] children = folder.listFiles();
        Stream<File> descendants = Arrays.stream(children)
                                         .filter(File::isDirectory)
                                         .flatMap(Words2::allFilesIn);
        return Stream.concat(descendants,
                             Arrays.stream(children).filter(File::isFile));
    }
    
    /**
     * Make a filename suffix testing predicate.
     * @param suffix string to test
     * @return a predicate that returns true iff the filename ends with suffix.
     */
    static Predicate<File> endsWith(String suffix) {
        return f -> f.getPath().endsWith(suffix);
    }
    
    /**
     * Print the words in Java files in the project.
     * @param args unused
     * @throws IOException if error while reading files or folders
     */
    public static void main(String[] args) throws IOException {
        Stream<File> files = allFilesIn(new File("."))
                              .filter(endsWith(".java"));
        Stream<Path> paths = files.parallel().map(File::toPath);
        Stream<List<String>> fileContents = paths.map(path -> {
            try {
                return Files.readAllLines(path);
            } catch (IOException ioe) {
                throw new UncheckedIOException(ioe);
            }
        });
        Stream<String> lines = fileContents.flatMap(List::stream);
        Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split("\\W+"))
                                                     .filter(s -> s.length() > 0));
        words.forEach(System.out::println);
    }
}