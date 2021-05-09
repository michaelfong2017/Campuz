package com.michael.campuz.data.group;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Group.class, GroupReply.class}, version = 3)
public abstract class GroupDatabase extends RoomDatabase {
    private static GroupDatabase instance;
    public abstract GroupDao groupDao();
    public abstract GroupReplyDao groupReplyDao();
    public static synchronized GroupDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    GroupDatabase.class, "group_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private GroupDao groupDao;
        private PopulateDbAsyncTask(GroupDatabase db) {
            groupDao = db.groupDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
//            groupDao.insert(new Group("Title 1", "Description 1", 1));
//            groupDao.insert(new Group("Title 2", "Description 2", 2));
//            groupDao.insert(new Group("Title 3", "Description 3", 3));
            return null;
        }
    }
}
