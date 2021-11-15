package com.example.lab02_calculatorkashitsin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ATV;
    EditText BTV;
    EditText CTV;
    TextView ResultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ATV = findViewById(R.id.InputA);
        BTV = findViewById(R.id.InputB);
        CTV = findViewById(R.id.InputC);
        ResultTV = findViewById(R.id.InputV);
    }

    public void SelectOption (View v)
    {
        double a,b,c = 0;
        try {
            a = Double.parseDouble(ATV.getText().toString());
            b = Double.parseDouble(BTV.getText().toString());
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Данные введены неправильно", Toast.LENGTH_LONG).show();
            return;
        }
        switch (v.getId())
        {
            case R.id.AddBut: c = a+b; break;
            case R.id.SubBut: c = a-b; break;
            case R.id.MulBut: c = a*b;break;
            case R.id.DivBut:
                if (b != 0)
                    c = a/b;
                else
                    Toast.makeText(getApplicationContext(), "Деление на ноль недопустимо", Toast.LENGTH_LONG).show();break;
            case R.id.PowBut: c = Math.pow(a, b);break;
        }
        ResultTV.setText(String.valueOf(c));
    }

    public void SelectCustomOption (View v)
    {
        double a,c = 0;
        try {
            a = Double.parseDouble(CTV.getText().toString());
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Данные введены неправильно", Toast.LENGTH_LONG).show();
            return;
        }
        switch (v.getId())
        {
            case R.id.SinBut: c = Math.sin(a);break;
            case R.id.CosBut: c = Math.cos(a);break;
            case R.id.TanBut: c = Math.tan(a);break;
            case R.id.SqrtBut:
                if (a >= 0)
                    c = Math.sqrt(a);
                else
                    Toast.makeText(getApplicationContext(), "Значение меньше нуля недопустимо", Toast.LENGTH_LONG).show();break;
        }
        ResultTV.setText(String.valueOf(c));
    }
}