package com.example.user.testprojectcrud;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText resultTV;
    private Button deleteBtn;
    private DBHelper helper;
    private SQLiteDatabase database;
    String message ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        helper = new DBHelper(this);
        database = helper.getWritableDatabase();

        Intent intent = getIntent();

        if(intent != null){

            //UserEntry userEntry = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);
            String info;
            resultTV = (EditText) findViewById(R.id.tv_Delete);
            deleteBtn = (Button) findViewById(R.id.btn_deleteActivId);
            info = resultTV.getText().toString();

            resultTV.setText(info);

            deleteBtn.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View view) {

        deleteEntry();

    }

    private void deleteEntry(){

        String  value = resultTV.getText().toString();
        String [] values = {""};
        values[0]= value;
        int count = database.delete(FeedReaderContract.FeedEntry.TABLE_NAME,FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE+" =?",values);

        if(count > 0){
            Toast.makeText(this, value+" deleted" , Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Record not deleted" , Toast.LENGTH_SHORT).show();
        }
        database.close();
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

    @Override
    protected void onDestroy(){
        super.onDestroy();
        database.close();
    }
}
