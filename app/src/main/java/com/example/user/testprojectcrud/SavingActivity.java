package com.example.user.testprojectcrud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;


public class SavingActivity extends AppCompatActivity implements View.OnClickListener {
    EditText textToSave, detailsToSave;
    Button saveBtn;
    String message ="";
    private DBHelper helper;
    private SQLiteDatabase database;
    private static final String TAG = SavingActivity.class.getSimpleName()+"_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving);
        helper = new DBHelper(this);
        database = helper.getWritableDatabase();

        Intent intent = getIntent();

        if(intent != null){

           // UserEntry userEntry = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);
            String info;
            textToSave = (EditText) findViewById(R.id.ed_SaveActivId);
            detailsToSave = (EditText) findViewById(R.id.ed_SaveActivIdDetails);
            saveBtn = (Button) findViewById(R.id.btn_saveActivId);
            saveBtn.setOnClickListener(this);
            //info = textToSave.toString();
            //Toast.makeText(this, info , Toast.LENGTH_SHORT).show();
            //textToSave.setText(info);

        }

    }

    private void saveRecord(){


        //String title = "Record title";
        //String subtitle = "Record subtitle";

        String valueUnderTitle = textToSave.getText().toString();
        String valueUnderSubtitle = detailsToSave.getText().toString();

        ContentValues values;
        values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,valueUnderTitle);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE,valueUnderSubtitle);

        long recordId = database.insert( FeedReaderContract.FeedEntry.TABLE_NAME, null, values);

        if(recordId > 0){
            Toast.makeText(this, "Saved" , Toast.LENGTH_SHORT).show();
            //Log.d(TAG, "saveRecord: Record saved");
        }
        else{
            Toast.makeText(this, "Not Saved" , Toast.LENGTH_SHORT).show();
            //Log.d(TAG, "saveRecord: Record not save");
        }
        textToSave.setText("");
        detailsToSave.setText("");

    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        database.close();
    }


    @Override
    public void onClick(View view) {
        saveRecord();
    }


    @Override
    protected void onStart() {
        super.onStart();
        //Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Log.d(TAG, "onRestart: ");
    }


}
