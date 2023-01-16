package com.example.converter.bogatova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etFrom;
    TextView tvTo;
    Spinner spFrom;
    Spinner spTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFrom = findViewById(R.id.plainTextFrom );
        tvTo = findViewById(R.id.plainTextTo );
        spFrom = findViewById(R.id.spFrom);
        spTo = findViewById(R.id.spTo);

        ArrayAdapter <String> adp = new <String> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        adp.add("mm");
        adp.add("cm");
        adp.add("m");
        adp.add("km");

        spFrom.setAdapter (adp);
        spTo.setAdapter(adp);
    }

    public void on_click(View v) {
    try {
    float from = Float.parseFloat(etFrom.getText().toString());
    String sFrom = (String) spFrom.getSelectedItem();
    String sTo = (String) spTo.getSelectedItem();
    float to = 0.0f;
    float m = 0.0f;

    if (sFrom.equals("km")) m = from * 1000.0f;
    if (sFrom.equals("mm")) m = from / 1000.0f;
    if (sFrom.equals("cm")) m = from / 100.0f;
    if (sFrom.equals("m")) m = from / 1.0f;

    if (sTo.equals("mm")) to = m * 1000.0f;
    if (sTo.equals("cm")) to = m * 100.0f;
    if (sTo.equals("m")) to = m * 1.0f;
    if (sTo.equals("km")) to = m / 1000.0f;
    tvTo.setText(String. valueOf(to));
    }
    catch (Exception e)
    {
        Toast tst = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
        tst.show();
        return;
    }
}



    }


