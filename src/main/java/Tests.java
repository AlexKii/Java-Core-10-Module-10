import read.PhoneNumbersValidator;
import read.JsonPrinter;
import read.WordsCounter;

import java.io.File;

public class Tests {
    private static final File base = new File("files");

    public static void main(String[] args) {

        //task 1
        new PhoneNumbersValidator().main(base);

        //task 2
        new JsonPrinter().main(base);

        //task 3
        new WordsCounter().main(base);

    }
}
