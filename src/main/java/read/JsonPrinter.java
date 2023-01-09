package read;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class JsonPrinter {
    private final ArrayList<User> users = new ArrayList<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String json;

    public void main(File file) {

        String content = read(file).toLowerCase();
        addToList(content);
        writeToJsonFile(users);
        System.out.println(json);
    }

    private String read(File file) {

        return new FileContentReader().read(new File(file, "users.txt"));
    }

    private void addToList(String content) {

        String[] lines = content.split("\n");
        for (int j = 1; j < lines.length; j++) {
            String[] user = lines[j].split(" ");
            String name = user[0];
            int age = Integer.parseInt(user[1]);
            this.users.add(new User(name, age));
        }
    }
        /*
            Хотів окремо використати метод для створення файлу,
            але із-за того, що FileOutputStream всеодно створює необхідний файл,
            я не побачив доцільності в використанні цього методу.
            Але якщо цей метод дійсно потрібен цьому класу,
            то буду дуже вдячним, якщо підкажете як би його краще імплементувати сюди
            за урахуванням властивості FileOutputStream щодо створення нових файлів!
       */
//    private void createJsonFile(File file) {
//        File jsonFile = new File(file, "user.json");
//        if (!jsonFile.exists()) {
//            try {
//                jsonFile.createNewFile();
//            } catch (IOException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//    }

    private void writeToJsonFile(ArrayList<User> users) {

        try (FileOutputStream fos = new FileOutputStream("files\\user.json")) {
            json = gson.toJson(users);
            byte[] buffer = json.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
