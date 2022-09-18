package com.example.mycollegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mycollegeapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ImageView map;
    private ImageSlider imageSlider;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider=view.findViewById(R.id.image_slider);

        ArrayList<SlideModel> sliderModels = new ArrayList<>();

        sliderModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/my-college-app-8ceeb.appspot.com/o/gallery%2F%5BB%40ba291fejpg?alt=media&token=83a95ca0-3baf-48fb-b88d-9b471d47491d", ScaleTypes.FIT));
        sliderModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/my-college-app-8ceeb.appspot.com/o/gallery%2F%5BB%40da7c59ajpg?alt=media&token=28b998f3-9758-415f-b913-50174de8c8fe", ScaleTypes.FIT));
        sliderModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/my-college-app-8ceeb.appspot.com/o/gallery%2F%5BB%40ef1c8a3jpg?alt=media&token=e94eec6f-020f-4c11-9b06-d34751cfa3b5\n", ScaleTypes.FIT));
        sliderModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/my-college-app-8ceeb.appspot.com/o/gallery%2F%5BB%40b350477jpg?alt=media&token=c4df82c6-278f-4b80-a76f-a39a332991ed", ScaleTypes.FIT));


        imageSlider.setImageList(sliderModels,ScaleTypes.FIT);





        map =view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });



      return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0?q=Aligarh College Of Engineering And Technology Aligarh");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}