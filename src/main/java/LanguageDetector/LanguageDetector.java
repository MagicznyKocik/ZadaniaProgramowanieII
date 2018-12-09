package LanguageDetector;


import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LanguageDetector {

    public static void main(String[] args) throws APIError, IOException {

        usingKey();
        String lines = readLinesFromFile("E:\\programy w javie\\kurs\\ZadaniaProgramowanieII\\plikiJezykowe\\la-vanguardia.txt");
        sayMeWahatIsThatLanguage(lines);
        List<String> filePaths = readAllFilePatchs();
        for(String name: filePaths ){
            lines = readLinesFromFile(name);
            System.out.println(name);
            sayMeWahatIsThatLanguage(lines);
        }




    }

    private static List<String> readAllFilePatchs() throws APIError, IOException {
        File folder = new File("E:\\programy w javie\\kurs\\ZadaniaProgramowanieII\\plikiJezykowe");
        File[] listOfFiles = folder.listFiles();
        List<String> filePaths = new ArrayList<>();
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                filePaths.add(file.getCanonicalPath());
            }
        }
        return filePaths;

    }

    private static String readLinesFromFile(String filePath) throws IOException {
        String data;
        data = new String(Files.readAllBytes(Paths.get(filePath)));
        return data;
    }

    private static void sayMeWahatIsThatLanguage(String phrase) throws APIError {

        List<Result> results = DetectLanguage.detect(phrase);
        Result result = results.get(0);
        System.out.println("Language: " + result.language);
        System.out.println("Is reliable: " + result.isReliable);
        System.out.println("Confidence: " + result.confidence);
    }

    private static void usingKey() {
        DetectLanguage.apiKey = "bd3f8ea0e89a6264cbfdcced1ef1671b";
    }


}
