package com.example.shaopeng.testproject.Model;

/**
 * Created by Administrator on 2017/11/18.
 */
public class RingsViewModel {
    private String Name;
    private float ratio;
    private int color;

    public RingsViewModel(String Name, float ratio, int color) {
        super();
        this.Name = Name;
        this.color = color;
        this.ratio = ratio;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
