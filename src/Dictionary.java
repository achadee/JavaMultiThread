import java.util.*;

public class Dictionary 
{
        HashMap<String, String> dictionary = new HashMap<String, String>();

        public Dictionary() {
                dictionary.put("Queen", "the female ruler of an independent state, especially one who inherits the position by right of birth.");
        };

        public String getMeaning(String word)
        {
                return dictionary.get(word);
        }
}