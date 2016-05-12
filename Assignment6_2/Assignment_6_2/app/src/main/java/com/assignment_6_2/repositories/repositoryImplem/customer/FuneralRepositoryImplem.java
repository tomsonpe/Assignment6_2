package com.assignment_6_2.repositories.repositoryImplem.customer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.assignment_6_2.repositories.repository.customer.FuneralRepository;
import com.assignment_6_2.appConfig.database.DBConstants;
import com.assignment_6_2.domain.customer.Funerals;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Phinda Encore Tomson on 4/18/2016.
 */
public class FuneralRepositoryImplem extends SQLiteOpenHelper implements FuneralRepository {

    public static final String TABLE_NAME="funerals";
    private SQLiteDatabase database;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_NUMBER="no";
    public static final String COLUMN_NAME="name";

    public static String DATABASE_CREATE=" CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NUMBER + " TEXT UNIQUE NOT NULL , "
            + COLUMN_NAME + " TEXT UNIQUE NOT NULL);";

    public FuneralRepositoryImplem(Context context){
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        database=this.getWritableDatabase();
    }

    public void close(){
        this.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    @Override
    public Funerals findById(Long id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NUMBER,COLUMN_NAME},COLUMN_ID+"=?",new String[]{String.valueOf(id)},null,null,null,null);

        if(cursor.moveToFirst()){
            final Funerals funeral=new Funerals.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .no(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .build();
            return funeral;
        }else{
            return null;
        }
    }
    @Override
    public Funerals save(Funerals entity) throws SQLException {
        open();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,entity.getId());
        values.put(COLUMN_NUMBER,entity.getNo());
        values.put(COLUMN_NAME,entity.getName());

        long id=database.insertOrThrow(TABLE_NAME, null, values);
        Funerals insertedEntity=new Funerals.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }
    @Override
    public Funerals update(Funerals entity) throws SQLException {
        open();
        ContentValues values=new ContentValues();
        values.put(COLUMN_ID,entity.getId());
        values.put(COLUMN_NUMBER,entity.getNo());
        values.put(COLUMN_NAME,entity.getName());

        database.update(TABLE_NAME,
                values,COLUMN_ID + " =? ",new String[]{String.valueOf(entity.getId())});
        return entity;
    }
    @Override
    public Funerals delete(Funerals entity) throws SQLException {
        open();
        database.delete(TABLE_NAME,COLUMN_ID+ " =? ",new String[]{String.valueOf(entity.getId())});
        return entity;

    }
    @Override
    public Set<Funerals> findAll() throws SQLException {
        SQLiteDatabase db=this.getReadableDatabase();
        Set<Funerals> funeral=new HashSet<>();
        open();
        Cursor cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                final Funerals funerals =new Funerals.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .no(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                funeral.add(funerals);
            }while(cursor.moveToNext());
        }
        return funeral;
    }
    @Override
    public int deleteAll() throws SQLException {
        open();
        int rowsDeleted=database.delete(TABLE_NAME,null,null);
        close();

        return rowsDeleted;
    }
}
