package com.kaissersoft.missrepdom.activities.fragments;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kaissersoft.missrepdom.R;
import com.kaissersoft.missrepdom.activities.ModelSelectionVote;
import com.kaissersoft.missrepdom.persistence.Contracts.ModelsContract;
import com.kaissersoft.missrepdom.persistence.Contracts.UserPreferencesContract;

/**
 * Created by Eefret on 5/4/2014.
 */
public class VoteFragment extends Fragment {

    private boolean userHasVoted;
    private int modelVoted;
    private Button mBtnVote;
    private TextView mTvVote;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Cursor cursor = getActivity().getContentResolver().query(UserPreferencesContract.CONTENT_URI,
                new String[]{UserPreferencesContract.HAS_VOTED,UserPreferencesContract.MODEL_VOTED},
                null,
                null,
                null);

        cursor.moveToFirst();

        this.userHasVoted = (cursor.getInt(0) != 0);
        if (this.userHasVoted){
            this.modelVoted = cursor.getInt(1);
        }

        cursor.close();

        View view = inflater.inflate(R.layout.fragment_vote,null);
        mBtnVote = (Button) view.findViewById(R.id.btn_vote);
        mTvVote = (TextView) view.findViewById(R.id.tv_vote);

        if (userHasVoted){
            mBtnVote.setClickable(false);
            Cursor cursorBoolean = getActivity().getContentResolver().query(ModelsContract.CONTENT_URI,
                    new String[]{ModelsContract.MODEL_NAME},
                    ModelsContract.MODEL_NUMBER+" = ?",
                    new String[]{String.valueOf(modelVoted)},
                    null
            );
            mTvVote.setText(getString(R.string.has_voted_text)+" "+ cursorBoolean.getString(0));
            cursorBoolean.close();
        }



        mBtnVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ModelSelectionVote.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
