package com.example.slawomirmakurat.ekoagromarket.dateBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by slawomir.makurat on 2017-03-23.
 */

public class DataBaseHelper {
    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+"TEMPLATE");
        onCreate(db);
    }



}