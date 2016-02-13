package com.zhangtao.testsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by zhangtao on 16/2/13.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    private Context mContext;

    /**
     * 构造方法
     * @param context
     * @param name 数据库名字(不是表名)
     * @param factory
     * @param version 版本号
     */
    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    //建表语句
    public static final String CREATE_RECENT_TABLE = "create table Recent(" +
            "id integer primary key autoincrement," +
            "key text)";

    //创建一张表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RECENT_TABLE);
        Toast.makeText(mContext, "create table Succeed", Toast.LENGTH_SHORT).show();
    }

    /**
     * 更新数据库,也就是说当你想再建一张表的时候,你需要在这方法里将所有表drop掉,然后再一一创建,
     * 并且在初始化这个Helper的时候,数据库版本填比之前大的数.这样就可以更新一个数据库.
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //eg:
        // db.execSQL("drop table if exist Recent");
        //onCreate(db);
    }
}
