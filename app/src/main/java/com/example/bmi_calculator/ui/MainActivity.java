package com.example.bmi_calculator.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmi_calculator.R;
import com.example.bmi_calculator.data.BmiModel;
import com.example.bmi_calculator.utils.Constants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SeekBar seekBar;
    private ImageView imageView_increment_weight;
    private ImageView imageView_decrement_weight;
    private ImageView imageView_increment_age;
    private ImageView imageView_decrement_age;
    private TextView textView_height_value;
    private TextView textView_weight_value;
    private TextView textView_age_value;
    private LinearLayout linearLayout_male;
    private LinearLayout linearLayout_female;
    private LinearLayout linearLayout_calculate;
    private int ageValue = 10, heightValue = 10, weightValue = 10;
    private Constants.Gender gender = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekbar);
        imageView_decrement_age = findViewById(R.id.btn_decrease_age);
        imageView_decrement_weight = findViewById(R.id.btn_decrease_weight);
        imageView_increment_age = findViewById(R.id.btn_increase_age);
        imageView_increment_weight = findViewById(R.id.btn_increase_weight);
        textView_age_value = findViewById(R.id.text_view_Age);
        textView_height_value = findViewById(R.id.text_view_height);
        textView_weight_value = findViewById(R.id.text_view_weight);
        linearLayout_male = findViewById(R.id.layout_male);
        linearLayout_female = findViewById(R.id.layout_female);
        linearLayout_calculate = findViewById(R.id.layout_calculate);
        seekBar.setProgress(40);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView_height_value.setText(String.valueOf(progress));
                if (progress == 0)
                    seekBar.setProgress(1);

                heightValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        imageView_decrement_age.setOnClickListener(this);
        imageView_decrement_weight.setOnClickListener(this);
        imageView_increment_age.setOnClickListener(this);
        imageView_increment_weight.setOnClickListener(this);

        linearLayout_female.setOnClickListener(this);
        linearLayout_male.setOnClickListener(this);

        linearLayout_calculate.setOnClickListener(this);

        textView_age_value.setText(String.valueOf(ageValue));
        textView_weight_value.setText(String.valueOf(weightValue));
        textView_height_value.setText(String.valueOf(heightValue));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_decrease_age:
                if (ageValue > 2) {
                    ageValue--;
                }
                textView_age_value.setText(String.valueOf(ageValue));
                break;
            case R.id.btn_increase_age:
                ageValue++;
                textView_age_value.setText(String.valueOf(ageValue));
                break;
            case R.id.btn_decrease_weight:
                if (weightValue > 10) {
                    weightValue--;
                }
                textView_weight_value.setText(String.valueOf(weightValue));
                break;
            case R.id.btn_increase_weight:
                weightValue++;
                textView_weight_value.setText(String.valueOf(weightValue));
                break;

            case R.id.layout_female:
                gender = Constants.Gender.FEMALE;
                linearLayout_female.setBackground(getResources().getDrawable(R.drawable.selected_gender_design));
                linearLayout_male.setBackground(getResources().getDrawable(R.drawable.item_design));

                break;
            case R.id.layout_male:
                gender = Constants.Gender.MALE;
                linearLayout_male.setBackground(getResources().getDrawable(R.drawable.selected_gender_design));
                linearLayout_female.setBackground(getResources().getDrawable(R.drawable.item_design));

                break;
            case R.id.layout_calculate:
                Intent intent = new Intent(this, ResultData.class);
                if (gender == null) {
                    Toast.makeText(this, "Please Choose Gender", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (heightValue < 40) {
                    Toast.makeText(this, "Height is so small", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (weightValue < 10) {
                    Toast.makeText(this, "Weight is so small", Toast.LENGTH_SHORT).show();
                    return;
                }

                BmiModel bmiModel = new BmiModel(gender, heightValue, weightValue, ageValue);
                intent.putExtra(Constants.BMIMODEL_EXTRA, bmiModel);
                startActivity(intent);


        }
    }
}