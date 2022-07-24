package com.example.instagram18.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteLoginHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "account.db";
    private static int DATABASE_VERSION = 1;
    public SQLiteLoginHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE accounts(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT," +
                "password TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        super.onOpen(sqLiteDatabase);
    }

}
