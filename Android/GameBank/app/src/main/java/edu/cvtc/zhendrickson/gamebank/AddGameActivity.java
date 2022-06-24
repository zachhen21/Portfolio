package edu.cvtc.zhendrickson.gamebank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import edu.cvtc.zhendrickson.gamebank.GameDatabaseContract.GameInfoEntry;

public class AddGameActivity extends AppCompatActivity {

    private GameOpenHelper mDbOpenHelper;
    private int mGameId;

    private EditText mTextGameTitle;
    private EditText mTextGamePrice;
    private EditText mTextGameConsole;
    private EditText mTextGameDate;
    private EditText mTextGameCondition;
    private Button  mButton;

    private String gameTitle;
    private String gamePrice;
    private String gameConsole;
    private String gameDate;
    private String gameCondition;
    private String gameOwned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

        mDbOpenHelper = new GameOpenHelper(this);

        mButton = findViewById(R.id.library_button);

        Switch sw = (Switch) findViewById(R.id.switch_owned);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    gameOwned = "Yes";
                    Toast.makeText(getApplicationContext(),gameOwned,Toast.LENGTH_SHORT).show();
                } else {
                    // The toggle is disabled
                    gameOwned = "No";
                    Toast.makeText(getApplicationContext(),gameOwned,Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mTextGameTitle = findViewById(R.id.title_edit_text);
                mTextGamePrice = findViewById(R.id.price_edit_text);
                mTextGameConsole = findViewById(R.id.console_edit_text);
                mTextGameDate = findViewById(R.id.date_edit_text);
                mTextGameCondition = findViewById(R.id.condition_edit_text);

                gameTitle = mTextGameTitle.getText().toString();
                gamePrice = "$" + mTextGamePrice.getText().toString();
                gameConsole = mTextGameConsole.getText().toString();
                gameDate = mTextGameDate.getText().toString();
                gameCondition = mTextGameCondition.getText().toString();

                if (gameTitle == "" || gamePrice == "$" || gameConsole == "" || gameDate == "" || gameCondition == "" || gameOwned == ""){
                    Toast toast = Toast.makeText(getApplicationContext(),"Please enter values", Toast.LENGTH_SHORT);
                    toast.show();
                } else {

                    createNewGame();

                    saveGameToDatabase(gameTitle, gamePrice, gameConsole, gameDate, gameCondition, gameOwned);

                    Intent intent = new Intent(AddGameActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void saveGameToDatabase(String gameTitle, String gamePrice, String gameConsole, String gameDate, String gameCondition, String gameOwned) {
        String selection = GameInfoEntry._ID + " = ?";

        String[] selectionArgs = {Integer.toString(mGameId)};

        ContentValues values = new ContentValues();
        values.put(GameInfoEntry.COLUMN_GAME_TITLE, gameTitle);
        values.put(GameInfoEntry.COLUMN_GAME_PRICE, gamePrice);
        values.put(GameInfoEntry.COLUMN_GAME_CONSOLE, gameConsole);
        values.put(GameInfoEntry.COLUMN_GAME_DATE, gameDate);
        values.put(GameInfoEntry.COLUMN_GAME_CONDITION, gameCondition);
        values.put(GameInfoEntry.COLUMN_GAME_OWNED, gameOwned);

        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        db.update(GameInfoEntry.TABLE_NAME, values, selection, selectionArgs);
    }

    private void createNewGame() {

        ContentValues values = new ContentValues();

        values.put(GameInfoEntry.COLUMN_GAME_TITLE, "");
        values.put(GameInfoEntry.COLUMN_GAME_PRICE, "");
        values.put(GameInfoEntry.COLUMN_GAME_CONSOLE, "");
        values.put(GameInfoEntry.COLUMN_GAME_DATE, "");
        values.put(GameInfoEntry.COLUMN_GAME_CONDITION, "");
        values.put(GameInfoEntry.COLUMN_GAME_OWNED, "");

        SQLiteDatabase db = mDbOpenHelper.getWritableDatabase();

        mGameId = (int)db.insert(GameInfoEntry.TABLE_NAME, null, values);
    }
}