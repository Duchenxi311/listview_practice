package com.example.listview_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    private ImageView photo;
    private TextView txt_intro;

    private String[] arrayDemo = {
            "20161707",
            "20161713",
            "20171591",
            "20171592",
            "20171616",
            "20171627",
            "20171641",
            "20171649",
            "20171650",
            "20171653",
            "20171654",
            "20171655",
            "20171656",
            "20171659",
            "20171664",
            "20171666",
            "20171667",
            "20171668",
            "20171669",
            "20171670",
            "20171679",
            "20171688",
            "20171697",
            "20171705",
            "20171707",
            "20171714",
            "20171717",
            "20171731",
            "20171742",
            "20175064",
            "20175980",
            "20175990"
    };

    private int imageId[] = {R.mipmap.emoji_kids02,R.mipmap.emoji_kids03,R.mipmap.emoji_kids04,R.mipmap.emoji_kids05,
            R.mipmap.emoji_kids06,R.mipmap.emoji_kids07,R.mipmap.emoji_kids08,R.mipmap.emoji_kids09,R.mipmap.emoji_kids10,R.mipmap.emoji_kids11, R.mipmap.emoji_kids12,
            R.mipmap.emoji_kids13,R.mipmap.emoji_kids14,R.mipmap.emoji_kids15,R.mipmap.emoji_kids16,R.mipmap.emoji_kids17,R.mipmap.emoji_kids18, R.mipmap.emoji_kids19,
            R.mipmap.emoji_kids20,R.mipmap.emoji_kids21,R.mipmap.emoji_kids22,R.mipmap.emoji_kids23,R.mipmap.emoji_kids24,R.mipmap.emoji_kids25,R.mipmap.emoji_kids26,
            R.mipmap.emoji_kids27,R.mipmap.emoji_kids28,R.mipmap.emoji_kids29,R.mipmap.emoji_kids30,R.mipmap.emoji_kids31,R.mipmap.emoji_kids32,R.mipmap.emoji_kids33};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        photo=findViewById(R.id.photo);
        txt_intro=findViewById(R.id.txt_intro);


        ListView listView = findViewById(R.id.list_view);
        ImageAdapter imageAdapter = new ImageAdapter();

        listView.setAdapter(imageAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =  new Intent();
                intent.putExtra("imageID",imageId[i]);
                intent.putExtra("studentName",arrayDemo[i]);
                intent.setClass(getApplicationContext(), Introduce.class);
                startActivity(intent);
            }
        });
    }
    public class ImageAdapter extends BaseAdapter {
        //得到listView中item的总数
        @Override
        public int getCount() {
// TODO Auto-generated method stub
            return arrayDemo.length;
        }


        @Override
        public String getItem(int position) {
// TODO Auto-generated method stub

            return arrayDemo[position];
        }


        @Override
        public long getItemId(int position) {
// TODO Auto-generated method stub
            return position;
        }


        //简单来说就是拿到单行的一个布局，然后根据不同的数值，填充主要的listView的每一个item
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
            View layout = View.inflate(MainActivity.this, R.layout.item, null);
            ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
            TextView textView = (TextView) layout.findViewById(R.id.textView);
            imageView.setImageResource(imageId[position]);
            textView.setText(arrayDemo[position]);
            return layout;
        }

    }

}
