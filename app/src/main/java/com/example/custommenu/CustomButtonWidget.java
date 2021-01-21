package com.example.custommenu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomButtonWidget extends LinearLayout {

    private final Button mButton;

    private final int buttonIndex;
    private final AttributeSet attributeSet;
    private final String customAttrsNameSpace = "http://schemas.android.com/apk/res-auto";

    public CustomButtonWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.attributeSet = attributeSet;
        LayoutInflater.from(context).inflate(R.layout.custom_button_widget, this);  // convert custom_button_widget.xml file to java object
        mButton = findViewById(R.id.button);
        setDisplayText();

        buttonIndex = Integer.parseInt(attributeSet.getAttributeValue(customAttrsNameSpace, "index"));
        //Log.d("DEBUG_Q", "Index: " + buttonIndex);

        eventListener();
    }

    private void eventListener() {
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Determine which button is pressed
                if (buttonIndex == 0) {
                    Log.d("DEBUG_Q", "button#1 clicked");
                } else if (buttonIndex == 1) {
                    Log.d("DEBUG_Q", "button#2 clicked");
                } else if (buttonIndex == 2) {
                    Log.d("DEBUG_Q", "button#3 clicked");
                }
            }
        });
    }

    private void setDisplayText() {
        // Get attribute value from com.example.custommenu.CustomButtonWidget class in activity.xml
        String text = attributeSet.getAttributeValue(customAttrsNameSpace, "describeText");

        TextView textView = findViewById(R.id.textView);
        textView.setText(text);  // Set describe text
    }
}
