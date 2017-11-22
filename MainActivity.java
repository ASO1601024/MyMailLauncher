package com.example.muraseyuuichirou.mymaillauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private String address;
    private String title;
    private String memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radio = (RadioGroup)findViewById(R.id.radioGroup);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = (RadioButton)findViewById(checkedId);
                ImageView image = (ImageView)findViewById(R.id.image);
                switch(checkedId) {
                    case R.id.address2:
                        image.setImageResource(R.drawable.kusa);
                        address = radioButton.getText().toString();
                        break;
                    case R.id.address3:
                        image.setImageResource(R.drawable.kuro);
                        address = radioButton.getText().toString();
                        break;
                    default:
                        image.setImageResource(R.drawable.happo);
                        address = radioButton.getText().toString();
                        break;
                }
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText) findViewById(R.id.title);
                title = et.getText().toString();
                EditText et2 = (EditText) findViewById(R.id.memo);
                memo = et2.getText().toString();

                Uri uri = Uri.parse("mailto:" + address);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, title);
                intent.putExtra(Intent.EXTRA_TEXT, memo);
                startActivity(intent);
            }
        });
    }
}
