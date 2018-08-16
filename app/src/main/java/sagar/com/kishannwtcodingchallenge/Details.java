package sagar.com.kishannwtcodingchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Details extends AppCompatActivity {

    private TextView mtextview, textView2;

    public static String num;
    public static String naame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mtoolbar);
        // contactList = new ArrayList<>();

        mtextview = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        //storing all data in string varible
        naame = getIntent().getExtras().getString("naame");
        mtextview.setText(naame);
        int id =getIntent().getExtras().getInt("pos");
        Log.e("id",""+id);
        for (int i = 0; i < JsonParse.number.size(); i++) {
                HashSet hashSet = new HashSet(JsonParse.number);
                List list1 = new ArrayList(hashSet);
                num = (String) list1.get(i);
                if (id == i) {
                    String a = (String) list1.get(id);
                    Log.e("number", num);
                    textView2.setText(a);
                }
        }


        }



// when snedingBUtton is CLicked
    public void SendingMessage(View view) {

        int len = 6;
        String key = String.valueOf(OTP(len));
// Passing the random OTP i use Intent
        Intent intent = new Intent(Details.this, MsgScreen.class);
        intent.putExtra("randomOTP",key);
        intent.putExtra("msgNum",num);
        startActivity(intent);

        Toast.makeText(this, "Sending Message is clicked", Toast.LENGTH_SHORT).show();
    }

    // generating RANDOM OTP
    public char[] OTP(int len) {
        System.out.println("Generating OTP using random() : ");
        System.out.print("You OTP is : ");

        // Using numeric values
        String numbers = "0123456789";

        // Using random method
        Random rndm_method = new Random();

        char[] otp = new char[len];

        for (int i = 0; i < len; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
    }
}
