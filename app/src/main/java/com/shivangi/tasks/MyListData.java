package com.shivangi.tasks;

public class MyListData {
    private String name;
    private String desc;
    private int ing;
    private String fullDesc;
    public MyListData(String name, String desc, int ing, String fullDesc) {
        this.name = name;
        this.desc = desc;
        this.ing = ing;
        this.fullDesc = fullDesc;
    }


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getIng() {
        return ing;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setIng(int ing) {
        this.ing = ing;
    }
}
