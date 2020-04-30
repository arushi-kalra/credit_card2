package com.example.arush.credit_card;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/predict")
    Call<Pojo> getAPIResponse(
            @Query("Average Amount/transaction/day") String avg_amt,
            @Query("Transaction_amount") String transac_amt,
            @Query("Is declined") String is_dec ,
            @Query("Total Number of declines/day") String no_of_dec,
            @Query("isForeignTransaction") String foreign_transac,
            @Query("isHighRiskCountry") String is_highrisk_country ,
            @Query("Daily_chargeback_avg_amt") String chargeback,
            @Query("6_month_avg_chbk_amt") String chbk_amt,
            @Query("6-month_chbk_freq") String chbk_freq);




}
