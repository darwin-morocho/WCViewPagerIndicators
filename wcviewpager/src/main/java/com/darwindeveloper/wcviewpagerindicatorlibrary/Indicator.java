package com.darwindeveloper.wcviewpagerindicatorlibrary;

/**
 * Created by Darwin Morocho on 11/3/2017.
 */

public class Indicator {
    private String text;
    private boolean selected;

    public Indicator(){

    }

    public Indicator(String text) {
        this.text = text;
    }

    public Indicator(String text, boolean selected) {
        this.text = text;
        this.selected = selected;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
