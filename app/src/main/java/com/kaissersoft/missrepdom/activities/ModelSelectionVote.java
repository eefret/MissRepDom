package com.kaissersoft.missrepdom.activities;

import java.util.Locale;

import android.content.res.TypedArray;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kaissersoft.missrepdom.R;
import com.kaissersoft.missrepdom.persistence.Contracts.ModelsContract;

public class ModelSelectionVote extends ActionBarActivity {
    private static final String TAG = "ModelSelectionVote";

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_selection_vote);

        Cursor cursor = getContentResolver().query(ModelsContract.CONTENT_URI,
                null,
                "",
                null,
                "");

        Log.d(TAG, cursor.getCount()+"");
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),cursor);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.model_selection_vote, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private Cursor mCursor;

        public SectionsPagerAdapter(FragmentManager fm, Cursor cursor) {
            super(fm);
            mCursor = cursor;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Log.d(TAG,"getItem pos: "+position);
            mCursor.moveToPosition(position);
            return new PlaceholderFragment(mCursor.getInt(mCursor.getColumnIndex(ModelsContract.MODEL_NUMBER)));
        }

        @Override
        public int getCount() {
            return mCursor.getCount();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            mCursor.moveToPosition(position);
            return mCursor.getString(mCursor.getColumnIndex(ModelsContract.MODEL_NAME));
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        int mModelId;

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment(int modelId) {
            mModelId = modelId;
            Log.d(TAG,"Fragment Created: "+ modelId);
        }

        public PlaceholderFragment(){

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_model_selection_vote, container, false);
            Button btn = (Button) rootView.findViewById(R.id.btn_model_vote_selection);
            ImageView iv = (ImageView) rootView.findViewById(R.id.iv_model_profile_vote);

            TypedArray ta = getActivity().getResources().obtainTypedArray(R.array.profile_pics_models);

            iv.setImageDrawable(ta.getDrawable(mModelId));
            btn.setTag(String.valueOf(mModelId));

            return rootView;
        }
    }

}
