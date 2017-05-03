package com.example.natasha.bookkeepingbuddy.model.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.natasha.bookkeepingbuddy.model.data.BookkeepingContract.*;
/**
 * Created by Natasha on 4/21/2017.
 */

public class BookkeepingDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bookkeeping.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_BOOKKEEPING_TABLE =
            "CREATE TABLE " +
            CategoryEntry.TABLE_NAME + " (" +
            CategoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            CategoryEntry.COLUMN_CATEGORY_NAME + " TEXT NOT NULL, " +
            CategoryEntry.COLUMN_UNIT + " TEXT NOT NULL" +
            "); ";

    public BookkeepingDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_BOOKKEEPING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoryEntry.TABLE_NAME);
        onCreate(db);
    }

}
