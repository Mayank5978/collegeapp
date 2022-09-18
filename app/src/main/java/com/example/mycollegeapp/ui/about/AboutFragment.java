package com.example.mycollegeapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mycollegeapp.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_computer,"Computer science","Computer Science and Engineering started in year 2015.At present intake sheet in 1-year is 30 student, and in lateral entry is 6."));
        list.add(new CourseModel(R.drawable.ic_mech,"Mechanical Production","Mechniacl Engineering(Production) started in year 2013.At present intake sheet in 1-year is 30 student, and in lateral entry is 6."));

        adapter = new CourseAdapter(getContext(),list);
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/my-college-app-8ceeb.appspot.com/o/gallery%2F%5BB%404125977jpg?alt=media&token=3e82d160-4fd7-4a99-9040-6652a9bd9d90").into(imageView);
        return view;
    }


}