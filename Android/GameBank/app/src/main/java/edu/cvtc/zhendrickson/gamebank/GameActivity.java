package edu.cvtc.zhendrickson.gamebank;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import edu.cvtc.zhendrickson.gamebank.GameDatabaseContract.GameInfoEntry;

public class GameActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String GAME_ID = "edu.cvtc.zhendrickson.gamebank.GAME_ID";

    public static final String ORIGINAL_GAME_TITLE = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_TITLE";
    public static final String ORIGINAL_GAME_PRICE = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_PRICE";
    public static final String ORIGINAL_GAME_CONSOLE = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_CONSOLE";
    public static final String ORIGINAL_GAME_DATE = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_DATE";
    public static final String ORIGINAL_GAME_CONDITION  = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_CONDITION";
    public static final String ORIGINAL_GAME_OWNED = "edu.cvtc.zhendrickson.gamebank.ORIGINAL_GAME_CONDITION";

    public static final int ID_NOT_SET = -1;

    private GameInfo mGame = new GameInfo(0, "", "", "", "", "", "");

    //Member variables
    private boolean mIsNewGame;
    private boolean mIsCancelling;
    private int mGameId;
    private int mGameTitlePosition;
    private int mGamePricePosition;
    private int mGameConsolePosition;
    private int mGameDatePosition;
    private int mGameConditionPosition;
    private int mGameOwnedPosition;
    private String mOriginalGameTitle;
    private String mOriginalGamePrice;
    private String mOriginalGameConsole;
    private String mOriginalGameDate;
    private String mOriginalGameCondition;
    private String gameOwned;
    private String mOriginalGameOwned;

    //Member objects
    private EditText mTextGameTitle;
    private EditText mTextGamePrice;
    private EditText mTextGameConsole;
    private EditText mTextGameDate;
    private EditText mTextGameCondition;
    private GameOpenHelper mDbOpenHelper;
    private Cursor mGameCursor;

    public static final int LOADER_GAMES = 0;

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    public void pullFromInput(String gameTitle, String gamePrice, String gameConsole, String gameDate, String gameCondition) {
        createNewGame();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mDbOpenHelper = new GameOpenHelper(this);
        readDisplayStateValues();

        if (savedInstanceState == null) {
            saveOriginalGameValues();
        } else {
            restoreOriginalCourseValues(savedInstanceState);
        }

        mTextGameTitle = findViewById(R.id.text_game_title);
        mTextGamePrice = findViewById(R.id.text_game_price);
        mTextGameConsole = findViewById(R.id.text_game_console);
        mTextGameDate = findViewById(R.id.text_game_date);
        mTextGameCondition = findViewById(R.id.text_game_condition);

        if(!mIsNewGame) {
            LoaderManager.getInstance(this).initLoader(LOADER_GAMES, null, this);
        }
    }

    private void loadGameData() {
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

        String selection = GameInfoEntry._ID + " = ?";
        String[] selectionArgs = {Integer.toString(mGameId)};

        String[] gameColumns = {
                GameInfoEntry.COLUMN_GAME_TITLE,
                GameInfoEntry.COLUMN_GAME_PRICE,
                GameInfoEntry.COLUMN_GAME_CONSOLE,
                GameInfoEntry.COLUMN_GAME_DATE,
                GameInfoEntry.COLUMN_GAME_CONDITION};

        mGameCursor = db.query(GameInfoEntry.TABLE_NAME, gameColumns, selection, selectionArgs, null, null, null);

        mGameTitlePosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_TITLE);
        mGamePricePosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_PRICE);
        mGameConsolePosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_CONSOLE);
        mGameDatePosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_DATE);
        mGameConditionPosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_CONDITION);

        mGameCursor.moveToNext();

        displayGame();
    }

    private void displayGame() {
        String gameTitle = mGameCursor.getString(mGameTitlePosition);
        String gamePrice = mGameCursor.getString(mGamePricePosition);
        String gameConsole = mGameCursor.getString(mGameConsolePosition);
        String gameDate = mGameCursor.getString(mGameDatePosition);
        String gameCondition = mGameCursor.getString(mGameConditionPosition);

        mTextGameTitle.setText(gameTitle);
        mTextGamePrice.setText(gamePrice);
        mTextGameConsole.setText(gameConsole);
        mTextGameDate.setText(gameDate);
        mTextGameCondition.setText(gameCondition);

    }

    private void restoreOriginalCourseValues(Bundle savedInstanceState) {
        mOriginalGameTitle = savedInstanceState.getString(ORIGINAL_GAME_TITLE);
        mOriginalGamePrice = savedInstanceState.getString(ORIGINAL_GAME_PRICE);
        mOriginalGameConsole = savedInstanceState.getString(ORIGINAL_GAME_CONSOLE);
        mOriginalGameDate = savedInstanceState.getString(ORIGINAL_GAME_DATE);
        mOriginalGameCondition = savedInstanceState.getString(ORIGINAL_GAME_CONDITION);
    }

    private void saveOriginalGameValues() {
        if (!mIsNewGame) {
            mOriginalGameTitle = mGame.getTitle();
            mOriginalGamePrice = mGame.getPrice();
            mOriginalGameConsole = mGame.getConsole();
            mOriginalGameDate = mGame.getDate();
            mOriginalGameCondition = mGame.getCondition();
        }
    }

    private void readDisplayStateValues() {
        Intent intent = getIntent();
        mGameId = intent.getIntExtra(GAME_ID, ID_NOT_SET);

        mIsNewGame = mGameId == ID_NOT_SET;
        if (mIsNewGame) {
            createNewGame();
        }
    }

    private void createNewGame() {

        ContentValues values = new ContentValues();

        values.put(GameInfoEntry.COLUMN_GAME_TITLE, "");
        values.put(GameInfoEntry.COLUMN_GAME_PRICE, "");
        values.put(GameInfoEntry.COLUMN_GAME_CONSOLE, "");
        values.put(GameInfoEntry.COLUMN_GAME_DATE, "");
        values.put(GameInfoEntry.COLUMN_GAME_CONDITION, "");

        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        mGameId = (int)db.insert(GameInfoEntry.TABLE_NAME, null, values);
    }

    private void deleteGameFromDatabase() {
        String selection = GameInfoEntry._ID + " = ?";
        String[] selectionArgs = {Integer.toString(mGameId)};

        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        db.delete(GameInfoEntry.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mIsCancelling) {
            if (mIsNewGame) {
                deleteGameFromDatabase();
            } else {
                storePreviousGameValues();
            }
        } else {
            saveGame();
        }
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        CursorLoader loader = null;

        if (id == LOADER_GAMES) {
            loader = createLoaderGames();
        }
        return loader;
    }

    private CursorLoader createLoaderGames() {
        return new CursorLoader(this) {
            @Override
            public Cursor loadInBackground() {
                SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

                String selection = GameInfoEntry._ID + " = ?";
                String[] selectionArgs = {Integer.toString(mGameId)};

                String[] gameColumns = {
                        GameInfoEntry.COLUMN_GAME_TITLE,
                        GameInfoEntry.COLUMN_GAME_PRICE,
                        GameInfoEntry.COLUMN_GAME_CONSOLE,
                        GameInfoEntry.COLUMN_GAME_DATE,
                        GameInfoEntry.COLUMN_GAME_CONDITION};

                return db.query(GameInfoEntry.TABLE_NAME, gameColumns, selection, selectionArgs, null, null , null);
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        if (loader.getId() == LOADER_GAMES) {
            loadFinishedGames(data);
        }

    }

    private void loadFinishedGames(Cursor data) {
        mGameCursor = data;

        mGameTitlePosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_TITLE);
        mGamePricePosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_PRICE);
        mGameConsolePosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_CONSOLE);
        mGameDatePosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_DATE);
        mGameConditionPosition = mGameCursor.getColumnIndex(GameInfoEntry.COLUMN_GAME_CONDITION);

        mGameCursor.moveToNext();

        displayGame();

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        if (loader.getId() == LOADER_GAMES) {
            if (mGameCursor != null) {
                mGameCursor.close();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_cancel) {
            mIsCancelling = true;
            finish();
        }
        if (id == R.id.action_delete) {
            this.deleteGameFromDatabase();
            finish();
        }

        return super.onOptionsItemSelected(item);

    }

    private void saveGameToDatabase(String gameTitle, String gamePrice, String gameConsole, String gameDate, String gameCondition) {
        String selection = GameInfoEntry._ID + " = ?";

        String[] selectionArgs = {Integer.toString(mGameId)};

        ContentValues values = new ContentValues();
        values.put(GameInfoEntry.COLUMN_GAME_TITLE, gameTitle);
        values.put(GameInfoEntry.COLUMN_GAME_PRICE, gamePrice);
        values.put(GameInfoEntry.COLUMN_GAME_CONSOLE, gameConsole);
        values.put(GameInfoEntry.COLUMN_GAME_DATE, gameDate);
        values.put(GameInfoEntry.COLUMN_GAME_CONDITION, gameCondition);

        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        db.update(GameInfoEntry.TABLE_NAME, values, selection, selectionArgs);
    }

    private void storePreviousGameValues() {
        mGame.setTitle(mOriginalGameTitle);
        mGame.setPrice(mOriginalGamePrice);
        mGame.setConsole(mOriginalGameConsole);
        mGame.setDate(mOriginalGameDate);
        mGame.setCondition(mOriginalGameCondition);
    }

    private void saveGame() {
        String gameTitle = mTextGameTitle.getText().toString();
        String gamePrice = mTextGamePrice.getText().toString();
        String gameConsole = mTextGameConsole.getText().toString();
        String gameDate = mTextGameDate.getText().toString();
        String gameCondition = mTextGameCondition.getText().toString();

        saveGameToDatabase(gameTitle, gamePrice, gameConsole,gameDate, gameCondition);
    }
}