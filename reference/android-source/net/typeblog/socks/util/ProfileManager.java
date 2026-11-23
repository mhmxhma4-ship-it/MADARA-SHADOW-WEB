package net.typeblog.socks.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import net.typeblog.socks.R;
import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public class ProfileManager {
    private final Context mContext;
    private final SharedPreferences mPref;

    public ProfileManager(Context context) {
        this.mContext = context;
        this.mPref = this.mContext.getSharedPreferences(C0000.m198rOJDAoUWXp(), 0);
    }

    private List<String> getProfileList() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(this.mContext.getString(R.string.prof_default));
        for (String str : this.mPref.getString(C0000.m139dsmsBWzwCG(), "").split(C0000.m138dXDWtolncy())) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public String[] getProfiles() {
        return (String[]) getProfileList().toArray(new String[0]);
    }

    public Profile getProfile(String str) {
        return !getProfileList().contains(str) ? (Profile) null : new Profile(this.mPref, str);
    }

    public Profile getDefault() {
        return new Profile(this.mPref, this.mPref.getString(C0000.m40IwHeeUwOvp(), getProfileList().get(0)));
    }

    public void switchDefault(String str) {
        if (getProfileList().contains(str)) {
            this.mPref.edit().putString(C0000.m78QUUrkiLNDq(), str).apply();
        }
    }

    public Profile addProfile(String str) {
        List<String> profileList = getProfileList();
        if (profileList.contains(str)) {
            return (Profile) null;
        }
        profileList.add(str);
        profileList.remove(0);
        this.mPref.edit().putString(C0000.m91TPCBAaQaFn(), Utility.join(profileList, C0000.m18FAJlnPeCte())).putString(C0000.m30GyxaKEuAxD(), str).apply();
        return getDefault();
    }

    public boolean removeProfile(String str) {
        List<String> profileList = getProfileList();
        if (str.equals(profileList.get(0)) || !profileList.contains(str)) {
            return false;
        }
        new Profile(this.mPref, str).delete();
        profileList.remove(0);
        profileList.remove(str);
        this.mPref.edit().putString(C0000.m12Ddruwfaytm(), Utility.join(profileList, C0000.m38IVISZdNwpa())).remove(C0000.m71PSbqHTFFrY()).apply();
        return true;
    }
}