package com.example.a300cemassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class UserDatabase extends SQLiteOpenHelper {

    public UserDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE UserTable (userID, username, password)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public UserDatabase(Context context){
        super(context,"UserDB", null, 1);
    }

    public void addUser(Users users) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("userID", users.getUserID());
        contentValues.put("username", users.getUsername());
        contentValues.put("password", users.getPassword());

        long result = sqLiteDatabase.insert("UserTable", null, contentValues);

        if (result > 0){
            Log.d("dbhelper", "User Info Added");
        } else{
            Log.d("dbhelper", "User Creation Failed");
        }
        sqLiteDatabase.close();
    }
}
