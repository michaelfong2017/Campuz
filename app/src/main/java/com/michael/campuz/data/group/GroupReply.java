package com.michael.campuz.data.group;

import androidx.room.Entity;

@Entity(tableName = "group_reply_table", primaryKeys = {"id", "number"})
public class GroupReply {
    private int id;
    private int number;
    private String name;
    private String content;

    public GroupReply(int id, int number, String name, String content) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
