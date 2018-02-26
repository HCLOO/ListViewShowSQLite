package com.example.think.listviewshowsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Think on 2017/12/3.
 */

public class MyOpenSqlHelp extends SQLiteOpenHelper {

    public static final String CREATE_GIRL = "create table AdministratorsData(_id integer primary key autoincrement" +
            ",Name char(20),Sex char(10),Phone char(20))";
    private Context mContext;
    public MyOpenSqlHelp(Context context, String name, CursorFactory factory,
                         int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_GIRL);
        /*Toast.makeText(mContext,"Create Successded",0).show();*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}