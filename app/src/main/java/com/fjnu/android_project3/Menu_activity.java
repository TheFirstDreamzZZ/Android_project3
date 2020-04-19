package com.fjnu.android_project3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Menu_activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle SaveInstanceState) {
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.xml_test);
        textView =findViewById(R.id.text);
        registerForContextMenu(textView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.font_small:
                textView.setTextSize(10*2);
                System.out.println("选择了小号字体");
                break;
            case R.id.font_middle:
                textView.setTextSize(16*2);
                System.out.println("选择了中号字体");
                break;
            case R.id.font_big:
                textView.setTextSize(20*2);
                System.out.println("选择了大号字体");
                break;
            case R.id.normal:
                Toast.makeText(this, "普通菜单项", Toast.LENGTH_LONG).show();
                System.out.println("点击了普通菜单项");
                break;
            case R.id.color_red:
                textView.setTextColor(Color.RED);
                System.out.println("选择了红色字体");
                break;
            case R.id.color_black:
                textView.setTextColor(Color.BLACK);
                System.out.println("选择了黑色字体");
                break;
        }
        return true;

    }
}