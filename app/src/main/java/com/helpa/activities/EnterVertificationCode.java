package com.helpa.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.helpa.R;

public class EnterVertificationCode extends AppCompatActivity implements View.OnClickListener {

    TextView tv_resend;

    RelativeLayout vertifyButton;

    ImageView cross_imageview;
    TextView tv_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_vertification_code);
        initView();
        setListeners();


    }

    private void setListeners() {
        cross_imageview.setOnClickListener(this);
        vertifyButton.setOnClickListener(this);
    }

    private void initView() {


        tv_resend = findViewById(R.id.tv_resend);
        cross_imageview = findViewById(R.id.cross_imageview);
        tv_title = findViewById(R.id.tv_title);
        vertifyButton = findViewById(R.id.vertifyButton);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
          /*  case R.id.vertifyButton:

                startActivityForResult(new Intent(LogInActivity.this,ChooseZipCode.class),101);
                // if(AppUtils.isInternetAvailable(LogInActivity.this)) {
//                    if (validate())
//                        hitLogInAPI();
//                }
//               else
//                   AppUtils.showToast(LogInActivity.this,getResources().getString(R.string.no_internet));
                break;*/
            case R.id.cross_imageview:
                finish();
                break;

            case R.id.vertifyButton:
                startActivity(new Intent(EnterVertificationCode.this, SignUpActivity.class));
                break;


        }
    }
}
