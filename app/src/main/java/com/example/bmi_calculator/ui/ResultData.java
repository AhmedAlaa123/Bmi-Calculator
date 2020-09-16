package com.example.bmi_calculator.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bmi_calculator.R;
import com.example.bmi_calculator.data.BmiBrain;
import com.example.bmi_calculator.data.BmiModel;
import com.example.bmi_calculator.utils.Constants;

public class ResultData extends AppCompatActivity implements View.OnClickListener {
    private BmiModel bmiModel;
    private BmiBrain bmiBrain;
    private TextView textView_bmi;
    private TextView textView_bmiValue;
    private TextView textView_gender;
    private TextView textView_age;
    private TextView textView_message;
    private TextView textView_result_height;
    private TextView textView_result_weight;
    private ConstraintLayout layout_recalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_data);


       textView_bmi = findViewById(R.id.textView_bmi);
        textView_bmiValue = findViewById(R.id.textView_bmiValue);
        textView_gender = findViewById(R.id.textView_gender);
        textView_age = findViewById(R.id.textView_age);
        textView_message = findViewById(R.id.textView_message);
        textView_result_height=findViewById(R.id.textView_result_height);
        textView_result_weight=findViewById(R.id.textView_result_weight);

      layout_recalculate = findViewById(R.id.layout_recalculate);

        layout_recalculate.setOnClickListener(this);
        bmiModel = (BmiModel) getIntent().getSerializableExtra(Constants.BMIMODEL_EXTRA);
        bmiBrain = BmiBrain.getInstance();
        bmiBrain.setBmiModel(bmiModel);
        setDataResult();

    }

    private void setDataResult() {
        textView_bmi.setText(bmiBrain.getResultText());
        textView_bmiValue.setText(String.valueOf(bmiModel.getBmi()));
        String gender = "";
        if (bmiModel.getGender() == Constants.Gender.FEMALE)
            gender = "FEMALE";
        else {
            gender = "MALE";
        }
        textView_gender.setText(gender);
        textView_age.setText("Age : " + bmiModel.getAge());
        textView_message.setText(bmiBrain.getInterpretation());
        textView_result_height.setText("Height : "+bmiModel.getHeight());
        textView_result_weight.setText("Weight : "+bmiModel.getWeight());



    }

    @Override
    public void onClick(View v) {
        finish();
    }
}