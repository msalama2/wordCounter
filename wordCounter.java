import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class wordCounter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("\n First Compile the file wordCounter.java by using the comand in your terminal, 'javac wordCounter.java.'' Then, Type: 'java wordCounter.java path/to/.txtfile'\n");
            return;
        }

        String inputFile = args[0];
        String outputFile = "output.txt";

        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> wordCounts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.toLowerCase();
                int index = words.indexOf(word);
                if (index != -1) {
                    wordCounts.set(index, wordCounts.get(index) + 1);
                } else {
                    words.add(word);
                    wordCounts.add(1);
                }
            }
            int d = 0;
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 0; i < words.size(); i++) {
                bw.write(words.get(i) + " " + wordCounts.get(i));
                bw.newLine();
            }
            System.out.println("Word counts have been written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing words counted to the output file: " + e.getMessage());
        }
    }
}
