package com.example.genii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CARDS_TABLE = "CARDS_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_QUESTION = "QUESTION";
    public static final String COLUMN_ANSWER = "ANSWER";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "genii.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createCardTable ="CREATE TABLE " + CARDS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_QUESTION +" TEXT, " + COLUMN_ANSWER +" TEXT)";

        db.execSQL(createCardTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersion) {
        return;
    }

    public boolean addCard(CardModel card) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_QUESTION, card.getQuestion());
        cv.put(COLUMN_ANSWER, card.getAnswer());

        long insert = db.insert(CARDS_TABLE, null, cv);

        return insert != -1;
    }

    public List<CardModel> getAllCards() {
        List<CardModel> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + CARDS_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String question = cursor.getString(1);
                String answer = cursor.getString(2);

                CardModel card = new CardModel(id, question, answer);
                returnList.add(card);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
