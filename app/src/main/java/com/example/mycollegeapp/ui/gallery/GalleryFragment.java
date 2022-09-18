package com.example.mycollegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycollegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView convacRecycler,otherRecycler;
    GalleryAdapter adapter,adapter1;

    DatabaseReference otherRef,convoRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        convacRecycler = view.findViewById(R.id.convacRecyler);
        otherRecycler = view.findViewById(R.id.otherRecyler);
        otherRef = FirebaseDatabase.getInstance().getReference().child("gallery").child("Other Events");
        convoRef = FirebaseDatabase.getInstance().getReference().child("gallery").child("Convocation");
        getConvoImage();
        getOtherImage();

        return view;
    }
    private void getOtherImage() {
        otherRef.addValueEventListener(new ValueEventListener() {

            List<String> imageList  = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot:datasnapshot.getChildren()){

                    String data = (String) snapshot.getValue();
                    imageList.add(data);

                }
                adapter = new GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3 ));
                otherRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getConvoImage() {
        convoRef.addValueEventListener(new ValueEventListener() {

            List<String> imageList  = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot:datasnapshot.getChildren() ){

                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter1 = new GalleryAdapter(getContext(),imageList);
                convacRecycler.setLayoutManager(new GridLayoutManager(getContext(),3 ));
                convacRecycler.setAdapter(adapter1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}