package uz.gita.quizeappmvpmehriddins.ui.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;


import uz.gita.quizeappmvpmehriddins.R;
import uz.gita.quizeappmvpmehriddins.model.TestData;
import uz.gita.quizeappmvpmehriddins.ui.choose.ChooseActivity;
import uz.gita.quizeappmvpmehriddins.ui.result.ResultActivity;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity implements GameContract.View {
    private List<RadioButton> radios;
    private TextView question;
    private AppCompatImageView btnBack;
    private TextView title;
    private AppCompatButton buttonSkip;
    private AppCompatButton buttonNext;
    private TextView solve;

    private GamePresenter presenter;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        clickEvents();
        presenter = new GamePresenter(this);
    }

    private void findViews() {
        question = findViewById(R.id.textQuestion);
        progressBar = findViewById(R.id.progressBar);

        buttonSkip = findViewById(R.id.buttonSkip);
        buttonNext = findViewById(R.id.buttonNext);

        radios = new ArrayList<>(4);
        RadioButton radio1 = findViewById(R.id.radio1);
        RadioButton radio2 = findViewById(R.id.radio2);
        RadioButton radio3 = findViewById(R.id.radio3);
        RadioButton radio4 = findViewById(R.id.radio4);
        radio1.setTag(0);
        radio2.setTag(1);
        radio3.setTag(2);
        radio4.setTag(3);
        radios.add(radio1);
        radios.add(radio2);
        radios.add(radio3);
        radios.add(radio4);

        solve = findViewById(R.id.textSolve);
        title = findViewById(R.id.txtTitle);
        btnBack = findViewById(R.id.btnHome);
    }

    private void clickEvents() {
        buttonNext.setOnClickListener(v -> {
            presenter.clickNextBtn();
        });

        buttonSkip.setOnClickListener(v -> {
            presenter.clickSkipBtn();
        });

        btnBack.setOnClickListener(v -> {
            presenter.clickBackBtn();
        });

        for (RadioButton radio : radios) {
            int pos = (int) radio.getTag();
            Log.d("TTT", "ansAnonimdanTashaqari = " + pos);
            radio.setOnClickListener(v -> {
                Log.d("TTT", "ans = " + pos);
                presenter.clickRadio(pos);
            });
        }
    }

    public void setProgressBar(int currentPos) {
        progressBar.setProgress(currentPos);
        progressBar.setMax(10);
    }

    @Override
    public void describeTest(TestData test, int currPos) {
        solve.setText(currPos + "");

        question.setText(test.getQuestion());

        radios.get(0).setText(test.getVariant1());
        radios.get(1).setText(test.getVariant2());
        radios.get(2).setText(test.getVariant3());
        radios.get(3).setText(test.getVariant4());
    }

    @Override
    public void stateNextBtn(boolean bool) {
        buttonNext.setEnabled(bool);
    }

    @Override
    public void stateSkipBtn(int visibility) {
        buttonSkip.setVisibility(visibility);

    }

    @Override
    public void openChooseActivity() {
        Intent i = new Intent(this, ChooseActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void openResultActivity() {
        Intent i = new Intent(this, ResultActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void clearOldBackground() {
        for (RadioButton radio : radios) {
            radio.setBackgroundResource(R.drawable.bg_unchecked);
        }
    }

    @Override
    public void setAllCheckedState(boolean bool) {
        for (RadioButton radio : radios) {
            radio.setChecked(bool);
        }
    }

    @Override
    public void setAllEnabletState(boolean bool) {
        for (RadioButton radio : radios) {
            radio.setEnabled(bool);
        }
    }

    @Override
    public void setGreenBackgroundToTrueRadio(int pos) {
        radios.get(pos).setBackgroundResource(R.drawable.bg_true_ans);
    }

    @Override
    public void setRedBackgroundToClickedRadio(int pos) {
        radios.get(pos).setBackgroundResource(R.drawable.bg_wrong_ans);
    }

    @Override
    public void onBackPressed() {
        presenter.clickOnBackPressed();
    }
}