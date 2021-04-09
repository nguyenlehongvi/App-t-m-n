package com.example.app_orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MonAn> arr = new ArrayList<>();;
    int index;
    MonAn monAn;

    ImageView imgAnhnen, imgAnhmon;
    TextView txvTenMonAn,txvGiaMonAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhxa();
        setUp();
    }

    private void init(){
        arr.add(new MonAn(R.drawable.a,"Salat rau củ", "100.000 vnđ"));
        arr.add(new MonAn(R.drawable.b,"Thịt viên Pháp", "200.000 vnđ"));
        arr.add(new MonAn(R.drawable.c,"Gà nướng khoai tây", "250.000 vnđ"));
        arr.add(new MonAn(R.drawable.bs,"Tôm nướng", "100.000 vnđ"));
        arr.add(new MonAn(R.drawable.da,"Tôm hấp", "100.000 vnđ"));

        monAn = arr.get(index);
    }

    private void anhxa(){
        txvTenMonAn = findViewById(R.id.txvTenMonAn);
        txvGiaMonAn = findViewById(R.id.txvGiaMonAn);
        imgAnhnen = findViewById(R.id.imgAnhnen);
        imgAnhmon = findViewById(R.id.imgAnhmon);
    }

    private void setUp(){
        runText();
        runAnh();
    }

    public void chuyenMon(View view) {
        index++;
        if(index==arr.size()){
            index=0;
        }
        monAn = arr.get(index);
        runText();
        runAnh();
    }

    public void runAnh(){
        imgAnhnen.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_top_bg));
        imgAnhmon.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_left_bg));
        new CountDownTimer(800, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                imgAnhnen.setImageResource(monAn.anh);
                imgAnhnen.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.top_to_bg));
                imgAnhmon.setImageResource(monAn.anh);
                imgAnhmon.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_to_bg));

            }
        }.start();
    }

    public void runText(){
        txvTenMonAn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_left_txv));
        txvGiaMonAn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_left_txv));
        new CountDownTimer(800, 100) {

            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                txvTenMonAn.setText(monAn.ten);
                txvTenMonAn.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_to_txv));
                txvGiaMonAn.setText(monAn.gia+" vnd");
                txvGiaMonAn.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_to_txv));
            }
        }.start();
    }
}