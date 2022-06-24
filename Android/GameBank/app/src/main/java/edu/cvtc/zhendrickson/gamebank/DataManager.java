package edu.cvtc.zhendrickson.gamebank;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.cvtc.zhendrickson.gamebank.GameDatabaseContract.GameInfoEntry;

public class DataManager {
    //Member attributes
    private static DataManager ourInstance = null;
    private List<GameInfo> mGames = new ArrayList<>();

    public static DataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
        }
        return ourInstance;
    }

    public List<GameInfo> getGames() {
        return mGames;
    }

    private static void loadGamesFromDatabase(Cursor cursor) {

        //retrieve positions of fields in database
        int listTitlePosition = cursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_TITLE);
        int listPricePosition = cursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_PRICE);
        int listConsolePosition = cursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_CONSOLE);
        int listDatePosition = cursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_DATE);
        int listConditionPosition = cursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_CONDITION);
        int listOwnedPosition = cursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_OWNED);
        int idPosition = cursor.getColumnIndex(GameInfoEntry._ID);

        //get instance to data manager and clear information from list
        DataManager dm = getInstance();
        dm.mGames.clear();

        //loop through rows and add new objects into list
        while (cursor.moveToNext()) {
            String listTitle = cursor.getString(listTitlePosition);
            String listPrice = cursor.getString(listPricePosition);
            String listConsole = cursor.getString(listConsolePosition);
            String listDate = cursor.getString(listDatePosition);
            String listCondition = cursor.getString(listConditionPosition);
            String listOwned = cursor.getString(listOwnedPosition);
            int id = cursor.getInt(idPosition);

            GameInfo list = new GameInfo(id, listTitle, listPrice, listConsole, listDate, listCondition, listOwned);

            dm.mGames.add(list);

        }
        cursor.close();
    }

    public static void loadFromDatabase(GameOpenHelper dbHelper) {
        //Opening database in read mode
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //create list of columns
        String[] gameColumns = {
          GameInfoEntry.COLUMN_GAME_TITLE,
          GameInfoEntry.COLUMN_GAME_PRICE,
          GameInfoEntry.COLUMN_GAME_CONSOLE,
          GameInfoEntry.COLUMN_GAME_DATE,
          GameInfoEntry.COLUMN_GAME_CONDITION,
          GameInfoEntry.COLUMN_GAME_OWNED,
          GameInfoEntry._ID};

        String gameOrderBy = GameInfoEntry.COLUMN_GAME_TITLE;

        final Cursor gameCursor = db.query(GameInfoEntry.TABLE_NAME, gameColumns, null, null, null, null, gameOrderBy);

        loadGamesFromDatabase(gameCursor);
    }

    public int createNewGame() {
        GameInfo game = new GameInfo(null, null, null, null, null, null );
        mGames.add(game);
        return mGames.size();
    }

    public void removeGame(int index) {
        mGames.remove(index);
    }
}
