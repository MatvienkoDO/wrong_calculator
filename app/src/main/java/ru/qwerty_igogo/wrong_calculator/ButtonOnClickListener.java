package ru.qwerty_igogo.wrong_calculator;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by matvienkodo on 06.03.17.
 */

abstract class ButtonOnClickListener implements View.OnClickListener {
    private final Context context;
    private final EditText inputField;
    private final EditText outputField;
    private String buttonText;
    private Sign sign = null;
    private Integer digit = null;

    ButtonOnClickListener(Context context, EditText inputField, EditText outputField) {
        this.context = context;
        this.inputField = inputField;
        this.outputField = outputField;
    }

    protected final EditText getInputField() {
        return inputField;
    }

    protected final EditText getOutputField() {
        return outputField;
    }

    protected final Sign getSign() {
        return sign;
    }

    protected final Integer getDigit() {
        return digit;
    }

    protected final String getButtonText() {
        return buttonText;
    }

    protected Context getContext() { return context; }

    @Override
    public void onClick(View v) {
        buttonText = ((Button) v).getText().toString();

        //если надпись на кнопке явл цифрой
        if (buttonText.length() == 1 && Character.isDigit(buttonText.charAt(0)))
            this.digit = Character.getNumericValue(buttonText.charAt(0));

            //обработаю тут знаки +,-,*,: по-крутому. Буду использовать ресурсы
        else if (buttonText.compareTo(context.getResources().getString(R.string.sign_plus)) == 0) //если на кнопке написано +, то ...
            this.sign = Sign.PLUS;
        else if (buttonText.compareTo(context.getResources().getString(R.string.sign_minus)) == 0)
            this.sign = Sign.MINUS;
        else if (buttonText.compareTo(context.getResources().getString(R.string.sign_multi)) == 0)
            this.sign = Sign.MULTI;
        else if (buttonText.compareTo(context.getResources().getString(R.string.sign_razd)) == 0)
            this.sign = Sign.RAZD;
        //else
    }
}
