package com.example.kos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqllogreg extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "logindb";

    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "user";

    public static final String KEY_ID = "id";

    public static final String KEY_USER_NAME = "username";

    public static final String KEY_EMAIL = "email";

    public static final String KEY_PASSWORD = "password";

    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_NAME + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_PASSWORD + " TEXT"
            + " ) ";

    public sqllogreg(Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL (SQL_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL (" DROP TABLE IF EXISTS " + TABLE_USERS);
    }

    public void addUser(user user) {
        SQLiteDatabase db = this.getWritableDatabase ();
        ContentValues values = new ContentValues ();

        values.put (KEY_USER_NAME, user.userName);
        values.put (KEY_EMAIL, user.email);
        values.put (KEY_PASSWORD, user.password);

        long todo_id = db.insert (TABLE_USERS, null, values);
    }

    public user Authenticate(user user) {
        SQLiteDatabase db = this.getReadableDatabase ();
        Cursor cursor = db.query (TABLE_USERS,
                new String[]{KEY_ID, KEY_USER_NAME, KEY_EMAIL, KEY_PASSWORD},
                KEY_EMAIL + "=?",
                new String[]{user.email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst () && cursor.getCount () > 0) {
            user user1 = new user (cursor.getString (0), cursor.getString (1), cursor.getString (2), cursor.getString (3));

            if (user.password.equalsIgnoreCase (user1.password)) {
                return user1;
            }
        }
        return null;
    }

    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase ();
        Cursor cursor = db.query (TABLE_USERS,
                new String[]{KEY_ID, KEY_USER_NAME, KEY_EMAIL, KEY_PASSWORD},
                KEY_EMAIL + "=?",
                new String[]{email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst () && cursor.getCount () > 0) {
            return true;
        }
        return false;
    }

}
