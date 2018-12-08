package SMSConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String writtenWord = scanner.nextLine();

        ShortMessageConverter shortMessageConverter = new ShortMessageConverter();
        String finalMessage = shortMessageConverter.convert(writtenWord);
        System.out.println(finalMessage + " ilość wiadomości " + shortMessageConverter.countMessages(finalMessage));
        scanner.close();
    }


}
