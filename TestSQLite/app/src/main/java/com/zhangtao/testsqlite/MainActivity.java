package com.zhangtao.testsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //建表按钮
    private Button creatTableBtn;

    private MySQLiteHelper mySQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySQLiteHelper=new MySQLiteHelper(this,"recent_data",null,1);

        initViews();
    }

    private void initViews() {
        creatTableBtn= (Button) findViewById(R.id.create_btn);

    }

    public void createTable(View view){
        mySQLiteHelper.getWritableDatabase();
    }
}
