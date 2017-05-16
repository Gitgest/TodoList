package com.example.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ejer on 16-05-2017.
 */

public class TaskDbHelper extends SQLiteOpenHelper {

    public TaskDbHelper(Context context){
        super(context, TaskContract.DB_NAME, null,TaskContract.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        /* Creates a String for making a table called tasks, containing entry ID as primary key
        *  and the title of each task */

        /* In pure SQL

         CREATE TABLE Tasks (
         _id INTEGER PRIMARY KEY AUTOINCREMENT,
         title TEXT NOT NULL
         );

        */
        String createTable = "CREATE TABLE" + TaskContract.TaskEntry.TABLE + " ( " +
                TaskContract.TaskEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT IS NOT NULL);";

        // sql execution method called on the db object.
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
        Drops the table tasks if it already exists.
        creates a new table.
        */
        db.execSQL(" DROP TABLE IF EXISTS " + TaskContract.TaskEntry.TABLE);
        onCreate(db);
    }
}
