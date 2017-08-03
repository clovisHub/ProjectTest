package com.example.user.testprojectcrud;

import android.provider.BaseColumns;

public final class FeedReaderContract {

    private FeedReaderContract(){

    }

    public static class FeedEntry implements BaseColumns {

        public static final String TABLE_NAME ="Entry";
        public static final String COLUMN_NAME_TITLE ="title";
        public static final String COLUMN_NAME_SUBTITLE ="subtitle";
    }



}
