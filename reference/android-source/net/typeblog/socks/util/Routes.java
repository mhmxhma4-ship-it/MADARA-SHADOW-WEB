package net.typeblog.socks.util;

import android.content.Context;
import android.net.VpnService;
import net.typeblog.socks.R;
import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public class Routes {
    public static void addRoutes(Context context, VpnService.Builder builder, String str) {
        String[] stringArray;
        if (Constants.ROUTE_CHN.equals(str)) {
            stringArray = context.getResources().getStringArray(R.array.simple_route);
        } else {
            stringArray = new String[]{C0000.m210trFNsMlMPB()};
        }
        for (String str2 : stringArray) {
            String[] strArrSplit = str2.split(C0000.m217vQfJkjwdnh());
            if (strArrSplit.length == 2 && !strArrSplit[0].startsWith(C0000.m87SHZgPbNHOq())) {
                builder.addRoute(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
            }
        }
    }
}