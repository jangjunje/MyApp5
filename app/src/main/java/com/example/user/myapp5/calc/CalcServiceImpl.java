package com.example.user.myapp5.calc;

/**
 * Created by jjjnag on 2016-06-16.
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int plus(int num1, int num2) {
        return num1+num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1-num2;
    }

    @Override
    public int multi(int num1, int num2) {
        return num1*num2;
    }

    @Override
    public int divide(int num1, int num2) {
        return num1/num2;
    }

    @Override
    public int nmg(int num1, int num2) {
        return num1%num2;
    }
}
