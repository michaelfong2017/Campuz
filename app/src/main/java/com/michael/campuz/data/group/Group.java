package com.michael.campuz.data.group;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "group_table")
public class Group {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private int from;
    private int to;
    private String joinMode;
    private String kickMode;

    private String status;
    private int numberOfPeople;
    private int numberOfComments;

    private String members;

    public Group(String title, String description, int from, int to, String joinMode, String kickMode, String status, int numberOfPeople, int numberOfComments, String members) {
        this.title = title;
        this.description = description;
        this.from = from;
        this.to = to;
        this.joinMode = joinMode;
        this.kickMode = kickMode;
        this.status = status;
        this.numberOfPeople = numberOfPeople;
        this.numberOfComments = numberOfComments;
        this.members = members;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getJoinMode() {
        return joinMode;
    }

    public void setJoinMode(String joinMode) {
        this.joinMode = joinMode;
    }

    public String getKickMode() {
        return kickMode;
    }

    public void setKickMode(String kickMode) {
        this.kickMode = kickMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }
}
