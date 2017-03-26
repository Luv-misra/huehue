package com.example.luv.image_in_list_view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends Activity {

    ListView list;
    Bitmap bitmap;
    Button B1;
    String[] itemname ={
            "Safari",
            "Camera",
            "Global"
    };

    Integer[] imgid={
            R.drawable.rth,
            R.drawable.rth,
            R.drawable.rth
    };

    public void takepic()
    {

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 0);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        bitmap = (Bitmap)data.getExtras().get("data");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> name = new ArrayList<>(Arrays.asList(itemname));
        final ArrayList<Integer> imdId = new ArrayList<>(Arrays.asList(imgid));

        final CustomListAdapter adapter=new CustomListAdapter(this, name, imdId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        B1 = (Button) findViewById(R.id.B1);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.add(0,"newly added");
                imdId.add(0,R.drawable.rth);



                adapter.notifyDataSetChanged();

            }
        });



    }
}