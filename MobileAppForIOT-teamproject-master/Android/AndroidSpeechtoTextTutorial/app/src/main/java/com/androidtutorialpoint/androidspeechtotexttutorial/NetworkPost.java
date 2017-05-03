package com.androidtutorialpoint.androidspeechtotexttutorial;

/**
 * Created by Adi on 4/28/17.
 */

import java.net.*;
import java.io.*;
import org.json.*;

public class NetworkPost implements Runnable{

    private String text;
    private String emotion = "";

    public NetworkPost (String input_text) {
        text = input_text;
    }

    public void run () {
        String output = "";
        try {

            URL url = new URL("https://whispering-peak-14834.herokuapp.com/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setInstanceFollowRedirects(true);
            String input = "";
            try {
                input = new JSONObject().put("text", this.text).toString();
                //String input = "{\"text\":\"I am Sad\"}";
            }
            catch (JSONException e) {
                e.printStackTrace();
            }

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                try {
                    JSONObject jsonObject = new JSONObject(output);
                    this.emotion = jsonObject.getString("emotion");
                    System.out.println(this.emotion);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done");
            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return;
    }

    public String get_emotion() {
        return this.emotion;
    }

}
