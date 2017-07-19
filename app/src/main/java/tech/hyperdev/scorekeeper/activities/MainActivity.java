package tech.hyperdev.scorekeeper.activities;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;
    private ScoreFragment scoreFragmentOne;
    private ScoreFragment scoreFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            scoreFragmentOne = new ScoreFragment();
            scoreFragmentTwo = new ScoreFragment();

            scoreFragmentOne.setTeamName("Team 1");
            scoreFragmentTwo.setTeamName("Team 2");

            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.teamOneFragment, scoreFragmentOne);
            mFragmentTransaction.replace(R.id.teamTwoFragment, scoreFragmentTwo);
            mFragmentTransaction.commit();
        }
    }

}
