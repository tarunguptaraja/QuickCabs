package com.tarunguptaraja.quickcabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;

public class SignUp extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }


    public void sendOtp(View view) {
        ccp=findViewById(R.id.ccp);
        editText=findViewById(R.id.number);
        button=findViewById(R.id.getOTP);
        textView=findViewById(R.id.error);
        ccp.registerCarrierNumberEditText(editText);
        if(editText.getText().toString().length()<10){
            textView.setText("Please enter a valid phone number.");
        }else{
            Intent intent=new Intent(SignUp.this,ManageOTP.class);
            intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
            startActivity(intent);
        }

    }
}