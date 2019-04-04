package com.helpa.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.helpa.interfaces.NetworkListener;
import com.helpa.network.ApiCall;
import com.helpa.network.ApiInterface;
import com.helpa.network.RestApi;
import com.helpa.utils.AppConstant;
import com.helpa.utils.AppSharedPreference;
import com.helpa.utils.AppUtils;
import com.helpa.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class LogInActivity extends BaseActivity implements View.OnClickListener {
    private EditText etNumber;

    private ProgressBar bar;
    LinearLayout ll_lang_lay;

    ImageView cross_imageview;
    TextView tv_title;

    RelativeLayout getCodeButton;

    static final int PICK_CONTACT_REQUEST = 1;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setListeners();
    }

    @Override
    public void onBackPressed() {
     /*   Intent intent = new Intent(LogInActivity.this, MainActivity.class);
        startActivity(intent);*/
        finish();
    }

    /*
    * Initialize all views IDs
    * */
    private void initView() {
        bar = findViewById(R.id.bar);
        etNumber = findViewById(R.id.etNumber);
        cross_imageview =findViewById(R.id.cross_imageview);
        tv_title = findViewById(R.id.tv_title);
        ll_lang_lay = findViewById(R.id.ll_lang_lay);
        getCodeButton = findViewById(R.id.getCodeButton);

    }

    /*
    * Initialize all listeners
    * */
    private void setListeners() {
        cross_imageview.setOnClickListener(this);
        ll_lang_lay.setOnClickListener(this);
        getCodeButton.setOnClickListener(this);
    }

    /*
    * validate all cases
    * */
    private Boolean validate()
    {
         if(etNumber.getText().toString().trim().length()==0)
        {
            AppUtils.showToast(LogInActivity.this,getResources().getString(R.string.h_number));
            return false;
        }
//        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString().trim()).matches())
//        {
//            AppUtils.showToast(LogInActivity.this,getResources().getString(R.string.email_invalid_val));
//            return false;
//        }
//        else if(etPassword.getText().toString().trim().length()==0)
//        {
//            AppUtils.showToast(LogInActivity.this,getResources().getString(R.string.h_password));
//            return false;
//        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.ll_lang_lay:

                startActivityForResult(new Intent(LogInActivity.this,ChooseZipCode.class),101);
               // if(AppUtils.isInternetAvailable(LogInActivity.this)) {
//                    if (validate())
//                        hitLogInAPI();
//                }
//               else
//                   AppUtils.showToast(LogInActivity.this,getResources().getString(R.string.no_internet));
               break;
            case R.id.cross_imageview:
              finish();
                break;

            case R.id.getCodeButton:
                startActivity(new Intent(LogInActivity.this,EnterVertificationCode.class));
                break;



        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {

            }
        }
    }
//    /*
//    * Hit login Api through email and password
//    * */
//    private void hitLogInAPI() {
//        bar.setVisibility(View.VISIBLE);
//        ApiInterface apiInterface = RestApi.createService(LogInActivity.this,ApiInterface.class);
//        final HashMap params = new HashMap<>();
//        params.put("email", etEmail.getText().toString());
//        params.put("password", etPassword.getText().toString());
//        params.put("device_id", AppUtils.getDeviceId(LogInActivity.this));
//        params.put("device_token", FirebaseInstanceId.getInstance().getToken());
//        params.put("platform", "1");
//        Call<ResponseBody> call = apiInterface.login(params);
//        ApiCall.getInstance().hitService(LogInActivity.this, call, this,1);
//    }
//
//    @Override
//    public void onSuccess(int responseCode, String response, int requestCode) {
//        bar.setVisibility(View.GONE);
//        String token = null, refreshToken = null;
//        try {
//            JSONObject object = new JSONObject(response);
//            AppUtils.showToast(LogInActivity.this,object.getString(AppConstant.message));
//            int code = object.getInt(AppConstant.code);
//            if(code==200) {
//                token = object.getJSONObject(AppConstant.result).getString(AppConstant.accessToken);
//                refreshToken = object.getJSONObject(AppConstant.result).getString(AppConstant.refreshToken);
//                AppSharedPreference.getInstance().putString(LogInActivity.this,AppSharedPreference.ACCESS_TOKEN, token);
//                AppSharedPreference.getInstance().putString(LogInActivity.this,AppSharedPreference.REFRESH_TOKEN, refreshToken);
//                AppSharedPreference.getInstance().putString(LogInActivity.this,AppSharedPreference.PROFILE, response);
//                Intent intent = new Intent(LogInActivity.this, HomeActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void onError( String response, int requestCode) {
//        bar.setVisibility(View.GONE);
//        AppUtils.showToast(LogInActivity.this,response+"");
//    }
//
//    @Override
//    public void onFailure() {
//        bar.setVisibility(View.GONE);
//        AppUtils.showToast(LogInActivity.this,"Failure");
//    }
}
