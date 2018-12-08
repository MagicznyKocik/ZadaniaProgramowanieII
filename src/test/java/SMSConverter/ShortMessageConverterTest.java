package SMSConverter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class ShortMessageConverterTest {

    @ParameterizedTest
    @MethodSource("shortMessages")
    void convertTest(String phrase, String expectedPhrase) {
        ShortMessageConverter shortMessageConverter = new ShortMessageConverter();
        String convertedPhrase = shortMessageConverter.convert(phrase);

        assertEquals(expectedPhrase,convertedPhrase);

    }

    static Stream<Arguments> shortMessages(){
        return Stream.of(arguments("Ala ma kota, a kot ma , ale", "AlaMaKota,AKotMa,Ale"),arguments("Kobyłka ma gruby Bok", "KobyłkaMaGrubyBok"));
    }


    @ParameterizedTest
    @MethodSource("messageNumbers")
    void countMessagesTest(String word, int expectedNumber) {

        ShortMessageConverter shortMessageConverter = new ShortMessageConverter();
        int countedMessages =  shortMessageConverter.countMessages(word);
        assertEquals(expectedNumber,countedMessages);


    }
    static Stream<Arguments> messageNumbers(){
        return Stream.of(arguments("adasersjgopj, stacjn",1), arguments("adasersjgopj, stacjnadasersjgopj, stacjnadasersjgopj, stacjnadasersjgopj, stacjnadasersjgopj, stacjnadasersjgopj, stacjnadasersjgopj, stacjnadasersjgopj, stacjnadasersjgopj, stacjn", 2));
    }
}