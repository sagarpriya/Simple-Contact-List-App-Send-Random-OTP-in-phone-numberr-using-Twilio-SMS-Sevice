package sagar.com.kishannwtcodingchallenge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mtabs;
    public PagerAdapter(FragmentManager fragmentManager , int mtabs)
    {
        super(fragmentManager);
        this.mtabs = mtabs;
    }
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                FirstTabFragment firstTabFragment  = new FirstTabFragment();
                return  firstTabFragment;
            case 1:
                SecondTabFragment secondTabFragment = new SecondTabFragment();
                return secondTabFragment;
                default:
                return null;
    }
    }

    @Override
    public int getCount() {
        return mtabs;
    }
}
