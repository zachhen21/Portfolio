package edu.cvtc.zhendrickson.gamebank;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import edu.cvtc.zhendrickson.gamebank.GameDatabaseContract.GameInfoEntry;

public class GameDataWorker {
    //member attributes
    private SQLiteDatabase mDb;

    //Constructor
    public GameDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    private void insertGame(String title, String price, String console, String date, String condition, String owned) {
        ContentValues values = new ContentValues();
        values.put(GameInfoEntry.COLUMN_GAME_TITLE, title);
        values.put(GameInfoEntry.COLUMN_GAME_PRICE, price);
        values.put(GameInfoEntry.COLUMN_GAME_CONSOLE, console);
        values.put(GameInfoEntry.COLUMN_GAME_DATE, date);
        values.put(GameInfoEntry.COLUMN_GAME_CONDITION, condition);
        values.put(GameInfoEntry.COLUMN_GAME_OWNED, owned);

        long newRowId = mDb.insert(GameInfoEntry.TABLE_NAME, null, values);
    }

    public void insertGames() {
        insertGame("Pokemon Emerald", "$150.00", "Gameboy Advance", "02/22/17", "Used In Box", "Yes");
        insertGame("Mario 64", "$110.00", "Nintendo 64", "12/15/21", "Used In Box", "Yes");
        insertGame("Valheim", "$20.00", "Steam", "04/15/20", "Digital", "Yes");
    }
}
