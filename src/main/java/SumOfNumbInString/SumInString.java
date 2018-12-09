package SumOfNumbInString;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumInString {

    public static void main(String[] args) {
       Integer sum =  sumStringSimple("dsfa123w23wgeaweg-1 1");

        System.out.println(sum);
        System.out.println("------------------------");
       Integer sum2 = sumStringPattern("dsfa123w23wgeaweg-1 1");
        System.out.println(sum2);

    }

    public static Integer sumStringSimple(String input){


        String newInput  = input.replaceAll("-?[a-zA-Z]+", " ");
        System.out.println(newInput);
        String[] splittedString = newInput.split("\\s+");
        Integer sum = 0 ;

            for (String word : splittedString) {
                System.out.println(word);
                if(!word.isEmpty())
                sum += Integer.parseInt(word);
            }


        return sum;
    }

    public static Integer sumStringPattern(String input){
        Pattern p = Pattern.compile("(-?\\d+)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        Integer sum = 0;
        List<Integer> lista = new ArrayList<>();
        while(m.find()){
           lista.add(Integer.parseInt(m.group()));
        }
        for (Integer number : lista){
           sum += number;
        }


        return sum;
    }

}
