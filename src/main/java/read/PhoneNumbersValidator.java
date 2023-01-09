package read;

import java.io.File;

public class PhoneNumbersValidator {

    public void main(File file) {

        String content = read(file);
        String[] numbers = content.split("\n");
        for (String number : numbers) {
            validate(number);
        }
    }

    private String read(File file) {

        return FileContentReader.read(new File(file, "phoneNumbers.txt"));
    }

    private void validate(String str) {

        String phonePatternFirst = "\\d{3}-\\d{3}-\\d{4}";
        String phonePatternSecond = "\\(\\d{3}\\) \\d{3}-\\d{4}";

        if (str.matches(phonePatternFirst) || str.matches(phonePatternSecond)) {
            System.out.println(str);
        }
    }

}
