package com.example.xiago;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME ="userDetails.db";

    public DatabaseHelper(Context context){
        super(context, "userDetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key, mobile TEXT, password TEXT, cfmPassword TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
    }

    public Boolean insertData(String username, String mobileNo, String password, String cfmPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("mobile", mobileNo);
        values.put("password", password);
        values.put("cfmPassword", cfmPassword);

        long result = db.insert("users", null, values);
        if(result == -1) {
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkUsername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkUsernamePwd(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?", new String[]{username, password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean updateData(String username, String mobileNo, String password, String cfmPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("mobile", mobileNo);
        values.put("password", password);
        values.put("cfmPassword", cfmPassword);

        Cursor cursor = db.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            long result = db.update("users", values, "username=?", new String[]{username});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteData(String username){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
        {
            long result = db.delete("users", "username=?", new String[] {username});
                if(result==-1){
                    return false;
                }        else{
                    return true;
                }
            }       else{
                return false;
            }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users", null);
        return cursor;
    }
    /*public ArrayList<UserDetails> readUsers(){
        String selectQuery = "SELECT  * FROM users";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<UserDetails> userDetailsArrayList = new ArrayList<>();
        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return userDetailsArrayList;
    }*/
}
