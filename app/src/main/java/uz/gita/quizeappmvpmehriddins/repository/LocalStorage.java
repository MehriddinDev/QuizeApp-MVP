package uz.gita.quizeappmvpmehriddins.repository;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorage {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private static LocalStorage localStorage;

    public LocalStorage(Context context) {
        preferences = context.getSharedPreferences("QUIZEAPP", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public static LocalStorage getInstance() {
        return localStorage;
    }

    public static void init(Context context) {
        if (localStorage == null) {
            localStorage = new LocalStorage(context);
        }
    }

    public void saveOnaTiliRecord(int n) {
        editor.putInt("ONATILI", n).apply();
    }

    public void saveTarixRecord(int n) {
        editor.putInt("TARIX", n).apply();
    }

    public void saveMatemRecord(int n) {
        editor.putInt("MATEM", n).apply();
    }

    public int getOnaTiliRec() {
        return preferences.getInt("ONATILI", 0);
    }

    public int getMatemRec() {
        return preferences.getInt("MATEM", 0);
    }

    public int getTarixRec() {
        return preferences.getInt("TARIX", 0);
    }


}
