package com.chendoing.introactivity.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.chendoing.introactivity.R;

import org.apache.commons.lang3.StringUtils;

public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTextView, 0, 0);
        String typefaceName = array.getString(R.styleable.CustomTextView_typeface);
        if (StringUtils.isNotEmpty(typefaceName))
            setTypeface(Typeface.createFromAsset(context.getAssets(), typefaceName));
        array.recycle();
    }
}
