package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Entity.ScrollPage;
import fragment.Findpage;
import fragment.Homepage;
import fragment.Mypage;
import fragment.Ticketpage;

public class MainActivity extends AppCompatActivity {


    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new Homepage());
                    return true;
                case R.id.find:
                    replaceFragment(new Findpage());
                    return true;
                case R.id.ticket:
                    replaceFragment(new Ticketpage());
                    return true;
                case R.id.my:
                    replaceFragment(new Mypage());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        replaceFragment(new Homepage());



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    TextView location = (TextView) findViewById(R.id.location);
                    Toast.makeText(MainActivity.this, data.getStringExtra("locationName"), Toast.LENGTH_SHORT).show();
                    location.setText(data.getStringExtra("locationName"));
                }
            default:


        }
    }

    private void replaceFragment(android.support.v4.app.Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManage = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManage.beginTransaction();
        transaction.replace(R.id.page, fragment);

        transaction.commit();
    }

}

