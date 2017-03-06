package ru.qwerty_igogo.wrong_calculator;

/**
 * Created by matvienkodo on 06.03.17.
 */

enum Sign {
    PLUS,
    MINUS,
    MULTI,
    RAZD;

    @Override
    public String toString() {
        String result = "";
        switch(this){
            case PLUS:{ result="+"; break; }
            case MINUS:{ result="-"; break; }
            case MULTI:{ result="*"; break; }
            case RAZD:{ result=":"; break; }
        }
        return result;
    }
}
