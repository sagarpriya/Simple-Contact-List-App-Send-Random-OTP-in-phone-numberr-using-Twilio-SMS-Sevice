package sagar.com.kishannwtcodingchallenge;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SecondTabFragment extends Fragment {


    FirebaseRecyclerAdapter<ModelClass,ViewHolder> firebaseRecyclerAdapter;

    private FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mdatabaseReference;
    private RecyclerView mrecyclerView;
   // private List<ModelClass> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_second_tab, container, false);

        mrecyclerView =(RecyclerView) v.findViewById(R.id.secondtablist);

        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mrecyclerView.setHasFixedSize(true);

        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mdatabaseReference = FirebaseDatabase.getInstance().getReference("Contact_Info");
        mdatabaseReference.keepSynced(true);

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<ModelClass, ViewHolder>
                (ModelClass.class,R.layout.my_list_style,ViewHolder.class,mdatabaseReference) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, ModelClass model, int position) {

                viewHolder.setName(model.getName());
                viewHolder.setDate(model.getDate());
                viewHolder.setOtp(model.getOtp());


            }
        };
        mrecyclerView.setAdapter(firebaseRecyclerAdapter);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),R.layout.my_st,marrayList);
        //mlistView.setAdapter(arrayAdapter);


      //  mdatabaseReference= FirebaseDatabase.getInstance().getReference().child("Contact_Info");
//
//        mdatabaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                list.clear();
//                    for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
//                        ModelClass value = dataSnapshot1.getValue(ModelClass.class);
//                        ModelClass model = new ModelClass();
//                        String ndate = value.getDate();
//                        Log.e("date>>>", ndate);
//                        String nname = value.getName();
//                        Log.e("name>>>>", nname);
//                        String notp = value.getOtp();
//                        Log.e("otp>>>>", notp);
//
//                        model.setDate(ndate);
//                        model.setName(nname);
//                        model.setOtp(notp);
//                        list.add(value);
//                        Log.e("dataseposot", "" + list);
//                        Log.d("indie data", "" + list);
//
//
//              }
//
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        listAdapter mlistAdapter = new listAdapter(getActivity(),list);
//        mlistAdapter.notifyDataSetChanged();
//
//        Log.d("data receivied",""+list);
//        mrecyclerView.setAdapter(mlistAdapter);
//
//        return v    ;


        return v;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        View  mview;

        public ViewHolder(View itemView) {
            super(itemView);
            mview=itemView;
        }

        public void setName(String name)
        {
            TextView txtnamme = mview.findViewById(R.id.tv1);
            txtnamme.setText(name);
        }
        public void setDate(String date)
        {
            TextView txtdate = mview.findViewById(R.id.tv2);
            txtdate.setText(date);
        }
        public void setOtp(String otp)
        {
            TextView txtotp = mview.findViewById(R.id.tv3);
            txtotp.setText(otp);
        }
    }

}
