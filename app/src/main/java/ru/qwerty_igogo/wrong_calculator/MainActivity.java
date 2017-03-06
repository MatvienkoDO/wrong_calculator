package ru.qwerty_igogo.wrong_calculator;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.system.Os;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    static Double first = 0.0;
    static Double second = 0.0;
    static Sign operation = null;

    @Override
    protected void onStart() {
        super.onStart();
        final EditText inputField = (EditText) findViewById(R.id.input_field);
        final EditText outputField = (EditText) findViewById(R.id.output_field);
        findViewById(R.id.button_1).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_2).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_3).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_4).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_5).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_6).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_7).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_8).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_9).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_0).setOnClickListener(new NumberButtonOnClickListener(this, inputField, outputField));

        findViewById(R.id.button_plus).setOnClickListener(new SignButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_minus).setOnClickListener(new SignButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_multi).setOnClickListener(new SignButtonOnClickListener(this, inputField, outputField));
        findViewById(R.id.button_razd).setOnClickListener(new SignButtonOnClickListener(this, inputField, outputField));

        findViewById(R.id.button_cancel).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                first = second = 0.0;
                operation = null;
                inputField.setText(0.0+"");
                outputField.setText(0.0+"");
            }
        });
    }

    public static void mistake(Context context){
        if(context.getResources().getBoolean(R.bool.vibrate_of_not)){
            Vibrator vibrator = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(context.getResources().getInteger(R.integer.mistake_vibration_time));
        }
    }

    static Double getResult(Context context){
        Double result = 0.0;
        if(operation==null) return result;
        switch (operation) {
            case PLUS: { result = (first + second); break; }
            case MINUS: { result = (first - second); break; }
            case MULTI: { result = (first * second); break; }
            case RAZD: {
                if(Math.abs(second)>Double.MIN_NORMAL)
                    result = (first / second);
                else {
                    result = 0.0;
                    MainActivity.mistake(context);
                }
                break;
            }
        }
        return result;
    }
}