package ru.qwerty_igogo.wrong_calculator;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import static ru.qwerty_igogo.wrong_calculator.MainActivity.first;
import static ru.qwerty_igogo.wrong_calculator.MainActivity.operation;
import static ru.qwerty_igogo.wrong_calculator.MainActivity.second;

/**
 * Created by matvienkodo on 06.03.17.
 */

class NumberButtonOnClickListener extends ButtonOnClickListener {
    NumberButtonOnClickListener(Context context, EditText inputField, EditText outputField) {
        super(context, inputField, outputField);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (operation == null)
            first = first * 10 + getDigit();
        else
            second = second * 10 + getDigit();

        String input = "";
        String output = "";

        if (operation == null) {
            output = input = first.toString();
        } else {
            input = first.toString()+ " " + operation.toString() + " " + second.toString();
            output = MainActivity.getResult(getContext()).toString();
        }

        getInputField().setText(input);
        getOutputField().setText(output);
    }
}
