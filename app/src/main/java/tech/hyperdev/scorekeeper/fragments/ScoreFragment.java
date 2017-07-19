package tech.hyperdev.scorekeeper.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {
    private ImageButton mBtnPlus;
    private ImageButton mBtnMinus;
    private int score;
    private String teamname;
    private TextView mTvScore;
    private TextView mTvTeamName;

    public ScoreFragment() {
        this.score = 0;
        this.teamname = "";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        if (savedInstanceState != null) {
            score = savedInstanceState.getInt("score");
            teamname = savedInstanceState.getString("teamname");
        }

        mBtnPlus = (ImageButton) view.findViewById(R.id.btnPlus);
        mBtnMinus = (ImageButton) view.findViewById(R.id.btnMinus);
        mTvScore = (TextView) view.findViewById(R.id.tvScore);
        mTvTeamName = (TextView) view.findViewById(R.id.tvTeamName);


        mTvScore.setText(score+"");
        mTvTeamName.setText(this.teamname);

        mBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                mTvScore.setText(score+"");
            }
        });

        mBtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score == 0){
                    mTvScore.setText(score+"");
                }else{
                    score--;
                    mTvScore.setText(score+"");
                }

            }
        });

        return view;
    }

    public void setTeamName(String name){
        this.teamname = name;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putInt("score", score);
        outState.putString("teamname", teamname);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
