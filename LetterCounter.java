import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class LetterCounter {
    public static Map<Character, Integer> characters = new HashMap<>();
    public static void main(String[] args) {
        if (args.length == 0) return;
        String content = "";
        try {
            content = Files.readString(Path.of(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (content == "") return;

        for (int i = 0; i < content.length(); i++) {
            char current = content.charAt(i);

            if (!characters.containsKey(current)) characters.put(current, 1);
            else characters.put(current, characters.get(current)+1);
        }
        for (Entry<Character, Integer> entry : characters.entrySet()) {
            String key;
            if (entry.getKey() == '\n') key = "newline";
            else key = entry.getKey() + "";

            System.out.println("|" + key + "|: " + entry.getValue());
        }
    }
}