package com.example.user.testprojectcrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputEt;
    private TextView resultTV;
    private Button updateBtn;
    String message ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = new Intent();

        if(intent != null){

            UserEntry userEntry = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);
            String info;
            resultTV = (TextView) findViewById(R.id.tv_updatActivId);
            updateBtn = (Button) findViewById(R.id.btn_saveActivId);
            info = userEntry.getEntry();

            resultTV.setText(info);

        }
    }

    @Override
    public void onClick(View view) {

    }
}
