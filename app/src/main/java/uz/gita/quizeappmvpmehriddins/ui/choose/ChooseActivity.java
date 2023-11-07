package uz.gita.quizeappmvpmehriddins.ui.choose;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;


import uz.gita.quizeappmvpmehriddins.R;
import uz.gita.quizeappmvpmehriddins.ui.info.InfoActivity;
import uz.gita.quizeappmvpmehriddins.ui.game.GameActivity;

public class ChooseActivity extends AppCompatActivity implements ChooseContract.View {

    ChooseContract.Presenter presenter;
    CardView onaTili;
    CardView Tarix;
    CardView Math;
    AppCompatImageView info;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_choose);
        findView();
        clickEvents();

        presenter = new ChoosePresenter(this);
        getWindow().setFlags((WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS), WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }

    private void findView() {
        onaTili = findViewById(R.id.btnOnaTili);
        Tarix = findViewById(R.id.btnTarix);
        Math = findViewById(R.id.btnMath);
        info = findViewById(R.id.btnInfo);
    }

    private void clickEvents() {
        onaTili.setOnClickListener(v -> {
            presenter.clickOnaTiliBtn();
        });

        Tarix.setOnClickListener(v -> {
            presenter.clicktarxBtn();
        });

        Math.setOnClickListener(v -> {
            presenter.clickMatemBtn();
        });

        info.setOnClickListener(v -> {
            presenter.clickInfoBtn();
        });
    }

    @Override
    public void startGameActivity() {
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void startInfoActivity() {
        Intent i = new Intent(this, InfoActivity.class);
        startActivity(i);
    }
}
