package com.tehmou.rxbookapp.viewmodels;

import com.tehmou.rxbookapp.data.DataStore;
import com.tehmou.rxbookapp.pojo.GitHubRepository;

import java.util.List;

import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by ttuo on 19/03/14.
 */
public class RepositoriesViewModel {
    final private CompositeSubscription compositeSubscription = new CompositeSubscription();

    final private DataStore dataStore;
    final private String search;

    final private Subject<List<GitHubRepository>, List<GitHubRepository>> repositories
            = BehaviorSubject.create();

    public Observable<List<GitHubRepository>> getRepositories() {
        return repositories;
    }

    public RepositoriesViewModel(final DataStore dataStore, final String search) {
        this.dataStore = dataStore;
        this.search = search;
    }

    public void subscribeToDataStore() {
        compositeSubscription.add(dataStore.getGitHub(search).subscribe(repositories));
    }

    public void unsubscribeFromDataStore() {
        compositeSubscription.clear();
    }
}
