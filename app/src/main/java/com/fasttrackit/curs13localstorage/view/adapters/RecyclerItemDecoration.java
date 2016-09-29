package com.fasttrackit.curs13localstorage.view.adapters;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

/**
 * @author mihai.mecea
 */

public class RecyclerItemDecoration extends RecyclerView.ItemDecoration {

  private static final int BOTTOM_PADDING_IN_DIPS = 8;

  private final int padding;

  public RecyclerItemDecoration(Context context) {
    DisplayMetrics metrics = context.getResources().getDisplayMetrics();
    padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, BOTTOM_PADDING_IN_DIPS, metrics);
  }


  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
      RecyclerView.State state) {
    outRect.bottom = padding;
  }

}
