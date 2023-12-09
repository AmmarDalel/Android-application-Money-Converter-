package com.example.tp2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MoneyConverter extends AppCompatActivity {


    private Button convert_btn ;
    private Button exit_btn ;
    private EditText val2convert_textview=null ;
    private RadioButton euro2dinar=null ;
    private RadioButton dinar2euro=null ;
    private EditText result_textview=null ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_converter);

        exit_btn = (Button) findViewById(R.id.b_exit);
        exit_btn.setBackgroundColor(getResources().getColor(R.color.orange1));

        convert_btn = (Button) findViewById(R.id.b_convert);
        convert_btn.setBackgroundColor(getResources().getColor(R.color.orange2));


    }

    public void convert(View v){
        Resources res=getResources() ;
        String appname=res.getString(R.string.app_name) ;
        Toast.makeText(this ,appname, Toast.LENGTH_LONG).show() ;
        this.val2convert_textview=(EditText) this.findViewById(R.id.val2convert_textview) ;
        this.euro2dinar=(RadioButton)this.findViewById(R.id.euro2dinar_rb) ;
        this.dinar2euro=(RadioButton)this.findViewById(R.id.dinar2euro_rb);
        this.result_textview=(EditText) this.findViewById(R.id.result_textview) ;
        try {
            double s = Double.parseDouble(val2convert_textview.getText().toString());

            double r = 0;
            if (euro2dinar.isChecked()) {
                r = s * 3.34;
                DecimalFormat dc = new DecimalFormat("0.000");

            } else {
                if (dinar2euro.isChecked()) {
                    r = s / 3.34;
                    DecimalFormat dc = new DecimalFormat("0.000");
                } else {
                    Toast.makeText(this, "please select one choice ", Toast.LENGTH_LONG).show();
                }
            }
            //ouvrir une autre Activity 
            Intent intent=new Intent(this ,ResultActivity.class);
            intent.putExtra("Result",r) ;
            this.startActivity(intent);

        }
        catch(NumberFormatException e){
            Toast.makeText(this , "please insert a numeric value" , Toast.LENGTH_LONG).show();
        }


    }

    public void exit(View v){
        System.exit(0);   }


}