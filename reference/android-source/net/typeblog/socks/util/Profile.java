package net.typeblog.socks.util;

import android.content.SharedPreferences;
import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public class Profile {
    private final String mName;
    private final SharedPreferences mPref;
    private final String mPrefix;

    Profile(SharedPreferences sharedPreferences, String str) {
        this.mPref = sharedPreferences;
        this.mName = str;
        this.mPrefix = prefPrefix(str);
    }

    public String getName() {
        return this.mName;
    }

    public String getServer() {
        return this.mPref.getString(key(C0000.m168kliEpvZvkT()), C0000.m159jBjbUeDWQf());
    }

    public void setServer(String str) {
        this.mPref.edit().putString(key(C0000.m0ADskSLloSB()), str).apply();
    }

    public int getPort() {
        return this.mPref.getInt(key(C0000.m73PuMFoxVvFG()), 1080);
    }

    public void setPort(int i) {
        this.mPref.edit().putInt(key(C0000.m152gxLtTHJSRK()), i).apply();
    }

    public boolean isUserPw() {
        return this.mPref.getBoolean(key(C0000.m208tcETfHOZDi()), false);
    }

    public void setIsUserpw(boolean z) {
        this.mPref.edit().putBoolean(key(C0000.m39IZYnWESocX()), z).apply();
    }

    public String getUsername() {
        return this.mPref.getString(key(C0000.m85RuynPUVTcN()), "");
    }

    public void setUsername(String str) {
        this.mPref.edit().putString(key(C0000.m158iJDrVQAaiL()), str).apply();
    }

    public String getPassword() {
        return this.mPref.getString(key(C0000.m174mHKwRVXgXC()), "");
    }

    public void setPassword(String str) {
        this.mPref.edit().putString(key(C0000.m141eGidUdJAYt()), str).apply();
    }

    public String getRoute() {
        return this.mPref.getString(key(C0000.m126bAoGeAZcfE()), C0000.m84RjtPkHapGF());
    }

    public void setRoute(String str) {
        this.mPref.edit().putString(key(C0000.m157iEIpBHkwcP()), str).apply();
    }

    public String getDns() {
        return this.mPref.getString(key(C0000.m177mjZeuIYXBJ()), C0000.m205tFFSEKujKZ());
    }

    public void setDns(String str) {
        this.mPref.edit().putString(key(C0000.m230yyYTVxhgwq()), str).apply();
    }

    public int getDnsPort() {
        return this.mPref.getInt(key(C0000.m50LAviaeeHJD()), 53);
    }

    public void setDnsPort(int i) {
        this.mPref.edit().putInt(key(C0000.m22FwftInbStp()), i).apply();
    }

    public boolean isPerApp() {
        return this.mPref.getBoolean(key(C0000.m49KmTWpXqCNA()), false);
    }

    public void setIsPerApp(boolean z) {
        this.mPref.edit().putBoolean(key(C0000.m197rNoYPwIcVh()), z).apply();
    }

    public boolean isBypassApp() {
        return this.mPref.getBoolean(key(C0000.m105WbBpSoDukS()), false);
    }

    public void setIsBypassApp(boolean z) {
        this.mPref.edit().putBoolean(key(C0000.m100UqRxbeTnNX()), z).apply();
    }

    public String getAppList() {
        return this.mPref.getString(key(C0000.m119ZEhtGYHUKo()), "");
    }

    public void setAppList(String str) {
        this.mPref.edit().putString(key(C0000.m44JpgIVbaatM()), str).apply();
    }

    public boolean hasIPv6() {
        return this.mPref.getBoolean(key(C0000.m121Zbzpfpojvn()), false);
    }

    public void setHasIPv6(boolean z) {
        this.mPref.edit().putBoolean(key(C0000.m115YXTUKTnKau()), z).apply();
    }

    public boolean hasUDP() {
        return this.mPref.getBoolean(key(C0000.m165kJHvJqEGuM()), false);
    }

    public void setHasUDP(boolean z) {
        this.mPref.edit().putBoolean(key(C0000.m28GuxiVMHouM()), z).apply();
    }

    public String getUDPGW() {
        return this.mPref.getString(key(C0000.m26GlOYyCVBTA()), C0000.m113XGNDpVJiPU());
    }

    public void setUDPGW(String str) {
        this.mPref.edit().putString(key(C0000.m92TeTmNNdSVx()), str).apply();
    }

    public boolean autoConnect() {
        return this.mPref.getBoolean(key(C0000.m111XElZEFjDCh()), false);
    }

    public void setAutoConnect(boolean z) {
        this.mPref.edit().putBoolean(key(C0000.m179nHZGHGSdzj()), z).apply();
    }

    void delete() {
        this.mPref.edit().remove(key(C0000.m13DtzyXMkfVk())).remove(key(C0000.m90TKCveoFHkc())).remove(key(C0000.m142eQTFtMCeWs())).remove(key(C0000.m8CaXBwGrCcl())).remove(key(C0000.m94TroRbCaKiT())).remove(key(C0000.m95UPIQgZwNch())).remove(key(C0000.m148gLrTgRbuWJ())).remove(key(C0000.m53MOBgUaDikI())).remove(key(C0000.m106WfdWADypkK())).remove(key(C0000.m82QvjojgQcyC())).remove(key(C0000.m220vwzxrvLrtS())).remove(key(C0000.m203suKiOwmsxO())).remove(key(C0000.m201seHMUegSGW())).remove(key(C0000.m223xBmOxVqvSv())).remove(key(C0000.m93TffbtxAQMC())).apply();
    }

    private String key(String str) {
        return new StringBuffer().append(this.mPrefix).append(str).toString();
    }

    private static String prefPrefix(String str) {
        return str.replace(C0000.m226xcdKqhPCfv(), C0000.m89SoCItbNiaS()).replace(C0000.m164kGnyGotcPX(), C0000.m222wDCthWlTym());
    }
}