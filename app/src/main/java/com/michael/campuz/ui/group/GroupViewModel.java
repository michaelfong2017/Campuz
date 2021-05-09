package com.michael.campuz.ui.group;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.michael.campuz.R;
import com.michael.campuz.data.Result;
import com.michael.campuz.data.group.Group;
import com.michael.campuz.data.group.GroupReply;
import com.michael.campuz.data.group.GroupRepository;
import com.michael.campuz.data.model.LoggedInUser;
import com.michael.campuz.ui.view.GroupThreadView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class GroupViewModel extends ViewModel {
    private final SavedStateHandle savedStateHandle;
    private final GroupRepository repository;

    private LiveData<List<Group>> allGroups;
    int numberOfGroups;

    @Inject
    public GroupViewModel(SavedStateHandle savedStateHandle, GroupRepository repository) {
        this.savedStateHandle = savedStateHandle;
        this.repository = repository;
        allGroups = repository.getAllGroups();
    }

    /** Group **/
    public void insert(Group group) {
        repository.insert(group);
    }
    public void update(Group group) {
        repository.update(group);
    }
    public void delete(Group group) {
        repository.delete(group);
    }
    public void deleteAllGroups() {
        repository.deleteAllGroups();
    }
    public LiveData<List<Group>> getAllGroups() {
        return allGroups;
    }
    public void setNumberOfGroups(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }
    public int getNumberOfGroups() {
        return numberOfGroups;
    }
    public LiveData<Group> getGroupById(int id) {
        return repository.getGroupById(id);
    }

    /** GroupReply **/
    public void insertReply(GroupReply groupReply) {
        repository.insertReply(groupReply);
    }
    public void updateReply(GroupReply groupReply) {
        repository.updateReply(groupReply);
    }
    public void deleteReply(GroupReply groupReply) {
        repository.deleteReply(groupReply);
    }
    public void deleteAllGroupReplies() {
        repository.deleteAllGroupReplies();
    }
    public LiveData<List<GroupReply>> getAllGroupRepliesByGroup(int id) {
        return repository.getAllGroupRepliesByGroup(id);
    }

}