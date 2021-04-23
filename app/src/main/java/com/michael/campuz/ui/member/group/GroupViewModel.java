package com.michael.campuz.ui.member.group;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.michael.campuz.R;
import com.michael.campuz.data.Result;
import com.michael.campuz.data.model.LoggedInUser;
import com.michael.campuz.ui.view.GroupThreadView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class GroupViewModel extends ViewModel {
    private SavedStateHandle savedStateHandle;

    public GroupViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
    }

    private MutableLiveData<List<GroupThread>> groupThreads = new MutableLiveData<List<GroupThread>>();;
    private int currentThreadId = 3;

    public MutableLiveData<List<GroupThread>> getGroupThreads() {
        return groupThreads;
    }

    public void createThread(String title, String status, int numberOfComments, String people) {
        GroupThread groupThread = new GroupThread(++currentThreadId);
        groupThread.setTitle(title);
        groupThread.setStatus(status);
        groupThread.setNumberOfComments(numberOfComments);
        groupThread.setPeople(people);
        List<GroupThread> list = groupThreads.getValue();
        if (list == null) {
            list = new ArrayList<GroupThread>();
        }
        list.add(groupThread);
        groupThreads.setValue(list);
    }

//    public void updateThreadWithId(int id, String title, String status, String numberOfComments) {
//        String prefix = "group_thread_id_";
//
//        int raw_id = getResources().getIdentifier(prefix + id, "id", getPackageName());
//        GroupThreadView view = findViewById(raw_id);
//        if (title != null)
//            view.setThreadTitle(title);
//        if (status != null)
//            view.setThreadStatus(status);
//        if (numberOfComments != null)
//            view.setThreadNumberOfComment(numberOfComments);
//    }

    public void saveGroupThreads() {
        Logger.d(groupThreads.getValue());
//        savedStateHandle.set("groupThreads", groupThreads.getValue());
//        Logger.d(savedStateHandle.getLiveData("groupThreads").getValue());

    }

}