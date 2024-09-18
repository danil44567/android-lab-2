package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textResult, textDigit ;
    EditText inputFirst, inputSecond;
    Button sumBtn, minusBtn, multiplyBtn, devisionBtn, clearBtn;

    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textResult = findViewById(R.id.textResult);
        textDigit = findViewById(R.id.textDigit);

        inputFirst = findViewById(R.id.inputFirst);
        inputSecond = findViewById(R.id.inputSecond);

        sumBtn = findViewById(R.id.sumBtn);
        minusBtn = findViewById(R.id.minusBtn);
        devisionBtn = findViewById(R.id.devisionBtn);
        multiplyBtn = findViewById(R.id.multiplyBtn);
        clearBtn = findViewById(R.id.clearBtn);

        sumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "+";
                updateOperationSymbol();
                calculateResult();
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "-";
                updateOperationSymbol();
                calculateResult();
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "*";
                updateOperationSymbol();
                calculateResult();
            }
        });

        devisionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = "/";
                updateOperationSymbol();
                calculateResult();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputFirst.setText("");
                inputSecond.setText("");
                textResult.setText("");
                operation = "";
                updateOperationSymbol();
            }
        });
    }

    private void updateOperationSymbol() {
        textDigit.setText(operation);
    }

    private void calculateResult() {
        try {
            double firstNumber = Double.parseDouble(inputFirst.getText().toString());
            double secondNumber = Double.parseDouble(inputSecond.getText().toString());

            double result = 0;
            switch (operation) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber == 0) {
                        textResult.setText("Дел 0");
                        return;
                    }
                    result = firstNumber / secondNumber;
                    break;
            }

            textResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            textResult.setText("");
        }
    }
}