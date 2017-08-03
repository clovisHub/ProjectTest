package com.example.user.testprojectcrud;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultTV;
    private Button readBtn;
    private DBHelper helper;
    private SQLiteDatabase database;
    private static final String TAG = ReadActivity.class.getSimpleName()+"_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        helper = new DBHelper(this);
        database = helper.getWritableDatabase();

        Intent intent = getIntent();

        if(intent != null){

            resultTV = (TextView) findViewById(R.id.tv_ReadActivId);
            readBtn = (Button) findViewById(R.id.btn_readActivId);
            readBtn.setOnClickListener(this);
        }


    }

    private void readRecord(){

        String [] projection = {FeedReaderContract.FeedEntry._ID, FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE};

        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE+"= ?";

        String [] selectionArg = { "Record title"};

        String sortedOrder = FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE+" DESC";

        StringBuilder myName = new StringBuilder();

        myName.append("  Title          SubTitle  \n");

        Cursor cursor = database.query(
                FeedReaderContract.FeedEntry.TABLE_NAME, //TAble
                projection,           //Projection
                null,                 //Selection
                null,                 //Values
                null,                 // Group by
                null,                 // Filter
                null);                // Sort order

        while(cursor.moveToNext()){

            long entryId = cursor.getLong(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID));
            String entryTitle = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE));
            String entrySubtitle = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE));
            myName.append(" "+entryTitle+"  "+entrySubtitle+" \n");
            Log.d(TAG, "readRecord: id: "+entryId+ " title: "+entryTitle+" subtitle: "+entrySubtitle);

        }

        resultTV.setText(""+myName.toString());

        database.close();
    }

    @Override
    public void onClick(View view) {

        Toast.makeText(this, "Read" , Toast.LENGTH_SHORT).show();
        readRecord();
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
        //Log.d(TAG, "onStop: ");
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
