package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // создадим поля
    private float korzh = 10; // коржи
    private int korzhDiscount = 26; // скидка на коржи
    private float cream = 14; // сливки
    private int creamDiscount = 5; // скидка на сливки
    private float fruits = 3; // фрукты
    private int fruitsDiscount = 12; // скидка на фрукты
    private float nuts = 5; // орехи
    private int nutsDiscount = 55; // скидка на орехи
    private float berries = 7; // ягоды
    private float account = 45; // баланс на счету

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить продукты для торта
            possibilityOut.setText("Имеется достаточно средств для приготовления торта");
            balanceOut.setText("Остаток от покупки " + balance() + " монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки товаров для приготовления торта");
            balanceOut.setText(" - ");
        }
    }

    // метод подсчёта стоимости фото-комплекта
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (korzh * (100 - korzhDiscount) + cream * (100 - creamDiscount)
                + fruits * (100 - fruitsDiscount) + nuts * (100 - nutsDiscount)) / 100 + berries;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки фото-комплекта
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить фото-комплект
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }
}