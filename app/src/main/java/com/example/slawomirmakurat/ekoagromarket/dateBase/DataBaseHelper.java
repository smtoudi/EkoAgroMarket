package com.example.slawomirmakurat.ekoagromarket.dateBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by slawomir.makurat on 2017-03-23.
 */


public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "user_login.db";
    public static final int DB_VERSION = 1;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "id";

    public static final String COLUMN_LOGIN = "login";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_CONPASS = "confirmpassword";
    public static final String COLUMN_POSTCOD = "post_code";
    public static final String COLUMN_PHONE = "phone";

//        public static final String CREATE_TABLE_USERS = "CREATE TABLE"  + USER_TABLE + {
//                COLUMN_ID + "INTEGER PRIMARY KEY "
//        }


    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}