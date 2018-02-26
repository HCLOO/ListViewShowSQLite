package com.example.think.listviewshowsqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.widget.BaseAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyOpenSqlHelp myDatebaseHelper;
    List<DataStore> informationList ;
    Button bnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatebaseHelper = new MyOpenSqlHelp(this, "AdministratorsInformation.db", null, 1);
        SQLiteDatabase db = myDatebaseHelper.getWritableDatabase();
        for(int i=0;i<10;i++){
            ContentValues values = new ContentValues();
            values.put("Name", "Administrator"+i);
            values.put("Sex", "男");
            values.put("Phone", "1562508420"+i);
            db.insert("AdministratorsData", null, values);
        }
        informationList = new ArrayList<DataStore>();
        bnt=(Button)findViewById(R.id.button);
        //实例化以上控件
        bnt.setOnClickListener((OnClickListener) this);
        //给按钮添加点击事件
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "数据成功添加并显示", Toast.LENGTH_SHORT).show();
        SQLiteDatabase db = myDatebaseHelper.getWritableDatabase();
        Cursor cursor = db.query("AdministratorsData", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String sex = cursor.getString(cursor.getColumnIndex("Sex"));
            String phone = cursor.getString(cursor.getColumnIndex("Phone"));
            DataStore praviteInfo = new DataStore(name, sex, phone);
            informationList.add(praviteInfo);
        }
        //拿到listveiw对象
        ListView lv = (ListView) findViewById(R.id.listView);
        //设置适配器
        lv.setAdapter(new MyAapter());
    }
    //适配器类
    class MyAapter extends BaseAdapter {

        //获取集合中有多少条元素,由系统调用
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return informationList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }
        //由系统调用，返回一个view对象作为listview的条目
        /*
         * position：本次getView方法调用所返回的view对象在listView中处于第几个条目，position的值就为多少
         * */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(MainActivity.this);
            tv.setTextSize(18);
            //获取集合中的元素
            DataStore praviteInfo = informationList.get(position);
            tv.setText(praviteInfo.toString());
            return tv;
        }
    }
}
