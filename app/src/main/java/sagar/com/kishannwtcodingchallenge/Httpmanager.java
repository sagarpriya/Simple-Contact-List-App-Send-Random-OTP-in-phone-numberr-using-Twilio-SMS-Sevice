package sagar.com.kishannwtcodingchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Httpmanager {

    public static String getdata(String stringUrl) throws IOException {
        BufferedReader bf = null;
        try {
            URL url = new URL(stringUrl);
            HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
            StringBuilder stringBuilder = new StringBuilder();

            InputStreamReader isr = new InputStreamReader(httpURLConnection.getInputStream());
            bf = new BufferedReader(isr);

            String line;
            while((line = bf.readLine()) !=null)
            {
                stringBuilder.append(line).append("\n");

            }
            return stringBuilder.toString();
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally {
            try {
                bf.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
