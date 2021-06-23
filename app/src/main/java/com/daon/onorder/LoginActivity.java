package com.daon.onorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.sam4s.printer.Sam4sBuilder;
import com.sam4s.printer.Sam4sPrint;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout loginBtn;
    EditText id;
    EditText pass;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Sam4sPrint printer;
    Sam4sPrint printer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = getSharedPreferences("pref", MODE_PRIVATE);
        editor = pref.edit();

        id = findViewById(R.id.edit_id);
        pass = findViewById(R.id.edit_pw);

        loginBtn = findViewById(R.id.loginactivity_btn_login);
        if (!pref.getString("table", "").equals("")){
            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent);
            finish();
        }
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String str_id = "ots";
//                String str_pass = "1234";
//                if (str_id.contains(":")) {
//                    String[] arr_id = str_id.split(":");
//                    if (!str_pass.equals("") || !str_id.equals("")) {
//                        Retrofit retrofit = new Retrofit.Builder()
//                                .baseUrl("http://15.164.232.164:5000/")
//                                .addConverterFactory(new NullOnEmptyConverterFactory())
//                                .addConverterFactory(GsonConverterFactory.create())
//                                .build();
//                        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
//
////                        interfaceApi.LoginService(arr_id[0], str_pass, "").enqueue(new Callback<JsonObject>() {
//                        interfaceApi.LoginService(str_id, str_pass, "").enqueue(new Callback<JsonObject>() {
//
//                                @Override
//                            public void onResponse(retrofit2.Call<JsonObject> call, Response<JsonObject> response) {
//                                if (response.isSuccessful()) {
//                                    Log.d("daon", String.valueOf(response.body().get("StatusCode")));
//                                    if (String.valueOf(response.body().get("StatusCode")).equals("200")) {
//                                        String fcm = String.valueOf(response.body().get("Message")).replace("\"", "");
//                                        editor.putString("id", str_id);
//                                        editor.putString("table", "1");
//                                        editor.putString("fcm", fcm);
//                                        editor.putString("storecode", String.valueOf(response.body().get("StoreCode")).replace("\"", ""));
//                                        editor.putString("addr", String.valueOf(response.body().get("Addr")).replace("\"", ""));
//                                        editor.putString("storename", String.valueOf(response.body().get("Name")).replace("\"", ""));
//
//
//                                        editor.commit();
//                                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
//                                        startActivity(intent);
//                                        finish();
//
//                                    }
//                                } else {
//
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<JsonObject> call, Throwable t) {
//                                Log.d("daon", "fail = " + t.getMessage());
//                            }
//                        });
//
////                    editor.putString("id", id.getText().toString());
////                    editor.commit();
////                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
////                    startActivity(intent);
////                    finish();
//                    }
//                }else{
//                    Toast.makeText(LoginActivity.this, "테이블 번호가 없습니다.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableno = pass.getText().toString();
                if (!tableno.equals("")) {
                    String str_id = "song12";
                    String str_pass = "1234";
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://15.164.232.164:5000/")
                            .addConverterFactory(new NullOnEmptyConverterFactory())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
                    interfaceApi.LoginService(str_id, str_pass, "").enqueue(new Callback<JsonObject>() {

                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            if (response.isSuccessful()) {
                                if (String.valueOf(response.body().get("StatusCode")).equals("200")) {
                                    Log.d("dao_test", response.body().toString());
                                    String fcm = String.valueOf(response.body().get("Message")).replace("\"", "");
                                    editor.putString("id", str_id);
                                    editor.putString("table", pass.getText().toString());
                                    editor.putString("fcm", fcm);
                                    editor.putString("storecode", String.valueOf(response.body().get("StoreCode")).replace("\"",
                                            ""));
                                    editor.putString("addr", String.valueOf(response.body().get("Addr")).replace("\"", ""));
                                    editor.putString("storename", String.valueOf(response.body().get("Name")).replace("\"", ""));
//                                        editor.putString("storename", "ots_test");
                                    editor.commit();
                                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                                    startActivity(intent);
                                    finish();

                                }
                            } else {

                            }
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {
                        }
                    });
                }
            }


        });

    }

}