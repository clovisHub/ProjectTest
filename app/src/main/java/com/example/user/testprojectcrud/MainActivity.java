package com.example.user.testprojectcrud;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputEt;
    private TextView resultTV;
    private Button saveBtn, readBtn, deleteBtn, updateBtn;
    private File myExternalFile;
    private String data ="";
    private String buttonClicked ="";
    public static final String MAIN_ACTIVITY_EXTRA ="com.example.user.TestProjectCRUD.MAIN_ACTIVITY_EXTRA";

    private static final String SAVE_BTN ="Save";
    private static final String READ_BTN ="Read";
    private static final String UPDATE_BTN ="Update";
    private static final String DELETE_BTN ="Delete";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEt = (EditText) findViewById(R.id.myText);

        readBtn = (Button) findViewById(R.id.btn_readId);

        saveBtn = (Button) findViewById(R.id.btn_saveId);

        deleteBtn = (Button) findViewById(R.id.btn_deleteId);

        updateBtn = (Button) findViewById(R.id.btn_updateId) ;


        saveBtn.setOnClickListener(this);
        readBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        updateBtn.setOnClickListener(this);


    }

    public void  sendData(View view) {

        String note = inputEt.getText().toString();
        UserEntry valueToSend = new UserEntry(note);

        Intent intent;
        if(buttonClicked == SAVE_BTN){
            Toast.makeText(this, note , Toast.LENGTH_SHORT).show();
            intent = new Intent(MainActivity.this, SavingActivity.class);
        }
        else if(buttonClicked== READ_BTN){
            intent = new Intent(MainActivity.this, ReadActivity.class);
        }
        else if(buttonClicked== DELETE_BTN){
            intent = new Intent(MainActivity.this, DeleteActivity.class);
        }
        else {
            intent = new Intent(MainActivity.this, UpdateActivity.class);
        }

        startActivity(intent);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.btn_saveId:
                buttonClicked = SAVE_BTN;
                //Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_readId:
                buttonClicked = READ_BTN;
                break;
            case R.id.btn_deleteId:
                buttonClicked = DELETE_BTN;
                break;
            case R.id.btn_updateId:
                buttonClicked = UPDATE_BTN;
                break;

        }
    }



}