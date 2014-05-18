package org.clownqiang.BluetoothProject.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.clownqiang.BluetoothProject.R;

/**
 * Created by clownqiang on 14-5-18.
 */
public class FragmentIndicator extends LinearLayout implements View.OnClickListener{

    private int mDefaultIndicator = 0;

    private static int mCurIndicator;

    private OnIndicateListener onIndicateListener;

    private static View[] mIndicators;

    private static final String TAG_ICON_HOME = "icon_tag_home";
    private static final String TAG_ICON_Second = "icon_tag_second";
    private static final String TAG_ICON_About = "icon_tag_about";

    private static final String TAG_TEXT_HOME = "text_tag_home";
    private static final String TAG_TEXT_Second = "text_tag_second";
    private static final String TAG_TEXT_About = "text_tag_about";

    private static final int COLOR_UNSELECT = Color.argb(100, 0xff, 0xff, 0xff);
    private static final int COLOR_SELECT = Color.WHITE;

    public FragmentIndicator(Context context) {
        super(context);
    }

    public FragmentIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCurIndicator = mDefaultIndicator;
        setOrientation(LinearLayout.HORIZONTAL);
        init();
    }


    private void init() {
        mIndicators = new View[3];
        mIndicators[0] = createIndicator(R.drawable.ic_launcher,
                R.string.string_home, COLOR_SELECT, TAG_ICON_HOME, TAG_TEXT_HOME);
        mIndicators[0].setBackgroundResource(R.drawable.indic_select);
        mIndicators[0].setTag(Integer.valueOf(0));
        mIndicators[0].setOnClickListener(this);
        addView(mIndicators[0]);
        mIndicators[1] = createIndicator(R.drawable.ic_launcher,
                R.string.string_second, COLOR_UNSELECT, TAG_ICON_Second, TAG_TEXT_Second);
        mIndicators[1].setBackgroundColor(Color.alpha(0));
        mIndicators[1].setTag(Integer.valueOf(1));
        mIndicators[1].setOnClickListener(this);
        addView(mIndicators[1]);
        mIndicators[2] = createIndicator(R.drawable.ic_launcher,
                R.string.string_about, COLOR_UNSELECT, TAG_ICON_About, TAG_TEXT_About);
        mIndicators[2].setBackgroundColor(Color.alpha(0));
        mIndicators[2].setTag(Integer.valueOf(2));
        mIndicators[2].setOnClickListener(this);
        addView(mIndicators[2]);
    }

    private View createIndicator(int iconResID, int stringResID, int stringColor,
                                 String iconTag, String textTag) {
        LinearLayout view = new LinearLayout(getContext());
        view.setOrientation(LinearLayout.VERTICAL);
        view.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        view.setGravity(Gravity.CENTER_HORIZONTAL);

        ImageView iconView = new ImageView(getContext());
        iconView.setTag(iconTag);
        iconView.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        iconView.setImageResource(iconResID);

        TextView textView = new TextView(getContext());
        textView.setTag(textTag);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        textView.setTextColor(stringColor);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        textView.setText(stringResID);

        view.addView(iconView);
        view.addView(textView);

        return view;
    }

    public static void setIndicator(int which) {
        // clear previous status.
        mIndicators[mCurIndicator].setBackgroundColor(Color.alpha(0));
        ImageView prevIcon;
        TextView prevText;
        switch(mCurIndicator) {
            case 0:
                prevIcon =(ImageView) mIndicators[mCurIndicator].findViewWithTag(TAG_ICON_HOME);
                prevIcon.setImageResource(R.drawable.ic_launcher);
                prevText = (TextView) mIndicators[mCurIndicator].findViewWithTag(TAG_TEXT_HOME);
                prevText.setTextColor(COLOR_UNSELECT);
                break;
            case 1:
                prevIcon =(ImageView) mIndicators[mCurIndicator].findViewWithTag(TAG_ICON_Second);
                prevIcon.setImageResource(R.drawable.ic_launcher);
                prevText = (TextView) mIndicators[mCurIndicator].findViewWithTag(TAG_TEXT_Second);
                prevText.setTextColor(COLOR_UNSELECT);
                break;
            case 2:
                prevIcon =(ImageView) mIndicators[mCurIndicator].findViewWithTag(TAG_ICON_About);
                prevIcon.setImageResource(R.drawable.ic_launcher);
                prevText = (TextView) mIndicators[mCurIndicator].findViewWithTag(TAG_TEXT_About);
                prevText.setTextColor(COLOR_UNSELECT);
                break;
        }

        // update current status.
        mIndicators[which].setBackgroundResource(R.drawable.indic_select);
        ImageView currIcon;
        TextView currText;
        switch(which) {
            case 0:
                currIcon =(ImageView) mIndicators[which].findViewWithTag(TAG_ICON_HOME);
                currIcon.setImageResource(R.drawable.ic_launcher);
                currText = (TextView) mIndicators[which].findViewWithTag(TAG_TEXT_HOME);
                currText.setTextColor(COLOR_SELECT);
                break;
            case 1:
                currIcon =(ImageView) mIndicators[which].findViewWithTag(TAG_ICON_Second);
                currIcon.setImageResource(R.drawable.ic_launcher);
                currText = (TextView) mIndicators[which].findViewWithTag(TAG_TEXT_Second);
                currText.setTextColor(COLOR_SELECT);
                break;
            case 2:
                currIcon =(ImageView) mIndicators[which].findViewWithTag(TAG_ICON_About);
                currIcon.setImageResource(R.drawable.ic_launcher);
                currText = (TextView) mIndicators[which].findViewWithTag(TAG_TEXT_About);
                currText.setTextColor(COLOR_SELECT);
                break;
        }

        mCurIndicator = which;
    }


    public interface OnIndicateListener {
        public void onIndicate(View v, int which);
    }

    public void setOnIndicateListener(OnIndicateListener listener) {
        onIndicateListener = listener;
    }

    @Override
    public void onClick(View view) {
        if (onIndicateListener != null) {
            int tag = (Integer) view.getTag();
            switch (tag) {
                case 0:
                    if (mCurIndicator != 0) {
                        onIndicateListener.onIndicate(view, 0);
                        setIndicator(0);
                    }
                    break;
                case 1:
                    if (mCurIndicator != 1) {
                        onIndicateListener.onIndicate(view, 1);
                        setIndicator(1);
                    }
                    break;
                case 2:
                    if (mCurIndicator != 2) {
                        onIndicateListener.onIndicate(view, 2);
                        setIndicator(2);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
