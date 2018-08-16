package sagar.com.kishannwtcodingchallenge;

import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class JsonParse {

    //inside this JSON Parsing and handle with try catch block

    public static List number = new ArrayList();

   // static String keys[] = {"k1","k2","k3"};

    public static List Parse(String json){

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("Contact");
            List contactList = new ArrayList<>();

            for(int i =0;i<jsonArray.length();i++)
            {
                JSONObject jb = jsonArray.getJSONObject(i);
                contactList.add(jb.getString("name"));
               // String mobilem = jb.getString("mobile");

                number.add(jb.getString("mobile"));
//                HashMap hm = new HashMap();
//               // hm.put(keys[0],namen);
//                hm.put(keys[1],mobilem);
//                //contactList.add(hm);
                Log.e("number>>>>",""+number);
            }


//
// int i = 0;
//            while (i < jsonArray.length()){
//                JSONObject jb = jsonArray.getJSONObject(i);
//
//                contactList.add(jb.getString("name"));
//                //number.add(jb.getString("mobile"));
//                String mobilen = jb.getString("mobile");
//                Log.e("String Value", String.valueOf(number));
//                i++;
//            }

            return contactList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }


}
