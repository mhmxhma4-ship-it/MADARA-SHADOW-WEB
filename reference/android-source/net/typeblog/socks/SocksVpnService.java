package net.typeblog.socks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.VpnService;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.Locale;
import java.util.Objects;
import net.typeblog.socks.util.Routes;
import net.typeblog.socks.util.Utility;
import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public class SocksVpnService extends VpnService {
    private static final String TAG;
    public static boolean mRunning;
    private final IBinder mBinder = new VpnBinder(this);
    private ParcelFileDescriptor mInterface;

    public static native void SetUpUdp();

    class VpnBinder extends IVpnService.Stub {
        private final SocksVpnService this$0;

        @Override // net.typeblog.socks.IVpnService
        public boolean isRunning() {
            return SocksVpnService.mRunning;
        }

        @Override // net.typeblog.socks.IVpnService
        public void stop() {
            this.this$0.stopMe();
        }

        public VpnBinder(SocksVpnService socksVpnService) {
            this.this$0 = socksVpnService;
        }
    }

    static {
        java.lang.System.loadLibrary(C0000.m127biJeylTTVv());
        try {
            TAG = Class.forName(C0000.m176mjSplJnrJY()).getSimpleName();
            mRunning = false;
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Notification.Builder builder;
        if (intent == null || mRunning) {
            return 1;
        }
        String strM88SeOIvkkDfb = C0000.m88SeOIvkkDfb();
        String stringExtra = intent.getStringExtra(C0000.m215vIcDPEzvHA());
        int intExtra = intent.getIntExtra(C0000.m59NLKSBOGrLp(), 1080);
        String stringExtra2 = intent.getStringExtra(C0000.m47KZugVedIuS());
        String stringExtra3 = intent.getStringExtra(C0000.m147fzcCREzHoZ());
        String stringExtra4 = intent.getStringExtra(C0000.m146ficPeuFfue());
        String stringExtra5 = intent.getStringExtra(C0000.m74QIFfICCGJS());
        int intExtra2 = intent.getIntExtra(C0000.m31HNtysoDOXe(), 53);
        boolean booleanExtra = intent.getBooleanExtra(C0000.m103VnzrFnsxEp(), false);
        boolean booleanExtra2 = intent.getBooleanExtra(C0000.m5BuaUvtrTUs(), false);
        String[] stringArrayExtra = intent.getStringArrayExtra(C0000.m155hVzAUStclU());
        boolean booleanExtra3 = intent.getBooleanExtra(C0000.m133cYkeaXrlPM(), false);
        String stringExtra6 = intent.getStringExtra(C0000.m102VhnTNoEmNB());
        if (Build.VERSION.SDK_INT >= 26) {
            String strM112XFNFtVExLu = C0000.m112XFNFtVExLu();
            try {
                ((NotificationManager) Objects.requireNonNull((NotificationManager) getSystemService(Class.forName(C0000.m181nvrnNkHYDa())))).createNotificationChannel(new NotificationChannel(strM112XFNFtVExLu, getString(R.string.channel_name), 0));
                builder = new Notification.Builder(this, strM112XFNFtVExLu);
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError(e.getMessage());
            }
        } else {
            builder = new Notification.Builder(this);
        }
        try {
            startForeground(1, builder.setContentTitle(getString(R.string.notify_title)).setContentText(String.format(getString(R.string.notify_msg), strM88SeOIvkkDfb)).setPriority(-2).setSmallIcon(R.drawable.ic_vpn).setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, Class.forName(C0000.m57MwlRXhRpda())), 134217728)).build());
            configure(strM88SeOIvkkDfb, stringExtra4, booleanExtra, booleanExtra2, stringArrayExtra, booleanExtra3);
            if (this.mInterface != null) {
                start(this.mInterface.getFd(), stringExtra, intExtra, stringExtra2, stringExtra3, stringExtra5, intExtra2, booleanExtra3, stringExtra6);
            }
            new Thread(new Runnable(this) { // from class: net.typeblog.socks.SocksVpnService.100000000
                private final SocksVpnService this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (SocksVpnService.mRunning) {
                        SocksVpnService.SetUpUdp();
                    }
                }
            }).start();
            new UDPThread(this, this).start();
            return 1;
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public class UDPThread extends Thread {
        private final Handler mainHandler = new Handler(Looper.getMainLooper());
        private final SocksVpnService this$0;
        private final SocksVpnService vpnService;

        public UDPThread(SocksVpnService socksVpnService, SocksVpnService socksVpnService2) {
            this.this$0 = socksVpnService;
            this.vpnService = socksVpnService2;
        }

        /* JADX INFO: Infinite loop detected, blocks: 14, insns: 0 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Utility.exec(String.format(Locale.US, C0000.m134cbImEMDYWs(), this.vpnService.getApplicationInfo().nativeLibraryDir));
                } catch (Exception e) {
                    this.mainHandler.post(new Runnable(this, e.toString()) { // from class: net.typeblog.socks.SocksVpnService.UDPThread.100000001
                        private final UDPThread this$0;
                        private final String val$error;

                        {
                            this.this$0 = this;
                            this.val$error = str;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(this.this$0.vpnService, this.val$error, 0).show();
                        }
                    });
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // android.net.VpnService
    public void onRevoke() {
        super.onRevoke();
        stopMe();
    }

    @Override // android.net.VpnService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopMe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopMe() {
        stopForeground(true);
        Utility.killPidFile(new StringBuffer().append(getFilesDir()).append(C0000.m170lFRUoPJyNE()).toString());
        Utility.killPidFile(new StringBuffer().append(getFilesDir()).append(C0000.m161jRpIEIwcLF()).toString());
        try {
            System.jniclose(this.mInterface.getFd());
            this.mInterface.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        stopSelf();
    }

    private void configure(String str, String str2, boolean z, boolean z2, String[] strArr, boolean z3) {
        int i = 0;
        VpnService.Builder builder = new VpnService.Builder(this);
        builder.setMtu(1500).setSession(str).addAddress(C0000.m16ELkSFMfOhn(), 24).addDnsServer(C0000.m120ZIKJXDlXvX());
        if (z3) {
            builder.addAddress(C0000.m9DCUgftsNbA(), 126).addRoute(C0000.m51LhqFeqDnsc(), 0);
        }
        Routes.addRoutes(this, builder, str2);
        builder.addRoute(C0000.m163jpOHyoMqRZ(), 32);
        if (!z) {
            try {
                builder.addDisallowedApplication(C0000.m68ORjAtKYsae());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (z2) {
            try {
                builder.addDisallowedApplication(C0000.m209tdAKICaqhI());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            while (i < strArr.length) {
                String str3 = strArr[i];
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        builder.addDisallowedApplication(str3.trim());
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                i++;
            }
        } else {
            while (i < strArr.length) {
                String str4 = strArr[i];
                if (!TextUtils.isEmpty(str4) && !str4.trim().equals(C0000.m14DwdsiVdrPW())) {
                    try {
                        builder.addAllowedApplication(str4.trim());
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                i++;
            }
        }
        this.mInterface = builder.establish();
    }

    private void start(int i, String str, int i2, String str2, String str3, String str4, int i3, boolean z, String str5) {
        Utility.makePdnsdConf(this, str4, i3);
        Utility.exec(String.format(Locale.US, C0000.m172lUiNUvzIHm(), getApplicationInfo().nativeLibraryDir, getFilesDir()));
        String string = String.format(Locale.US, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(C0000.m225xVPMrNixmp()).append(C0000.m199sBaWacdMlE()).toString()).append(C0000.m229yUxanwSlsY()).toString()).append(C0000.m186pYyGmVLsMG()).toString()).append(C0000.m213uhWNLcYtLr()).toString()).append(C0000.m187pjlTXtNyZW()).toString()).append(C0000.m29GydQSvidgR()).toString()).append(C0000.m97UbMhKDnbmy()).toString(), getApplicationInfo().nativeLibraryDir, str, new Integer(i2), new Integer(i), getFilesDir(), getApplicationInfo().dataDir);
        if (str2 != null) {
            string = new StringBuffer().append(new StringBuffer().append(string).append(new StringBuffer().append(C0000.m69OmIkEMOWHD()).append(str2).toString()).toString()).append(new StringBuffer().append(C0000.m48KcoqmmOhgh()).append(str3).toString()).toString();
        }
        if (z) {
            string = new StringBuffer().append(string).append(C0000.m41JDfHnYTONY()).toString();
        }
        String string2 = new StringBuffer().append(string).append(C0000.m83RESllodGgg()).toString();
        if (str5 != null) {
            string2 = new StringBuffer().append(string2).append(new StringBuffer().append(C0000.m81QuZchkoolb()).append(str5).toString()).toString();
        }
        if (Utility.exec(string2) != 0) {
            stopMe();
            return;
        }
        int i4 = 0;
        while (i4 < 5) {
            if (System.sendfd(i, new StringBuffer().append(getApplicationInfo().dataDir).append(C0000.m184oyVWybgfXP()).toString()) != -1) {
                mRunning = true;
                return;
            }
            i4++;
            try {
                Thread.sleep(i4 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stopMe();
    }
}