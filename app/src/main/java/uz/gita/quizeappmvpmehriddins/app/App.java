package uz.gita.quizeappmvpmehriddins.app;

import android.app.Application;

import uz.gita.quizeappmvpmehriddins.repository.LocalStorage;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LocalStorage.init(this);
    }
}
