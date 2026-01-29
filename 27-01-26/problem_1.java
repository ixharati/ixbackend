/*
Create a program that:
Reads a paragraph from a file.
Performs the following:
-Count total words, sentences, and characters (excluding spaces).
-Find the top 5 most frequent words (case-insensitive).
-Replace multiple spaces with a single space.
-Reverse each sentence without changing word order.
Compare strings using both == and equals() and print results with explanation.
Must Use
✔ String class
✔ StringBuilder
✔ Common String methods (split, toLowerCase, trim, replace)
✔ equals() vs ==
✔ File reading
✔ Exception handling (try-catch) */

/* Basic FileReader Structure for my understanding
try(FileReader fr = new FileReader("note.txt")){
            int i = fr.read();
            while(i != -1){
                System.out.print((char) i);
                i = fr.read();
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class problem_1 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader("note.txt")) {
            int i = fr.read();
            while (i != -1) {
                sb.append((char) i);
                i = fr.read();
            }
        } catch (IOException e) {
            System.out.println("Error Reading file: " + e.getMessage());
        }
        String text = sb.toString().trim();

        int countChars = text.replace(" ", "").length();

        String[] sentences = text.split("[.!?]");
        int countSen = sentences.length;

        String[] words = text.split(" ");
        int countWords = words.length;

        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-z]", "");
            if (!word.isEmpty()) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }
        // top 5 frequent words
        System.out.println("Total words: " + countWords);
        System.out.println("Total sentences: " + countSen);
        System.out.println("Total characters(excluding spaces): " + countChars);
        System.out.println("Reversed Sentences: ");
        for (String sen : sentences) {
            String[] ws = sen.trim().split(" ");
            StringBuilder revSen = new StringBuilder();
            for (int j = ws.length - 1; j >= 0; j--) {
                revSen.append(ws[j]).append(" ");
            }
            System.out.println(revSen.toString().trim());
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println("Top 5 most frequent words:");
        for (int j = 0; j < Math.min(5, list.size()); j++) {
            System.out.println(list.get(j).getKey() + ": " + list.get(j).getValue());
        }
        String str1 = new String("Harati");
        String str2 = new String("Harati");
        System.out.println("Comparing strings:");
        System.out.println("Using '==' compares reference point, so it returns false here as both point to different objects in memory.");
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("Using 'equals()' compares actual content of strings, so it returns true here as both have the same content.");
        System.out.println("str1.equals(str2): " + str1.equals(str2));
    }

}
