package com.example.arush.credit_card;

import com.google.gson.annotations.SerializedName;

public class Pojo {
    @SerializedName("Prediction for decision tree")
    private String  Prediction;

    @SerializedName("Prediction for knn")
    private String  Prediction1;

    @SerializedName("Prediction for logisticreg")
    private String  Prediction2;

    @SerializedName("Prediction for randomforest")
    private String  Prediction3;


    public String getPrediction() {
        return Prediction;
    }

    public String getPrediction1() {
        return Prediction1;
    }

    public String getPrediction2() {
        return Prediction2;
    }

    public String getPrediction3() {
        return Prediction3;
    }

    public void setPrediction(String prediction) {
        Prediction = prediction;
    }
}
