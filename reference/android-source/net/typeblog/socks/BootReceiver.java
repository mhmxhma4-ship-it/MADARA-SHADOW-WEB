package net.typeblog.socks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import net.typeblog.socks.util.Profile;
import net.typeblog.socks.util.ProfileManager;
import net.typeblog.socks.util.Utility;
import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public class BootReceiver extends BroadcastReceiver {
    private static final String TAG;

    static {
        try {
            TAG = Class.forName(C0000.m233zgnbZttgja()).getSimpleName();
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Profile profile = new ProfileManager(context).getDefault();
            if (profile.autoConnect() && VpnService.prepare(context) == null) {
                Utility.startVpn(context, profile);
            }
        }
    }
}