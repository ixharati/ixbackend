import java.io.*;
import java.util.*;
import java.util.logging.Logger;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

public class problem_5{
    private static final Logger logger = Logger.getLogger(problem_5.class.getName());

    public void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age > 60) {
            throw new InvalidAgeException("age is invalid");
        }
    }

    public String removeMultipleSpaces(String s) {
        return s.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        problem_5 obj = new problem_5();
        Set<String> seen = new HashSet<>();
        List<String> Valid = new ArrayList<>();
        List<String> Invalid = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String record;
            while ((record = br.readLine()) != null) {
                try {
                    record = obj.removeMultipleSpaces(record);
                    String[] fields = record.split(",");
                    if (fields.length != 3) {
                        throw new IllegalArgumentException("Invalid record format");
                    }
                    String idStr = fields[0].trim();
                    String name = fields[1].trim();
                    String ageStr = fields[2].trim();
                    Integer id = Integer.valueOf(idStr);
                    Integer age = Integer.valueOf(ageStr);
                    obj.validateAge(age);
                    if (!seen.add(idStr)) {
                        throw new IllegalArgumentException("ID is duplicate");
                    }
                    Valid.add(id + "," + name + "," + age);
                } catch (NumberFormatException e) {
                    Invalid.add(record + " - numeric value is invalid");
                    logger.warning("Invalid no in record: " + record);
                } catch (InvalidAgeException | IllegalArgumentException e) {
                    Invalid.add(record + " - " + e.getMessage());
                    logger.warning(e.getMessage() + " in record: " + record);
                }
            }
        } catch (IOException e) {
            logger.severe("Error reading input file: " + e.getMessage());
        }
        String validFile = "C:\\Users\\harati\\Desktop\\ixBackend\\27-01-26\\valid.txt";
        String invalidFile = "C:\\Users\\harati\\Desktop\\ixBackend\\27-01-26\\invalid.txt";
        writeToFile(validFile, Valid);
        writeToFile(invalidFile, Invalid);
        logger.info("File processing successfully completed");
    }

    private static void writeToFile(String path, List<String> records) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String r : records) {
                bw.write(r);
                bw.newLine();
            }
        } catch (IOException e) {
            Logger.getLogger(problem_5.class.getName()).severe("Error writing file " + e.getMessage());
        }
    }
}
