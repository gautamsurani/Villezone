package com.villezone.gautam.ui;

import android.content.Context;
import android.util.AttributeSet;

public class InstantAutoComplete extends androidx.appcompat.widget.AppCompatAutoCompleteTextView {

    private boolean mIsSearchEnabled = false;

    public InstantAutoComplete(Context context) {
        super(context);
    }

    public InstantAutoComplete(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InstantAutoComplete(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setSearchEnabled(boolean isEnabled) {
        mIsSearchEnabled = isEnabled;
    }

    @Override
    protected void performFiltering(CharSequence text, int keyCode) {
        if (mIsSearchEnabled) {
            super.performFiltering(text, keyCode);
        }
    }

}