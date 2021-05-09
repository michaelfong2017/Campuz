package com.michael.campuz.data.group;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GroupReplyDao {
    @Insert
    void insert(GroupReply groupReply);
    @Update
    void update(GroupReply groupReply);
    @Delete
    void delete(GroupReply groupReply);
    @Query("DELETE FROM group_reply_table")
    void deleteAllGroupReplies();
    @Query("SELECT * FROM group_reply_table")
    LiveData<List<GroupReply>> getAllGroupReplies();
}
