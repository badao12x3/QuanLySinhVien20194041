package com.example.qunlsinhvin20194041;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class StudentDataHelper extends SQLiteOpenHelper {
    private final String TAG = "DBManager";
    private static final String DATABASE_NAME = "students_manager";
    private static final String TABLE_NAME = "students";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String BIRTHDAY = "birthday";
    private static final String EMAIL = "email";
    private static int VERSION = 1;

    private Context context;

    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            NAME + " TEXT, " +
            EMAIL + " TEXT, " +
            BIRTHDAY + " TEXT)";
    public StudentDataHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
        this.context=context;
    }

    public StudentDataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public StudentDataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public StudentDataHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, student.getName());
        values.put(BIRTHDAY, student.getBirthday());
        values.put(EMAIL, student.getEmail());

        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d(TAG, "addStudent Successfuly");
    }
    public List<Student> getAllStudent() {
        List<Student> listStudent = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setMssv(cursor.getInt(0));
                student.setName(cursor.getString(1)+"");
                student.setEmail(cursor.getString(2));
                student.setBirthday(cursor.getString(3));
                listStudent.add(student);

            } while (cursor.moveToNext());
        }
        db.close();
        return listStudent;
    }
}
