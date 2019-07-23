package com.example.coco.changefragmentdemo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private Button pay;
    private Button income;
    private RelativeLayout rl;
    private IncomeFragment incomeFragment;
    private PayFragment payFragment;
    FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    boolean isClick=false;

    public void isClick(boolean isClick) {
        if (isClick) {
            this.isClick = isClick;
        } else {
            this.isClick = false;
        }
    }

    private void initView() {
        pay = findViewById(R.id.pay);
        income = findViewById(R.id.income);
        pay.setOnClickListener(this);
        income.setOnClickListener(this);
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (payFragment == null) {
            payFragment = new PayFragment();
            ft.add(R.id.fl, payFragment);
        } else {
            ft.show(payFragment);
        }
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.income:
                if (isClick){
                    setTabSelection(0);
                }else {
                    Toast.makeText(this, "请输入内容后点击", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.pay:
                setTabSelection(1);
                break;
        }

    }

    private void setTabSelection(int index) {
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (index) {
            case 0:
                if (incomeFragment == null) {
                    incomeFragment = new IncomeFragment();
                    ft.add(R.id.fl, incomeFragment);
                } else {
                    ft.show(incomeFragment);
                }

                break;

            case 1:
                if (payFragment == null) {
                    payFragment = new PayFragment();
                    ft.add(R.id.fl, payFragment);
                }
                ft.show(payFragment);
                break;
        }
        ft.commit();
    }

    //用于隐藏fragment
    private void hideFragment(FragmentTransaction ft) {
        if (incomeFragment != null) {
            ft.hide(incomeFragment);
        }
        if (payFragment != null) {
            ft.hide(payFragment);
        }
    }
}
