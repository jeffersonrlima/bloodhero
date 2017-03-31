package vamp.ifpiprojetos.com.vamp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vamp.ifpiprojetos.com.vamp.models.Donor;
import vamp.ifpiprojetos.com.vamp.models.Receiver;

/**
 * Created by Jefferson Lima on 28/03/2017.
 */

public class ReceiverDb extends SQLiteOpenHelper {
    public ReceiverDb(Context context) {
        super(context, "Receiver", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Receiver(id INTEGER PRIMARY KEY, name TEXT NOT NULL, genre TEXT NOT NULL, address TEXT NOT NULL," +
                "phone TEXT NOT NULL, bloodType TEXT NOT NULL, donates INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Não modifiquei
    }

    public void insertReceiver(Receiver receiver){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues elements = getContentValuesReceiver(receiver);
        db.insert("Receiver", null, elements);
    }

    private ContentValues getContentValuesReceiver(Receiver receiver){
        ContentValues elements = new ContentValues();
        elements.put("name", receiver.getName());
        elements.put("genre", receiver.getGenre());
        elements.put("address", receiver.getAddress());
        elements.put("phone", receiver.getPhone());
        elements.put("bloodType", receiver.getBloodType());
        elements.put("donates", receiver.getDonates());
        return elements;
    }

    public List<Receiver> listReceiver(){
        String sql = "SELECT * FROM Receiver";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<Receiver> receivers = new ArrayList<Receiver>();
        while (cursor.moveToNext()){
            Receiver receiver = new Receiver();
            receiver.setId(cursor.getLong(cursor.getColumnIndex("id")));
            receiver.setName(cursor.getString(cursor.getColumnIndex("name")));
            receiver.setGenre(cursor.getString(cursor.getColumnIndex("genre")));
            receiver.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            receiver.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            receiver.setBloodType(cursor.getString(cursor.getColumnIndex("bloodType")));
            receiver.setDonates(cursor.getDouble(cursor.getColumnIndex("donates")));
            receivers.add(receiver);
        }
        cursor.close();
        return receivers;
    }



}
