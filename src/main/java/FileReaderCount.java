import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileReaderCount {

    public static void countOccurrence(String filename, String word) {
        try {
            String fileContent = FileUtils.readFileToString(new File(filename));
            int count = StringUtils.countMatches(fileContent, word);
            System.out.println("Occurences of " + word + " : " + count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void countUniqueWords(String inputFile, String outputFile){
        try {

            String inputFileContent = FileUtils.readFileToString(new File(inputFile));
            Set<String> uniqueSet = new HashSet<>(List.of(StringUtils.split(inputFileContent.toLowerCase())));
            String output = "Unique words : " + uniqueSet.size();
            FileUtils.writeStringToFile(new File(outputFile), output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        FileReaderCount.countOccurrence("repeated_words.txt", "happened");
        FileReaderCount.countUniqueWords("repeated_words.txt","repeated_words_output.txt");

    }
}
