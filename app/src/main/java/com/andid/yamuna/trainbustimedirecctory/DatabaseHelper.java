package com.andid.yamuna.trainbustimedirecctory;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Dbname="MyDb.db";
    public static final String Tablename="Bus";
    public static final String col1="id";
    public static final String col2="buscode";
    public static final String col3="name";
    public static final String col4="route";
    public static final String col5="stops";

    public DatabaseHelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+Tablename+"("+col1+" integer primary key autoincrement ,"+col2+" text,"+col3+" text,"+col4+" text,"+col5+" text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop table if exists "+Tablename;
        db.execSQL(query);
        onCreate(db);
    }
    public Boolean insertdata(String Buscode,String Name,String Route,String Stops)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,Buscode);
        contentValues.put(col3,Name);
        contentValues.put(col4,Route);
        contentValues.put(col5,Stops);

        long Status=db.insert(Tablename,null,contentValues);
        if (Status==-1){
            return false;

        }
        else {
            return true;
        }
    }
}
