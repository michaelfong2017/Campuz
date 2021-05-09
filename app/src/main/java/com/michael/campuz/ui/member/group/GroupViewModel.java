package com.michael.campuz.ui.member.group;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.michael.campuz.R;
import com.michael.campuz.data.Result;
import com.michael.campuz.data.group.Group;
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

    @Inject
    public GroupViewModel(SavedStateHandle savedStateHandle, GroupRepository repository) {
        this.savedStateHandle = savedStateHandle;
        this.repository = repository;
//        this.allGroups = repository.getAllGroups();
        this.allGroups = getAllGroups();
    }

//    public void insert(Group group) {
//        repository.insert(group);
//    }
//    public void update(Group group) {
//        repository.update(group);
//    }
//    public void delete(Group group) {
//        repository.delete(group);
//    }
//    public void deleteAllGroups() {
//        repository.deleteAllGroups();
//    }
    public LiveData<List<Group>> getAllGroups() {
        Group test = new Group("tit","desc",1,4,"free","vote", "open"
                ,0,5);
        Group test2 = new Group("tit2","desc2",3,4,"free","vote", "open"
                ,1,7);
        List<Group> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        MutableLiveData<List<Group>> groups = new MutableLiveData<>();
        groups.setValue(testList);
        return groups;
//        return allGroups;
    }
}