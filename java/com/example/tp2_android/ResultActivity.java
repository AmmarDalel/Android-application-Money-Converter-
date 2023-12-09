package com.example.tp2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView result ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result=findViewById(R.id.result_textview) ;

        Intent intent=getIntent() ;
        double res=intent.getDoubleExtra("Result" , 0) ;
        System.out.println("--------"+res);
        result.setText(res+"");


    }
    public void revenir(View v){
        Intent intent2=new Intent(this ,MoneyConverter.class ) ;
        this.startActivity(intent2);
    }
}