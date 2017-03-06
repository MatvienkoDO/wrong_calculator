package ru.qwerty_igogo.wrong_calculator;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import static ru.qwerty_igogo.wrong_calculator.MainActivity.first;
import static ru.qwerty_igogo.wrong_calculator.MainActivity.getResult;
import static ru.qwerty_igogo.wrong_calculator.MainActivity.operation;
import static ru.qwerty_igogo.wrong_calculator.MainActivity.second;

/**
 * Created by matvienkodo on 06.03.17.
 */

class SignButtonOnClickListener extends ButtonOnClickListener {
    SignButtonOnClickListener(Context context, EditText inputField, EditText outputField) {
        super(context, inputField, outputField);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (operation == null)
            operation = getSign();
        else {
            first = getResult(getContext());
            second = 0.0;
            operation = getSign();
            getInputField().setText(first.toString());
            getOutputField().setText(first.toString());
        }
    }
}
