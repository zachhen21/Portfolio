package edu.cvtc.zhendrickson.gamebank;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import edu.cvtc.zhendrickson.gamebank.GameDatabaseContract.GameInfoEntry;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String EXTRA_MESSAGE = "edu.cvtc.zhendrickson.aboutme.extra.MESSAGE";
    private String mGameMessage;

    private GameOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerItems;
    private LinearLayoutManager mGamesLayoutManager;
    private GameRecyclerAdapter mGameRecyclerAdapter;
    public static final int ITEM_GAMES = 0;
    public static final int LOADER_COURSES = 0;
    private boolean mIsCreated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbOpenHelper = new GameOpenHelper(this);

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        DataManager.loadFromDatabase(mDbOpenHelper);

        mRecyclerItems = (RecyclerView) findViewById(R.id.list_items);
        mGamesLayoutManager = new LinearLayoutManager(this);

        List<GameInfo> games = DataManager.getInstance().getGames();

        mGameRecyclerAdapter = new GameRecyclerAdapter(this, null);

        displayGames();
    }

    @Override
    protected void onResume() {
        super.onResume();

        LoaderManager.getInstance(this).restartLoader(LOADER_COURSES, null, this);
    }

    private void loadGames() {
        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

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

        mGameRecyclerAdapter.changeCursor(gameCursor);
    }

    private void displayGames() {
        mRecyclerItems.setLayoutManager(mGamesLayoutManager);
        mRecyclerItems.setAdapter(mGameRecyclerAdapter);
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

        case R.id.action_add_game:
            Intent intent = new Intent(MainActivity.this, AddGameActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mGameMessage);
            startActivity(intent);
            return true;
        case R.id.action_wishlist:
            Intent intent2 = new Intent(MainActivity.this, WishlistActivity.class);
            intent2.putExtra(EXTRA_MESSAGE, mGameMessage);
            startActivity(intent2);
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {

        CursorLoader loader = null;
        if (id == LOADER_COURSES) {
            loader = new CursorLoader(this) {
                @Override
                public Cursor loadInBackground() {
                    mIsCreated = true;

                    SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();

                    String[] gameColumns = {
                            GameInfoEntry.COLUMN_GAME_TITLE,
                            GameInfoEntry.COLUMN_GAME_PRICE,
                            GameInfoEntry.COLUMN_GAME_CONSOLE,
                            GameInfoEntry.COLUMN_GAME_DATE,
                            GameInfoEntry.COLUMN_GAME_CONDITION,
                            GameInfoEntry.COLUMN_GAME_OWNED,
                            GameInfoEntry._ID};

                    String selection = "game_owned = 'Yes'";

                    String gameOrderBy = GameInfoEntry.COLUMN_GAME_TITLE;

                    return db.query(GameInfoEntry.TABLE_NAME, gameColumns, selection, null, null, null, gameOrderBy);
                }
            };
        }
        return loader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

        if (loader.getId() == LOADER_COURSES && mIsCreated) {
            mGameRecyclerAdapter.changeCursor(data);
            mIsCreated = false;
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

        if (loader.getId() == LOADER_COURSES) {
            mGameRecyclerAdapter.changeCursor(null);
        }

    }
}