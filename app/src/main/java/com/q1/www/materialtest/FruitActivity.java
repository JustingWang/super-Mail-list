package com.q1.www.materialtest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {
    private TextView fruitContentText;
    private TextView qqText;
    private TextView wechatText;
    private TextView hobbyText;
    private TextView birthText;
    private ImageView call;
    private ImageView qq;
    private ImageView wechat;

    public static final String FRUIT_NAME="fruit_name";
    public static final String FRUIT_IMAGE_ID="fruit_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        Intent intent=getIntent();
        String fruitName=intent.getStringExtra(FRUIT_NAME);
        int fruitImageId=intent.getIntExtra(FRUIT_IMAGE_ID,0);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolber);
        CollapsingToolbarLayout collapsingToolbar=(CollapsingToolbarLayout)findViewById(R.id.collapsing_tollbar);
        ImageView fruitImageView=(ImageView)findViewById(R.id.fruit_image_view);
        fruitContentText=(TextView)findViewById(R.id.fruit_content_text);
        qqText=(TextView)findViewById(R.id.qqtext);
        wechatText=(TextView)findViewById(R.id.wechattext);
        hobbyText=(TextView)findViewById(R.id.hobbytext);
        birthText=(TextView)findViewById(R.id.birthtext);
        call=(ImageView)findViewById(R.id.call);
        qq=(ImageView)findViewById(R.id.qq);
        wechat=(ImageView)findViewById(R.id.wechat);
        FloatingActionButton message = (FloatingActionButton) findViewById(R.id.message);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq ");
                startActivity(intent);
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.tencent.mobileqq");
                startActivity(intent);
            }
        });
        wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1235"));
                startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);
        Contect contect=new Contect();
       // if(fruitName=="赵娇然"){
            fruitContentText.setText("2393342915");
            qqText.setText("2393342915");
            wechatText.setText(" zjr6690");
            hobbyText.setText(" 性格开朗");
            birthText.setText(" 1995-01-03");

       //}
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(fruitName);
        Glide.with(this).load(fruitImageId).into(fruitImageView);
      }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;

        }return super.onOptionsItemSelected(item);
    }
}
