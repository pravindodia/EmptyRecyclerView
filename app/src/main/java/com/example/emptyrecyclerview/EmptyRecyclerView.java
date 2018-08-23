package com.example.emptyrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by RulTech Solutions Private Limited on 28/07/18.
 */
public class EmptyRecyclerView extends RecyclerView {
    private final Context mContext;
    private EmptyTextView mEmptyView;


    private String defaultStr = "No Records Found";
    private float defaultTextSize = 20;
    private int defaultTextColor = R.color.colorAccent;


    private int emptyViewGravity = RelativeLayout.CENTER_IN_PARENT;
    private RelativeLayout.LayoutParams emptyViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

    private ViewGroup mParentView;

    private final AdapterDataObserver mObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            checkIfEmpty();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            checkIfEmpty();
        }
    };


    public EmptyRecyclerView(Context context) {
        super(context);
        mContext = context;
    }

    public EmptyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public EmptyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    void checkIfEmpty() {
        if (mEmptyView == null) {
            withEmptyView(mContext).built();
        }
        if (mEmptyView != null && getAdapter() != null) {
            final boolean emptyViewVisible = getAdapter().getItemCount() == 0;
            mEmptyView.setVisibility(emptyViewVisible ? VISIBLE : GONE);
            setVisibility(emptyViewVisible ? GONE : VISIBLE);
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        final Adapter oldAdapter = getAdapter();
        if (oldAdapter != null) {
            oldAdapter.unregisterAdapterDataObserver(mObserver);
        }
        super.setAdapter(adapter);
        if (adapter != null) {
            adapter.registerAdapterDataObserver(mObserver);
        }

        checkIfEmpty();
    }

    public EmptyTextView withEmptyView(Context mContext) {
        mParentView = (ViewGroup) getParent();
        mEmptyView = new EmptyTextView(mContext);
        mEmptyView.setGravity(Gravity.CENTER);
        mEmptyView.setText(defaultStr);
        mEmptyView.setTextSize(defaultTextSize);
        mEmptyView.setTextColor(ContextCompat.getColor(mContext, defaultTextColor));
        return mEmptyView;
    }

    public EmptyRecyclerView setEmptyViewGravity(int mEmptyViewGravity) {
        emptyViewGravity = mEmptyViewGravity;
        initEmptyView();
        return this;
    }

    public EmptyRecyclerView setEmptyViewParams(RelativeLayout.LayoutParams mEmptyViewParams) {
        this.emptyViewLayoutParams = mEmptyViewParams;
        initEmptyView();
        return this;
    }

    private void initEmptyView() {
        if (mParentView != null && mEmptyView != null) {
            try {

                mParentView.removeView(mEmptyView);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            emptyViewLayoutParams.addRule(emptyViewGravity);
            mParentView.addView(mEmptyView, emptyViewLayoutParams);
        }
    }

    protected class EmptyTextView extends android.support.v7.widget.AppCompatTextView {

        public EmptyTextView(Context context) {
            super(context);
        }

        public void built() {
            initEmptyView();
        }


    }


}
