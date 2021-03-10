package ValidateBraces;

import java.sql.SQLOutput;
import java.util.*;

public class ValidateBraces {
private static final Map<Character,Character> bracesMAp = new HashMap<>();
public static void main(String[] args){
    bracesMAp.put('}','{');
    bracesMAp.put(')','(');
    bracesMAp.put(']','[');
    String bracesString ="{()}}}}";
    System.out.println(validatebraces(bracesString ));


    }

    private static boolean validatebraces(String bracesString) {
        Stack<Character> openingBracesStack = new Stack<>();
        try {
            for (int i = 0; i < bracesString.length(); i++) {
                char character = bracesString.charAt(i);
                if (bracesMAp.values().contains(character)) {
                    openingBracesStack.push(character);
                }


                if (bracesMAp.containsKey(character)) {
                    char lastRemovedOpeningParen = openingBracesStack.pop();
                    if (lastRemovedOpeningParen != bracesMAp.get(character) && openingBracesStack.isEmpty()) {
                        return false;
                    }
                }

            }
            return openingBracesStack.isEmpty();
        } catch (EmptyStackException e) {
            return false;
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }
        return false;
    }
}


