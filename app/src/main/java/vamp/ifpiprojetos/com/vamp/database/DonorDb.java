package vamp.ifpiprojetos.com.vamp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import vamp.ifpiprojetos.com.vamp.models.Donor;

/**
 * Created by Jefferson Lima on 27/03/2017.
 */

public class DonorDb extends SQLiteOpenHelper {
    public DonorDb(Context context) {
        super(context, "Donor", null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Donor(id INTEGER PRIMARY KEY, name TEXT NOT NULL, genre TEXT NOT NULL, address TEXT NOT NULL," +
                "phone TEXT NOT NULL, bloodType TEXT NOT NULL, donates REAL);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertDonor(Donor donor){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues elements = getContentValuesDonor(donor);
        db.insert("Donor", null, elements);
    }

    private ContentValues getContentValuesDonor(Donor donor){
        ContentValues elements = new ContentValues();
        elements.put("name", donor.getName());
        elements.put("genre", donor.getGenre());
        elements.put("address", donor.getAddress());
        elements.put("phone", donor.getPhone());
        elements.put("bloodType", donor.getBloodType());
        elements.put("donates", donor.getDonates());
        return elements;
    }

    public List<Donor> listDonor(){
        String sql = "SELECT * FROM Donor";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<Donor> donors = new ArrayList<Donor>();
        while (cursor.moveToNext()){
            Donor donor = new Donor();
            donor.setId(cursor.getLong(cursor.getColumnIndex("id")));
            donor.setName(cursor.getString(cursor.getColumnIndex("name")));
            donor.setGenre(cursor.getString(cursor.getColumnIndex("genre")));
            donor.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            donor.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            donor.setBloodType(cursor.getString(cursor.getColumnIndex("bloodType")));
            donor.setDonates(cursor.getInt(cursor.getColumnIndex("donates")));
            donors.add(donor);
        }
        cursor.close();
        return donors;
    }

    public void deleteDonor(Donor donor) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {donor.getId().toString()};
        db.delete("Donor", "id = ?", params);
    }

    public void donation(Donor donor){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValuesDonor(donor);
        String[] params = {donor.getId().toString()};
        db.update("Donor", dados, "id = ?", params);
    }

    public void update(Donor donor) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = getContentValuesDonor(donor);
        String[] params = {donor.getId().toString()};
        db.update("Donor", dados, "id = ?", params);
    }
}
