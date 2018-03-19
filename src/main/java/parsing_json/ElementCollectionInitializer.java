package parsing_json;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;


public class ElementCollectionInitializer {

        public static ElementCollection generate() throws IOException {
            ElementCollection elementCollection = new ElementCollection();

            Gson parser = new Gson();
            JsonReader jReader = new JsonReader(new FileReader("/Users/joehendricks/Dev/JavaAssessment3/src/main/resources/periodic_table.json"));
            Element[] elementArray = parser.fromJson(jReader, Element[].class);

            for (Element element : elementArray){
                elementCollection.add(element);
            }

        return elementCollection;
    }
}

