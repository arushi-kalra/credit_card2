package com.example.arush.credit_card;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    EditText avgamt, transc, is_dec, total_num,is_foreign,is_highris,daily_chargeback,chbk_amt,chbk_freq;
    Button button;
    //List<String>vizdata=new ArrayList<>();
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiInterface apiInterface;


        button=(Button) findViewById(R.id.btn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                avgamt = (EditText) findViewById(R.id.txt1);
                transc= (EditText) findViewById(R.id.txt2);
                is_dec = (EditText) findViewById(R.id.txt3);
                total_num= (EditText) findViewById(R.id.txt4);
                is_foreign= (EditText) findViewById(R.id.txt5);
                is_highris= (EditText) findViewById(R.id.txt6);
                daily_chargeback = (EditText) findViewById(R.id.txt7);
                chbk_amt = (EditText) findViewById(R.id.txt8);
                chbk_freq = (EditText) findViewById(R.id.txt9);
                String a=avgamt.getText().toString();
                String t=transc.getText().toString();
                String d=is_dec.getText().toString();
                String tn=total_num.getText().toString();
                String i_f=is_foreign.getText().toString();
                String i_h=is_highris.getText().toString();
                String d_c=daily_chargeback.getText().toString();
                String c_a=chbk_amt.getText().toString();
                String c_f=chbk_freq .getText().toString();
                hitApi(a,t,d,tn,i_f,i_h,d_c,c_a,c_f);
            }
        });

    }
    public void hitApi(String a,String t,String d,String tn,String i_f,String i_h,String d_c,String c_a,String c_f)
    {

        apiInterface= com.example.arushi.credi_card.ApiClient.getApiClient().create(ApiInterface.class);
        Call<Pojo> call=apiInterface.getAPIResponse(a,t,d,tn,i_f,i_h,d_c,c_a,c_f);
        call.enqueue(
                new Callback<Pojo>() {
                    @Override
                    public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                        if(response.isSuccessful())
                        {
                            if(response!=null)
                            {
                                Log.d(TAG, "onResponse: "+ response.body().getPrediction());

                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<Pojo> call, Throwable t) {

                        Log.d(TAG, "onFailure: "+t.getMessage());

                    }
                }
        );


    }
}


