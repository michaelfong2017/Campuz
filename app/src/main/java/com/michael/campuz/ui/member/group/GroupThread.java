package com.michael.campuz.ui.member.group;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */
public class GroupThread {
    private int id;
    private String title;
    private String status;
    private int numberOfComments;

    public GroupThread(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}