package uz.gita.quizeappmvpmehriddins.ui.result;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import uz.gita.quizeappmvpmehriddins.R;
import uz.gita.quizeappmvpmehriddins.ui.choose.ChooseActivity;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity implements ResultContract.View {
    private PieChart pieChart;
    private AppCompatButton btnMenu;
    private AppCompatButton btnRecord;
    private float correct = 0;
    private float wrong = 0;
    private float skipped = 0;
    private AlertDialog dialog;
    private AppCompatButton btnBack;
    private View view;

    ResultPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        correct = i.getIntExtra("correct", 0);
        wrong = i.getIntExtra("wrong", 0);
        skipped = i.getIntExtra("skipped", 0);

        presenter = new ResultPresenter(this);

        findView();
        clickEvent();
        loadPieChart();
        setUpPieChart();

       }

    private void findView() {
        pieChart = findViewById(R.id.pie_chart);
        btnMenu = findViewById(R.id.btnMenuR);
        btnRecord = findViewById(R.id.btnRecord);
    }

    private void clickEvent() {
        btnMenu.setOnClickListener(v -> {
            presenter.clickBtnMenu();
        });

        btnRecord.setOnClickListener(v -> {
            presenter.clickBtnRecord();
        });
    }

    private void setUpPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(false);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("Natija");
        pieChart.setCenterTextSize(22);
        pieChart.setEntryLabelTextSize(14);
        pieChart.getDescription().setEnabled(false);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }

    private void loadPieChart() {
        ArrayList<PieEntry> entries = new ArrayList<>();

        ArrayList<Integer> colors = new ArrayList<>();

        if (correct != 0) {
            entries.add(new PieEntry((float) correct, "To'g'ri"));
            colors.add(Color.GREEN);
        }
        if (wrong != 0) {
            entries.add(new PieEntry((float) wrong, "Xato"));
            colors.add(Color.RED);
        }
        if (skipped != 0) {
            entries.add(new PieEntry((float) skipped, "Ishlanmagan"));
            colors.add(Color.YELLOW);
        }


        PieDataSet dataSet = new PieDataSet(entries, "Kategoriyalar");
        dataSet.setColors(colors);
        dataSet.setFormSize(20);
        dataSet.setForm(Legend.LegendForm.SQUARE);
        dataSet.setValueTextSize(14);
        dataSet.setFormLineWidth(40);
        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(18f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, ChooseActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void describeCorrectCount(int correct, int wrong, int skipped) {
        this.correct = (float) correct;
        this.wrong = (float) wrong;
        this.skipped = (float) skipped;
    }

    @Override
    public void openChooseActivity() {
        Intent i = new Intent(this, ChooseActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void showDialog() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setView(view);
        dialog.setCancelable(true);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(null);
        dialog.setCancelable(false);

        btnBack.setOnClickListener(v -> {
            dialog.dismiss();
        });

    }

    @Override
    public void setDialog(int[] arr) {
        view = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        btnBack = view.findViewById(R.id.btnQaytish);

        TextView tarix = view.findViewById(R.id.recTarix);
        TextView onaTili = view.findViewById(R.id.recOnaTili);
        TextView Math = view.findViewById(R.id.recMath);

        tarix.setText(arr[0]+"");
        onaTili.setText(arr[1]+"");
        Math.setText(arr[2]+"");

        for (int i = 0; i < 3; i++) {
            Log.d("OOO","for = " + arr[i]);
        }
    }
}