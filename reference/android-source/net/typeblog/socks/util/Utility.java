package net.typeblog.socks.util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import net.typeblog.socks.R;
import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public class Utility {
    private static final String TAG;

    static {
        try {
            TAG = Class.forName(C0000.m4BtOFnJWxoF()).getSimpleName();
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static int exec(String str) {
        try {
            return Runtime.getRuntime().exec(str).waitFor();
        } catch (Exception e) {
            return -1;
        }
    }

    public static void killPidFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[512];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    try {
                        int i = fileInputStream.read(bArr, 0, 512);
                        if (i <= 0) {
                            break;
                        } else {
                            sb.append(new String(bArr, 0, i));
                        }
                    } catch (Exception e) {
                        return;
                    }
                }
                fileInputStream.close();
                try {
                    Runtime.getRuntime().exec(new StringBuffer().append(C0000.m192qeLzhNcgSy()).append(Integer.parseInt(sb.toString().trim().replace(C0000.m117YiCcKcMXzC(), ""))).toString()).waitFor();
                    if (!file.delete()) {
                        Log.w(TAG, C0000.m108WkmCMoXARb());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
            }
        }
    }

    public static String join(List<String> list, String str) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(str);
        }
        return sb.substring(0, sb.length() - str.length());
    }

    public static void makePdnsdConf(Context context, String str, int i) {
        String strReplace = context.getString(R.string.pdnsd_conf).replace(C0000.m128bndSdXuwuk(), context.getFilesDir().toString()).replace(C0000.m154hCeHYMkyCU(), str).replace(C0000.m183oqWYCZqAke(), Integer.toString(i));
        File file = new File(new StringBuffer().append(context.getFilesDir()).append(C0000.m124aNwErfRMTc()).toString());
        if (file.exists() && !file.delete()) {
            Log.w(TAG, C0000.m204tDzRqomgAV());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(strReplace.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file2 = new File(new StringBuffer().append(context.getFilesDir()).append(C0000.m62NmgkMdhrGq()).toString());
        if (!file2.exists()) {
            try {
                if (!file2.createNewFile()) {
                    Log.w(TAG, C0000.m114XbFEpxenVX());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void startVpn(Context context, Profile profile) {
        try {
            Intent intentPutExtra = new Intent(context, Class.forName(C0000.m58MyYQlTLDJS())).putExtra(C0000.m135cfzPSuwNHS(), profile.getName()).putExtra(C0000.m37IOqRzBtkIz(), profile.getServer()).putExtra(C0000.m109WqwoGezpre(), profile.getPort()).putExtra(C0000.m169kmhzwJKiau(), profile.getRoute()).putExtra(C0000.m227xsPeufMWoW(), profile.getDns()).putExtra(C0000.m36IDwoixjOtd(), profile.getDnsPort()).putExtra(C0000.m188poLhYRPDvu(), profile.isPerApp()).putExtra(C0000.m17EaSSLmlCbt(), profile.hasIPv6());
            if (profile.isUserPw()) {
                intentPutExtra.putExtra(C0000.m228yEoFuBSExP(), profile.getUsername()).putExtra(C0000.m206tUoaFKfDix(), profile.getPassword());
            }
            if (profile.isPerApp()) {
                intentPutExtra.putExtra(C0000.m52LzqpiAOdtl(), profile.isBypassApp()).putExtra(C0000.m193qebdKZbUmQ(), profile.getAppList().split(C0000.m224xEJrgyNBJq()));
            }
            if (profile.hasUDP()) {
                intentPutExtra.putExtra(C0000.m80QmKUmABifc(), profile.getUDPGW());
            }
            context.startService(intentPutExtra);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}