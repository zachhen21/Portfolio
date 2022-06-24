package edu.cvtc.zhendrickson.gamebank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import edu.cvtc.zhendrickson.gamebank.GameDatabaseContract.GameInfoEntry;

public class GameOpenHelper extends SQLiteOpenHelper {

    //Constants to hold name and version
    public static final String DATABASE_NAME = "GameBank_zhendrickson.db";
    public static final int DATABASE_VERSION = 1;

    public GameOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(GameInfoEntry.SQL_CREATE_TABLE);
        db.execSQL(GameInfoEntry.SQL_CREATE_INDEX1);

        GameDataWorker worker = new GameDataWorker(db);
        worker.insertGames();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
