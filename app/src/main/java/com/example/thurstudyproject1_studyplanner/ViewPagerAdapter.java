package com.example.thurstudyproject1_studyplanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext = null;

    public ViewPagerAdapter(Context context){
        mContext = context;
    }

    public Object instantiateItem(ViewGroup container, int position){
        View view = null;

        TextView textView;
        Button btntext;
        EditText etsend;

        if(mContext != null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.viewpager_activity, container, false);

            textView = (TextView) view.findViewById(R.id.tvall);
//            textView.setText("TEXT" + ( position +1 )); // 여기를 건드려야 변할듯

            etsend = (EditText) view.findViewById(R.id.etsend);
            btntext = (Button) view.findViewById(R.id.btntext);




            btntext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText("안녕하세요." + etsend.getText()  );
                }
            });

        }
        container.addView(view);

        return view;


    }

    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public boolean isViewFromObject(@NonNull @org.jetbrains.annotations.NotNull View view, @NonNull @org.jetbrains.annotations.NotNull Object object) {
        return (view == (View)object);
    }
}
