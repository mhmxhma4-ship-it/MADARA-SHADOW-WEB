package net.typeblog.socks;

import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
class System {
    public static native void jniclose(int i);

    public static native int sendfd(int i, String str);

    static {
        java.lang.System.loadLibrary(C0000.m123aGGYHXbuor());
    }
}