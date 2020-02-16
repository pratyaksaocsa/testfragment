package edu.ftiuksw.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

        WindowManager windowManager = getWindowManager();
        Point size = new Point();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            windowManager.getDefaultDisplay().getSize(size);
            if(size.x > size.y) {
                Fragment1 fragment1 = new Fragment1();
                fragmentTransaction.replace(android.R.id.content, fragment1);
            } else {
                Fragment2 fragment2 = new Fragment2();
                fragmentTransaction.replace(android.R.id.content, fragment2);
            }
        } else {
            Display display = windowManager.getDefaultDisplay();
            if(display.getRotation() == Surface.ROTATION_90 || display.getRotation() == Surface.ROTATION_270) {
                Fragment1 fragment1 = new Fragment1();
                fragmentTransaction.replace(android.R.id.content, fragment1);
            } else {
                Fragment2 fragment2 = new Fragment2();
                fragmentTransaction.replace(android.R.id.content, fragment2);
            }
        }
        fragmentTransaction.commit();
    }
}
