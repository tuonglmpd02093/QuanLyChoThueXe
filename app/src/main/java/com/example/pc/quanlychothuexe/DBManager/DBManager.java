package com.example.pc.quanlychothuexe.DBManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    private final String TAG = "DBManager";
    private static final String DATABASE_NAME = "KHACHHANG";
    private static final String TABLE_NAME = "khachhang";
    private static final String ID = "id";
    private static final String CODE = "code";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String ADDRESS = "address";
    private static final String XE = "xe";
    private static final String BIENSOXE = "biensoxe";
    private static final String MAUXE = "mauxe";
    private static int VERSION = 2;

    private Context context;
    String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" + ID + " integer primary key,"
            + CODE + " TEXT,"
            + NAME + " TEXT,"
            + EMAIL + " TEXT,"
            + PHONE + " TEXT,"
            + ADDRESS + " TEXT,"
            + XE + " TEXT,"
            + BIENSOXE + " TEXT,"
            + MAUXE + " TEXT);";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
        Log.d(TAG, "onCreate: ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
        Log.d(TAG, "onUpgrade: ");
    }

    public void addKhachHang(KhachHang kh) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CODE, kh.getCode());
        values.put(NAME, kh.getName());
        values.put(EMAIL, kh.getEmail());
        values.put(PHONE, kh.getPhone());
        values.put(ADDRESS, kh.getAddress());
        values.put(XE, kh.getXe());
        values.put(BIENSOXE, kh.getBiensoxe());
        values.put(MAUXE, kh.getMauxe());

        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d(TAG, "Add Employees Successfuly: ");

    }

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> listKH = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(cursor.getInt(0));
                khachHang.setCode(cursor.getString(1));
                khachHang.setName(cursor.getString(2));
                khachHang.setEmail(cursor.getString(3));
                khachHang.setPhone(cursor.getString(4));
                khachHang.setAddress(cursor.getString(5));
                khachHang.setXe(cursor.getString(6));
                khachHang.setBiensoxe(cursor.getString(7));
                khachHang.setMauxe(cursor.getString(8));
                listKH.add(khachHang);

            } while (cursor.moveToNext());
        }
        db.close();
        return listKH;
    }

    public int deleteKhachHang(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, ID + "=?", new String[]{String.valueOf(id)});
    }
}