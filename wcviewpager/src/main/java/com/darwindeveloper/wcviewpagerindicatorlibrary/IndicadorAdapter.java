package com.darwindeveloper.wcviewpagerindicatorlibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Darwin Morocho on 11/3/2017.
 */

public class IndicadorAdapter extends RecyclerView.Adapter<IndicadorAdapter.IViewHolder> {

    private Context context;
    private ArrayList<Indicator> indicators;
    private int colorIndicator, colorSelectedIndicator, textColor;
    private boolean showNums;
    private int numberSelectedColor;

    public IndicadorAdapter(Context context, ArrayList<Indicator> indicators,
                            int colorIndicator, int colorSelectedIndicator, int textColor, boolean showNums, int numberSelectedColor) {
        this.context = context;
        this.indicators = indicators;
        this.colorIndicator = colorIndicator;
        this.colorSelectedIndicator = colorSelectedIndicator;
        this.textColor = textColor;
        this.showNums = showNums;
        this.numberSelectedColor = numberSelectedColor;
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.indicator, parent, false);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, final int position) {

        Indicator indicator = indicators.get(position);


        if (indicator.isSelected()) {
            holder.indicator.setCircleColor(colorSelectedIndicator);
            holder.indicator.setTextColor(numberSelectedColor);
        } else {
            holder.indicator.setCircleColor(colorIndicator);
            holder.indicator.setTextColor(textColor);
        }

        if (showNums) {
            holder.indicator.setText(indicator.getText());
        } else {
            holder.indicator.setText(" ");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onIndicatorClickListener.onIndicatorClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return indicators.size();
    }


    public class IViewHolder extends RecyclerView.ViewHolder {

        CircularTextView indicator;

        public IViewHolder(View itemView) {
            super(itemView);
            indicator = (CircularTextView) itemView.findViewById(R.id.indicator);

        }
    }


    public interface OnIndicatorClickListener {
        void onIndicatorClick(int position);
    }

    private OnIndicatorClickListener onIndicatorClickListener;

    public void setOnIndicatorClickListener(OnIndicatorClickListener onIndicatorClickListener) {
        this.onIndicatorClickListener = onIndicatorClickListener;
    }
}
