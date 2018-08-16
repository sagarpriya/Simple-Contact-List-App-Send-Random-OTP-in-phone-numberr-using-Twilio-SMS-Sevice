package sagar.com.kishannwtcodingchallenge;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    
   private ViewPager mviewpager;

//    private ProgressBar mproressbar;
//    private ListView mlistview;
//    private List<String> mcontactList;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        // using Tablayout to swap 1st tab to 2nd tab
        TabLayout mtablayout = (TabLayout) findViewById(R.id.tablayout);
        mtablayout.addTab(mtablayout.newTab().setText("Contact List"));
        mtablayout.addTab(mtablayout.newTab().setText("Message Sent"));
        mtablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Using Viewpager to slide between two fragments
        mviewpager = (ViewPager) findViewById(R.id.viewpager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),mtablayout.getTabCount());
        mviewpager.setAdapter(pagerAdapter);
        mviewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtablayout));


        mtablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mviewpager.setCurrentItem(tab.getPosition());
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
