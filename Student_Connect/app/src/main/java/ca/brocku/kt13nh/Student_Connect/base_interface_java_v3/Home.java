package ca.brocku.kt13nh.Student_Connect.base_interface_java_v3;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import ca.brocku.kt13nh.Student_Connect.R;
/*
* Class designed for the home page, this will be the main screen for the tab selections, and the
* content within those tabs.
* */
public class
Home extends Fragment {

    /*
    * create view and inflate the tablayouts with the tabs
    * */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.activity_main,container,false);

        Toolbar toolbar = (Toolbar)v.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout)v.findViewById(R.id.tab_layout);

        inflateTabs(v,tabLayout);

        //placeholder to use the floating action button
        //initFloatingActionButton();
        return v;
    }


//Placeholder for the action button, ensure it works based on tab selected

//    public void initFloatingActionButton() {
//        FloatingActionButton fab = (FloatingActionButton)this.getView().findViewById(R.id.addButton);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent newMeeting = new Intent(Home.this.getActivity(),NewMeeting.class);
//                startActivity(newMeeting);
//            }
//        });
//    }

    /*
    * Create the tabs for the tab layout, and setting their titles
    * */
    public void inflateTabs(View view, TabLayout tabLayout){
        //create new pager to use for the tabs
        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.pager);
        //settings the titles of the tabs
        tabLayout.addTab(tabLayout.newTab().setText("Inbox"));
        tabLayout.addTab(tabLayout.newTab().setText("Q/A"));
        tabLayout.addTab(tabLayout.newTab().setText("Events"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final PagerAdapter adapter = new PagerAdapter
                (getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tab listener
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}