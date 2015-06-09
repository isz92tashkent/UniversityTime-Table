package com.developer.universitytimetable.utility;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class Open_Sans_Light_EditText extends EditText {

	Context context;

	public Open_Sans_Light_EditText(Context context) {
		super(context);
		this.context = context;
		init();
	}

	public Open_Sans_Light_EditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	public Open_Sans_Light_EditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		init();
	}

	private void init() {
		if (!isInEditMode()) {
			Typeface tf = Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf");
			setTypeface(tf);
		}
	}

}
