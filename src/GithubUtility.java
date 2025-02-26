
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GithubUtility {

    String fetchGithubActivity(String username) throws URISyntaxException {
        System.out.printf("********* Fetching Recent Github Activity for \"%s\" *********", username);

        // Making http connection with github
        HttpClient httpClient = HttpClient.newHttpClient();
        URI uri = new URI(String.format("https://api.github.com/users/%s/events", username));
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();

        
        final ArrayList<EventEntity> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // sending request and getting response
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                Type requiredResponseType = new TypeToken<ArrayList<EventEntity>>(){}.getType(); 
                String jsonString = response.body();

                List<EventEntity> responseArray = gson.fromJson(jsonString, requiredResponseType);

                // Storing objects in Arraylist for processing
                for (EventEntity obj : responseArray) {
                    arrayList.add(obj);
                }
            } else {
                throw new InterruptedException();
            }

            // Processing data in Arraylist
            if(arrayList == null || arrayList.isEmpty()){
                sb.append("\n Incorrect Username or No recent activity found!");
            } else {
                HashMap<String, Integer> map = new HashMap<>();
                // storing events in map
                for (EventEntity eventEntity : arrayList) {
                    String key = eventEntity.getType() + "@" + eventEntity.getRepo().getName();
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                // pulling event counts from map and forming string
                for (String s : map.keySet()) {
                    String[] brokenKey = s.split("@");
                    sb.append("\n- " + brokenKey[0] + ": " + brokenKey[1] + " ---> "  + map.get(s) + " times");
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("########### Some internal error.");
        }

        return sb.toString();
    }

}
