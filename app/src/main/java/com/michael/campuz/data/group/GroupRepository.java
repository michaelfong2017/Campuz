package com.michael.campuz.data.group;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.michael.campuz.data.LoginDataSource;
import com.michael.campuz.data.Result;
import com.michael.campuz.data.model.LoggedInUser;

import java.util.List;

import javax.inject.Inject;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class GroupRepository {
    private GroupDao groupDao;
    private GroupReplyDao groupReplyDao;
    private LiveData<List<Group>> allGroups;

    @Inject
    public GroupRepository(Application application) {
        GroupDatabase database = GroupDatabase.getInstance(application);
        groupDao = database.groupDao();
        allGroups = groupDao.getAllGroups();
        groupReplyDao = database.groupReplyDao();
    }
    /** Group **/
    public void insert(Group group) {
        new InsertGroupAsyncTask(groupDao).execute(group);
    }
    public void update(Group group) {
        new UpdateGroupAsyncTask(groupDao).execute(group);
    }
    public void delete(Group group) {
        new DeleteGroupAsyncTask(groupDao).execute(group);
    }
    public void deleteAllGroups() {
        new DeleteAllGroupsAsyncTask(groupDao).execute();
    }
    public LiveData<List<Group>> getAllGroups() {
        return allGroups;
    }
    public LiveData<Group> getGroupById(int id) {
        return groupDao.getGroupById(id);
    }
    private static class InsertGroupAsyncTask extends AsyncTask<Group, Void, Void> {
        private GroupDao groupDao;
        private InsertGroupAsyncTask(GroupDao groupDao) {
            this.groupDao = groupDao;
        }
        @Override
        protected Void doInBackground(Group... groups) {
            groupDao.insert(groups[0]);
            return null;
        }
    }
    private static class UpdateGroupAsyncTask extends AsyncTask<Group, Void, Void> {
        private GroupDao groupDao;
        private UpdateGroupAsyncTask(GroupDao groupDao) {
            this.groupDao = groupDao;
        }
        @Override
        protected Void doInBackground(Group... groups) {
            groupDao.update(groups[0]);
            return null;
        }
    }
    private static class DeleteGroupAsyncTask extends AsyncTask<Group, Void, Void> {
        private GroupDao groupDao;
        private DeleteGroupAsyncTask(GroupDao groupDao) {
            this.groupDao = groupDao;
        }
        @Override
        protected Void doInBackground(Group... groups) {
            groupDao.delete(groups[0]);
            return null;
        }
    }
    private static class DeleteAllGroupsAsyncTask extends AsyncTask<Void, Void, Void> {
        private GroupDao groupDao;
        private DeleteAllGroupsAsyncTask(GroupDao groupDao) {
            this.groupDao = groupDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            groupDao.deleteAllGroups();
            return null;
        }
    }

    /** GroupReply **/
    public void insertReply(GroupReply groupReply) {
        new InsertGroupReplyAsyncTask(groupReplyDao).execute(groupReply);
    }
    public void updateReply(GroupReply groupReply) {
        new UpdateGroupReplyAsyncTask(groupReplyDao).execute(groupReply);
    }
    public void deleteReply(GroupReply groupReply) {
        new DeleteGroupReplyAsyncTask(groupReplyDao).execute(groupReply);
    }
    public void deleteAllGroupReplies() {
        new DeleteAllGroupRepliesAsyncTask(groupReplyDao).execute();
    }
    public LiveData<List<GroupReply>> getAllGroupRepliesByGroup(int id) {
        return groupReplyDao.getAllGroupRepliesByGroup(id);
    }

    private static class InsertGroupReplyAsyncTask extends AsyncTask<GroupReply, Void, Void> {
        private GroupReplyDao groupReplyDao;
        private InsertGroupReplyAsyncTask(GroupReplyDao groupReplyDao) {
            this.groupReplyDao = groupReplyDao;
        }
        @Override
        protected Void doInBackground(GroupReply... groupReplies) {
            groupReplyDao.insert(groupReplies[0]);
            return null;
        }
    }
    private static class UpdateGroupReplyAsyncTask extends AsyncTask<GroupReply, Void, Void> {
        private GroupReplyDao groupReplyDao;
        private UpdateGroupReplyAsyncTask(GroupReplyDao groupReplyDao) {
            this.groupReplyDao = groupReplyDao;
        }
        @Override
        protected Void doInBackground(GroupReply... groupReplies) {
            groupReplyDao.update(groupReplies[0]);
            return null;
        }
    }
    private static class DeleteGroupReplyAsyncTask extends AsyncTask<GroupReply, Void, Void> {
        private GroupReplyDao groupReplyDao;
        private DeleteGroupReplyAsyncTask(GroupReplyDao groupReplyDao) {
            this.groupReplyDao = groupReplyDao;
        }
        @Override
        protected Void doInBackground(GroupReply... groupReplies) {
            groupReplyDao.delete(groupReplies[0]);
            return null;
        }
    }
    private static class DeleteAllGroupRepliesAsyncTask extends AsyncTask<Void, Void, Void> {
        private GroupReplyDao groupReplyDao;
        private DeleteAllGroupRepliesAsyncTask(GroupReplyDao groupReplyDao) {
            this.groupReplyDao = groupReplyDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            groupReplyDao.deleteAllGroupReplies();
            return null;
        }
    }
}