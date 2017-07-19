package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
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
    private int score = 0;
    private String teamname = "";
    private TextView mTvScore;
    private TextView mTvTeamName;

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        mBtnPlus = (ImageButton) view.findViewById(R.id.btnPlus);
        mBtnMinus = (ImageButton) view.findViewById(R.id.btnMinus);
        mTvScore = (TextView) view.findViewById(R.id.tvScore);
        mTvTeamName = (TextView) view.findViewById(R.id.tvTeamName);

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
        mTvTeamName.setText(this.teamname);
        return view;
    }

    public void setTeamName(String name){
        this.teamname = name;
    }

}
