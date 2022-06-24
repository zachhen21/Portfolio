package edu.cvtc.zhendrickson.gamebank;

import android.provider.BaseColumns;

public final class GameDatabaseContract {

    //Private Constructor
    private GameDatabaseContract() {}

    public static final class GameInfoEntry implements BaseColumns {
        //Constants for table values
        public static final String TABLE_NAME = "game_info";
        public static final String COLUMN_GAME_TITLE = "game_title";
        public static final String COLUMN_GAME_PRICE = "game_price";
        public static final String COLUMN_GAME_CONSOLE = "game_console";
        public static final String COLUMN_GAME_DATE = "game_date";
        public static final String COLUMN_GAME_CONDITION = "game_condition";
        public static final String COLUMN_GAME_OWNED = "game_owned";

        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String  SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME +
                        "(" + COLUMN_GAME_TITLE + ")";

        //constant for creating table
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_GAME_TITLE + " TEXT NOT NULL, " +
                        COLUMN_GAME_PRICE + " TEXT, " +
                        COLUMN_GAME_CONSOLE + " TEXT, " +
                        COLUMN_GAME_DATE + " TEXT, " +
                        COLUMN_GAME_CONDITION + " TEXT, " +
                        COLUMN_GAME_OWNED + " TEXT)";
    }
}
