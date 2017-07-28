package com.example.user.testprojectcrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultTV;
    private Button readBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Intent intent = new Intent();

        if(intent != null){

            UserEntry userEntry = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);
            String info;
            resultTV = (TextView) findViewById(R.id.tv_ReadActivId);
            readBtn = (Button) findViewById(R.id.btn_readActivId);
            info = userEntry.getEntry();

            resultTV.setText(info);

        }
    }

    @Override
    public void onClick(View view) {

    }
}
