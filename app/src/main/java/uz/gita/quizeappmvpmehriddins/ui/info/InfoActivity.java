package uz.gita.quizeappmvpmehriddins.ui.info;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import uz.gita.quizeappmvpmehriddins.R;
import uz.gita.quizeappmvpmehriddins.ui.choose.ChooseActivity;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);



        findViewById(R.id.back).setOnClickListener(v -> {
            Intent i = new Intent(this, ChooseActivity.class);
            startActivity(i);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}