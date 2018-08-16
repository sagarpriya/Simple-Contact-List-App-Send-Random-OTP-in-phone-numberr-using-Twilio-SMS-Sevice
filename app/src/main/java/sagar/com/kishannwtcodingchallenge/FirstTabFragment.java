package sagar.com.kishannwtcodingchallenge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FirstTabFragment extends Fragment {

    private ProgressBar mproressbar;
    private ListView mlistview;
    private List<String> mcontactList;
    //private ArrayList mcontactList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_first_tab, container, false);
        mproressbar = (ProgressBar)  v.findViewById(R.id.progressBar);

        mlistview = (ListView) v.findViewById(R.id.listView);

        // creating reference object of inner class and passing the JSON URL
        getAllDataFetch mgetallDataFetch = new getAllDataFetch();
        // Enter Your JSON URL
        mgetallDataFetch.execute("https://api.myjson.com/bins/192nzw");

        //clicking on Listview
        mlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //HashMap hm = (HashMap) mcontactList.get(position);
                String name =(String) mlistview.getItemAtPosition(position);
                //String p = String.valueOf(position);
                // Transfer the name using Intent
                Intent intent = new Intent(getActivity(),Details.class);
                intent.putExtra("naame",name);
                intent.putExtra("pos",position);
                startActivity(intent);

            }
        });
        return v;
    }

    public void ContactAdapter(String json){
        mcontactList = JsonParse.Parse(json);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,mcontactList);
        mlistview.setAdapter(adapter);
    }


    // Inner class
    private class getAllDataFetch extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... strings) {

            String data = null;
            try {
                data = Httpmanager.getdata(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPreExecute() {
            mproressbar.setVisibility(View.VISIBLE);

        }

        @Override
        protected void onPostExecute(String s) {
            ContactAdapter(s);
            mproressbar.setVisibility(View.INVISIBLE);

        }
    }
}
