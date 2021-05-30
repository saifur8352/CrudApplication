package unimas.my.crudapplication;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter<PagerAdapter> extends androidx.viewpager.widget.PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images= {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.five};

    public ImageAdapter(Context context) {
        this.context = context;
    }

    public int getCount() {
        return images.length;
    }

    public boolean isViewFromObject( View view, Object o) {
        return view == o;
    }



    public Object instantiateItem( ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView= (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        ViewPager vp= (ViewPager) container;
        vp.addView(view,0);
        return view;

    }


    public void destroyItem( ViewGroup container, int position,  Object object) {
        ViewPager vp= (ViewPager) container;
        View view=(View) object;
        vp.removeView(view);
    }
}