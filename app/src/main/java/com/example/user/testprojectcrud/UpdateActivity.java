package com.example.user.testprojectcrud;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputEt;
    private TextView resultTV;
    private Button updateBtn;
    private DBHelper helper;
    private SQLiteDatabase database;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        helper = new DBHelper(this);
        database = helper.getWritableDatabase();

        Intent intent = getIntent();

       if(intent != null){

           // UserEntry userEntry = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);


            info = intent.getExtras().getString("com.example.user.TestProjectCRUD.MAIN_ACTIVITY_EXTRA");

            resultTV = (TextView) findViewById(R.id.tv_upActId);

            resultTV.setText(info);

            inputEt =  (EditText) findViewById(R.id.Ed_upActivId);

            Toast.makeText(this, ""+ info , Toast.LENGTH_SHORT).show();


            updateBtn = (Button) findViewById(R.id.btn_upActivId);
            updateBtn.setOnClickListener(this);



        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, ""+ info , Toast.LENGTH_SHORT).show();
         updateRecord();
    }

    private void updateRecord(){

         String toUpdate = info;
         String asUpdate = inputEt.getText().toString();

          //Toast.makeText(this, asUpdate, Toast.LENGTH_SHORT).show();

         ContentValues newVersion = new ContentValues();
         newVersion.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, asUpdate);

         String [] values = {""};
         values[0] = toUpdate;
         int count = database.update(FeedReaderContract.FeedEntry.TABLE_NAME,newVersion,FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE+" =?", values);

        if(count > 0){
            Toast.makeText(this, asUpdate+" updated" , Toast.LENGTH_SHORT).show();
        }
        else{
           Toast.makeText(this, asUpdate+" Record not updated to "+ toUpdate , Toast.LENGTH_SHORT).show();
        }


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
