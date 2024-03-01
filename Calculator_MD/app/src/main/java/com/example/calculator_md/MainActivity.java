package com.example.calculator_md;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1, editTextN2;
    TextView textView;
    float num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }

    public float getFloatFromEditText(EditText editText) {
        String text = editText.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
            return 0.0f;
        } else {
            return Float.parseFloat(text);
        }
    }

    @Override
    public void onClick(View view) {
        num1 = getFloatFromEditText(editTextN1);
        num2 = getFloatFromEditText(editTextN2);
        float result;
        if (view.getId() == R.id.btn_add) {
            result = num1 + num2;
        } else if (view.getId() == R.id.btn_sub) {
            result = num1 - num2;
        } else if (view.getId() == R.id.btn_mul) {
            result = num1 * num2;
        } else if (view.getId() == R.id.btn_div) {
            if (num2 == 0.0f) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                return;
            }
            result = num1 / num2;
        } else {
            return;
        }
        textView.setText("Answer = " + result);
    }
}
