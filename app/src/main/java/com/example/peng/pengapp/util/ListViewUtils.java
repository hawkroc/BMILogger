package com.example.peng.pengapp.util;

import android.os.Build;
import android.widget.AbsListView;


/**
 * Created by PengYin on 14-4-11.
 */
public class ListViewUtils {
    private ListViewUtils() {

    }

    /**
     * roll to top
     *
     * @param listView
     */
    public static void smoothScrollListViewToTop(final AbsListView listView) {
        if (listView == null) {
            return;
        }
        smoothScrollListView(listView, 0);
        listView.postDelayed(new Runnable() {
            @Override
            public void run() {
                listView.setSelection(0);
            }
        }, 200);
    }

    /**
     * roll to position
     *
     * @param listView
     * @param position
     */
    public static void smoothScrollListView(AbsListView listView, int position) {
        if (Build.VERSION.SDK_INT > 7) {
            listView.smoothScrollToPositionFromTop(0, 0);
        } else {
            listView.setSelection(position);
        }
    }
}
