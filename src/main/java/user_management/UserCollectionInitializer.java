package user_management;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import parsing_json.Element;
import parsing_json.ElementCollection;

import java.io.FileReader;
import java.io.IOException;

public class UserCollectionInitializer {
    public static UserCollection generate() throws IOException {

        UserCollection userCollection = new UserCollection();

        Gson parser = new Gson();
        JsonReader jReader = new JsonReader(new FileReader("/Users/joehendricks/Dev/JavaAssessment3/src/main/resources/users.json"));
        User[] userArray = parser.fromJson(jReader, User[].class);

        for (User user : userArray){
            userCollection.add(user);
        }
        return userCollection;
    }
}
