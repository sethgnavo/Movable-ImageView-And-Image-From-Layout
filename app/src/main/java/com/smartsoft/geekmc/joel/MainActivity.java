package com.smartsoft.geekmc.joel;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    ViewGroup bottomSide;
    ViewGroup colorPick;
    GridView gridView;
     ColorPick cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.designer_b);

        bottomSide = (ViewGroup) findViewById(R.id.bottom_side);

        colorPick = (ViewGroup) findViewById(R.id.include_colorpick);
        gridView = (GridView) findViewById(R.id.color_grid);
        cp = new ColorPick(this, gridView, colorPick);
        cp.baseView = bottomSide;
        cp.show();

        setupListner();
    }

    private void setupListner() {
        bottomSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cp.show();
            }
        });
    }

    public static Bitmap viewToBitmap(View view, int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}
