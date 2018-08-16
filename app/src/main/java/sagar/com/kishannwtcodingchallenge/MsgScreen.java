package sagar.com.kishannwtcodingchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class MsgScreen extends AppCompatActivity {
    private FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mdatabaseReference;

    private TextView textViewotp;
    private Calendar mcalendar;
    private SimpleDateFormat msimpleDateFormat;
    private String total,otp;
    public static String date;


    // here you can enter Your Twilio ACCOUNT_SID and AUTH_TOKEN
    public static final String ACCOUNT_SID = "Enter Your ACCOUNT_SID";
    public static final String AUTH_TOKEN = "ENTER Your AUTH_TOKEN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_screen);
        textViewotp = (TextView) findViewById(R.id.textmsg);
       // msgid = (TextView) findViewById(R.id.msgid);

        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mdatabaseReference = FirebaseDatabase.getInstance().getReference();


        mcalendar = Calendar.getInstance();

        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(mtoolbar);

        // receiving the random number using getExtra() and Set the
        // OTP into TextView
            otp =getIntent().getExtras().getString("randomOTP");
            total = "hii this is your OTP:"+otp;
            textViewotp.setText(total);


    }

    public void MessageSending(View view) {
       String getnum = getIntent().getExtras().getString("msgNum");
        Log.e("msg>>>>>>>",getnum);
        String body = textViewotp.getText().toString();
        String from = "+15312331353";
//        //String[] to = new String[]{"+919905359295","+917541092530",""}; //getnum
//        String mid = null;
//        for(int i =0;i<to.length;i++)
//
//        {
//             mid = to[i];
//
//        }



        String base64EncodedCredentials = "Basic " + Base64.encodeToString(
                (ACCOUNT_SID + ":" + AUTH_TOKEN).getBytes(), Base64.NO_WRAP
        );

        Map<String, String> data = new HashMap<>();
        data.put("From", from);
        data.put("To", getnum);
        data.put("Body", body);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.twilio.com/2010-04-01/")
                .build();
        TwilioApi api = retrofit.create(TwilioApi.class);

        api.sendMessage(ACCOUNT_SID, base64EncodedCredentials, data).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    UploadDataIntoFirebase();
                    Log.d("TAG", "onResponse->success");

                    Log.e("date is :>>>>",date);
                    Toast.makeText(MsgScreen.this, "Message Sent", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MsgScreen.this, "Message Sent failed", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", "onResponse->failure");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure");
            }
        });
    }

    interface TwilioApi {
        @FormUrlEncoded
        @POST("Accounts/{ACCOUNT_SID}/SMS/Messages")
        Call<ResponseBody> sendMessage(
                @Path("ACCOUNT_SID") String accountSId,
                @Header("Authorization") String signature,
                @FieldMap Map<String, String> metadata
        );
    }



    // uploading data into Firebase
    public void UploadDataIntoFirebase()
    {
        String name = Details.naame;
        msimpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        date = msimpleDateFormat.format(mcalendar.getTime());

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference =firebaseDatabase.getReference("Contact_Info").push();

        databaseReference.child("date").setValue(date);
        databaseReference.child("name").setValue(name);
        Log.e("Name is Uplaoding",name);
        databaseReference.child("otp").setValue(otp);
        Toast.makeText(this, ""+date, Toast.LENGTH_SHORT).show();
        //databaseReference.child("")

    }
}

