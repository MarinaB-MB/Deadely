package com.deadely.copy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends Activity {

    GridView gridview;

    public static String[] mvNameList = {
            "Урфин Джюс и его деревянные солдаты",
            "Квартира",
            "Остров собак",
            "Лига справедливости",
            "Мэри и Макс",
            "Песнь моря",
            "Призрачная нить",
            "Шарада",
            "Кошмар перед Рождеством",
    };
    public static int[] mvImages = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.pi4,
            R.drawable.p5,
            R.drawable.p6,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = (GridView) findViewById(R.id.grid_view);

        gridview.setAdapter(new DataAdapter(this, mvNameList, mvImages));
    }


}