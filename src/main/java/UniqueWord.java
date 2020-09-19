import java.util.HashSet;
import java.util.Set;

import Exception.InputEmptyException;


public class UniqueWord {

    public int getUniqueWordCount(String input) {

        if(input.length() == 0 ){
            throw new InputEmptyException("Input can not be empty!");
        }

        String realInput = input.toLowerCase();
        String[] words = realInput.trim().split("[ .,?!:;]");
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            if(!word.equals("")){
                uniqueWords.add(word);
            }

        }

        System.out.println(uniqueWords.toString());
        System.out.println("------");

        return uniqueWords.size();

    }

}
