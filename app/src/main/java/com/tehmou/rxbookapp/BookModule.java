package com.tehmou.rxbookapp;

import com.tehmou.rxbookapp.data.DataStore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ttuo on 07/06/14.
 */
@Module(
        injects = {
                BookFragment.class
        },
        library = true
)

public class BookModule {
    @Singleton
    @Provides
    DataStore provideDataStore() {
        return new DataStore();
    }
}
