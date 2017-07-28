package com.example.user.testprojectcrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SavingActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textToSave;
    Button saveBtn;
    String message ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving);

        Intent intent = new Intent();

        if(intent != null){

            UserEntry userEntry = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);
            String info;
            textToSave = (TextView) findViewById(R.id.tv_SaveActivId);
            saveBtn = (Button) findViewById(R.id.btn_saveActivId);
            info = userEntry.getEntry();

            textToSave.setText(info);

        }

    }

    @Override
    public void onClick(View view) {

    }
}
