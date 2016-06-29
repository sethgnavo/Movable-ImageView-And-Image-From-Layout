package com.smartsoft.geekmc.joel;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shadaï ALI on 16/06/16.
 */
public class ColorPick {
    private static Context context;
    private ViewGroup viewGroup;
    public int selectedColor;
    public View baseView;
    public ColorPick(Context context, GridView gridView, ViewGroup viewGroup) {
        final List<MColor> mColorList = new ArrayList<>();

        mColorList.add(new MColor(COLOR_RED)); //rouge
        mColorList.add(new MColor(COLOR_GREEN)); //vert
        mColorList.add(new MColor(COLOR_BLUE)); //bleu

        mColorList.add(new MColor(COLOR_YELLOW)); //jaune
        mColorList.add(new MColor(COLOR_MOVE_BLUE)); //bleu claire
        mColorList.add(new MColor(COLOR_DARK_GRAY)); //noir

        mColorList.add(new MColor(COLOR_LIGTH_GRAY)); //gris
        mColorList.add(new MColor(COLOR_MOVE_GREEN)); //blanc
        mColorList.add(new MColor(COLOR_MOVE)); // move

        final Adapter adapter = new Adapter(context, R.layout.color_pick, mColorList);
        gridView.setAdapter(adapter);
        this.viewGroup = viewGroup;


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dismiss();
                Log.e("position",String.valueOf(position));
                selectedColor = mColorList.get(position).value;
                baseView.setBackgroundColor(mColorList.get(position).value);
            }
        });
        this.context = context;
    }

    public void show() {
        viewGroup.setVisibility(View.VISIBLE);
    }

    public void dismiss() {
        viewGroup.setVisibility(View.GONE);
    }

    public int getSelectedColor() {
        return selectedColor;
    }

    static class MColor {
        int value;

        public MColor(int value) {
            this.value = value;
        }
    }

    class Adapter extends ArrayAdapter<MColor> implements ListAdapter {

        List<MColor> mColorList;


        public Adapter(Context context, int resource, List<MColor> colorList) {
            super(context, resource);
            this.mColorList = colorList;
        }

        @Override
        public int getCount() {
            return mColorList.size();
        }

        @Override
        public MColor getItem(int position) {
            super.getItem(position);
            return getCount() > 0 ? mColorList.get(position) : new MColor(Color.BLACK);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            ViewHolder viewHolder;

            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView =  LayoutInflater.from(context).inflate(R.layout.color_pick, parent, false);
                viewHolder.view = (ViewGroup) convertView.findViewById(R.id.color_item);
                viewHolder.view.setVisibility(View.VISIBLE);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.view.setBackgroundColor(mColorList.get(position).value);

            return convertView;
        }

        class ViewHolder {
            ViewGroup view;
        }
    }


    public static  final  int COLOR_RED = Color.parseColor("#F44336");
    public static  final  int COLOR_BLUE = Color.parseColor("#448AFF");
    public static  final  int COLOR_MOVE = Color.parseColor("#E040FB");
    public static  final  int COLOR_YELLOW = Color.parseColor("#FFEB3B");
    public static  final  int COLOR_GREEN = Color.parseColor("#4CAF50");
    public static  final  int COLOR_MOVE_BLUE = Color.parseColor("#009688");
    public static  final  int COLOR_LIGTH_GRAY = Color.parseColor("#B6B6B6");
    public static  final  int COLOR_DARK_GRAY = Color.parseColor("#727272");
    public static  final  int COLOR_MOVE_GREEN = Color.parseColor("#00Eeac");
}
