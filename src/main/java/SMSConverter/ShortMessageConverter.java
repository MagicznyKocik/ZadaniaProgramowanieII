package SMSConverter;

public class ShortMessageConverter {

    String convert(String message){
        String[] convMessage;
        StringBuilder endMessage = new StringBuilder();

        convMessage = message.split(" ");

        for (String word: convMessage) {
            if(word.isEmpty()) continue;
           String c = word.substring(0,1).toUpperCase();
           endMessage.append(word.replaceFirst(word.substring(0,1),c));
        }


        return endMessage.toString();
    }

    int countMessages(String convMessage){
        int counter = (convMessage.length()/160)+1;
        return counter;
    }


}
