package com.criscastemendo.sprintexam.Data;

public class ListItem {

    private int id;
    private int position;

    public ListItem(int id, int position){
        this.id=id;
        this.position=position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getposition() {
        return position;
    }

    public void setposition(int position) {
        this.position = position;
    }
}
