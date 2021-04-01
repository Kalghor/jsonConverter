import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Path path = Paths.get("questions.txt");
        File file = new File("result.json");
        Map<String, String> questionsAndAnswers = new HashMap<>();
        if(!Files.exists(path)){
            throw new RuntimeException("File is not exist!");
        }
        try (Scanner scan = new Scanner(path)) {
            while (scan.hasNext()){
                String line = scan.nextLine();
                String[] arr = line.split("/");
                questionsAndAnswers.put(arr[0],arr[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter pw = new PrintWriter(file)){
            pw.println(gson.toJson(questionsAndAnswers));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
