/**
 *
 * @author madlen96
 */
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    public static void main(String[] args) {
        if (args.length > 0) {
            String fileName = args[0];
            String testString = args[1];
            File file = new File(fileName);
            String patternString = "^[\\s]*([a-zA-Z]+[\\s]+){1,2}[a-zA-Z]+[\\s]*$";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(testString);
            boolean matchFound;
            matchFound = matcher.lookingAt();
            if (matchFound) {
                Levenshtein levenshtein = new Levenshtein(file, testString);
                int resultLineNumber = levenshtein.calculate();
                System.out.println("Line : " + resultLineNumber);
            }
            else {
                System.out.println("given string does not match regex expression");
            }
        }
    }
}
