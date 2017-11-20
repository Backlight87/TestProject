package com.example.shaopeng.testproject.Model;

/**
 * 只要传数量，不用传比例
 * Created by Administrator on 2017/11/20.
 */
public class RingsViewWithNumberModel {
    private String name;
    private int number;
    private int color;

    public RingsViewWithNumberModel(String Name, int number, int color) {
        super();
        this.name = Name;
        this.color = color;
        this.number = number;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
