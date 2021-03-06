package com.siberiadante.androidutil.view.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created:： SiberiaDante
 *
 * @Date： 2017/11/11
 * Describe：  RecyclerView 分隔线
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */

public class SDNormalDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    private int mHeight;
    /**
     * marginEnd  marginStart
     * 父布局使用padding,避免使用margin
     */
    private int marginStart = 0;
    private int marginEnd = 0;

    public SDNormalDecoration(int color, int height) {
        this.mHeight = height;
        mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setAntiAlias(true);
    }

    public SDNormalDecoration(int color, int marginSE, int height) {
        this.mHeight = height;
        this.marginStart = marginSE;
        this.marginEnd = marginSE;
        this.mPaint = new Paint();
        this.mPaint.setColor(color);
        this.mPaint.setAntiAlias(true);
    }

    public SDNormalDecoration(int color, int marginStart, int marginEnd, int height) {
        this.mHeight = height;
        this.marginStart = marginStart;
        this.marginEnd = marginEnd;
        this.mPaint = new Paint();
        this.mPaint.setColor(color);
        this.mPaint.setAntiAlias(true);
    }

    @Override

    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        Rect rect = new Rect();
//        rect.left = parent.getPaddingLeft();
//        rect.right = parent.getWidth() - parent.getPaddingRight();
        rect.left = parent.getPaddingLeft() + marginStart;
        rect.right = parent.getWidth() - parent.getPaddingRight() - marginEnd;
        for (int i = 0; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            rect.top = childView.getBottom();
            rect.bottom = rect.top + mHeight;
            c.drawRect(rect, mPaint);
        }
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom += mHeight;
    }
}
