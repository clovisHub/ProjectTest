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
            Toast.makeText(this, "Save" , Toast.LENGTH_SHORT).show();
            intent = new Intent(MainActivity.this, SavingActivity.class);
            //intent.putExtra(MAIN_ACTIVITY_EXTRA,note);
           // startActivity(intent);
        }
        else if(buttonClicked == READ_BTN){
            Toast.makeText(this, "Read" , Toast.LENGTH_SHORT).show();
            intent = new Intent(MainActivity.this, ReadActivity.class);
           // intent.putExtra(MAIN_ACTIVITY_EXTRA,note);

        }
        else if(buttonClicked == DELETE_BTN){
            Toast.makeText(this, "Delete" , Toast.LENGTH_SHORT).show();
            intent = new Intent(MainActivity.this, DeleteActivity.class);
            intent.putExtra(MAIN_ACTIVITY_EXTRA,note);

        }
        else {

            Toast.makeText(this, "Update" , Toast.LENGTH_SHORT).show();
            intent = new Intent(MainActivity.this, UpdateActivity.class);
            intent.putExtra(MAIN_ACTIVITY_EXTRA,note);
        }


       startActivity(intent);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.btn_saveId:
                buttonClicked = SAVE_BTN;
                Toast.makeText(this, buttonClicked, Toast.LENGTH_SHORT).show();
                sendData(view);
                break;
            case R.id.btn_readId:
                buttonClicked = READ_BTN;
                Toast.makeText(this, buttonClicked, Toast.LENGTH_SHORT).show();
                sendData(view);
                break;
            case R.id.btn_deleteId:
                buttonClicked = DELETE_BTN;
                Toast.makeText(this, buttonClicked, Toast.LENGTH_SHORT).show();
                sendData(view);
                break;
            case R.id.btn_updateId:
                buttonClicked = UPDATE_BTN;
                Toast.makeText(this, buttonClicked, Toast.LENGTH_SHORT).show();
                sendData(view);
                break;

        }
    }



}