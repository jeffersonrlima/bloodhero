package vamp.ifpiprojetos.com.vamp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vamp.ifpiprojetos.com.vamp.models.Donor;
import vamp.ifpiprojetos.com.vamp.models.Hospital;

/**
 * Created by Jefferson Lima on 28/03/2017.
 */

public class HospitalDb extends SQLiteOpenHelper{

    public HospitalDb(Context context) {
        super(context, "Hospital", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Hospital(id INTEGER PRIMARY KEY, name TEXT NOT NULL, address TEXT NOT NULL," +
                " phone TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Não modifiquei o bd ainda
    }


    public void insertHospital(Hospital hospital){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues elements = getContentValuesHospital(hospital);
        db.insert("Hospital", null, elements);
    }

    private ContentValues getContentValuesHospital(Hospital hospital){
        ContentValues elements = new ContentValues();
        elements.put("name", hospital.getName());
        elements.put("address", hospital.getAddress());
        elements.put("phone", hospital.getPhone());
        return elements;
    }

    public List<Hospital> listHospital(){
        String sql = "SELECT * FROM Hospital";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<Hospital> hospitals = new ArrayList<Hospital>();
        while (cursor.moveToNext()){
            Hospital hospital = new Hospital();
            hospital.setId(cursor.getLong(cursor.getColumnIndex("id")));
            hospital.setName(cursor.getString(cursor.getColumnIndex("name")));
            hospital.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            hospital.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            hospitals.add(hospital);
        }
        cursor.close();
        return hospitals;
    }

    public void deleteHospital(Hospital hospital) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {hospital.getId().toString()};
        db.delete("Hospital", "id = ?", params);
    }

}
