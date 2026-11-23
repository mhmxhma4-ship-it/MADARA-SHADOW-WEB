package net.typeblog.socks;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Iterator;
import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public class MainActivity extends Activity {
    private static final String LAST_LOGIN_DATE_KEY = "last_login_date";
    private static final int LOGIN_EXPIRY_DAYS = 2;
    private static final String PASSWORD_KEY = "password";
    private static final String PREFS_NAME = "MyPrefs";
    private static final String REMEMBER_ME_KEY = "remember_me";
    private static final String USERNAME_KEY = "username";
    public static String package_version;

    public native void CheckUdpOnline();

    public native void FreeVersion_Check(Context context);

    public native String Ghost();

    public native String Login(Context context, String str, String str2);

    public native int dp(int i);

    static {
        java.lang.System.loadLibrary(C0000.m131cKYaheTxrl());
    }

    public void SelectVersion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(C0000.m60NgOSDdAaCm());
        builder.setMessage(C0000.m77QPHyQqZrHM());
        builder.setPositiveButton(C0000.m219vvsyEWhghb(), new DialogInterface.OnClickListener(this) { // from class: net.typeblog.socks.MainActivity.100000000
            private final MainActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.package_version = C0000.m101VArIkgMgYe();
                this.this$0.getFragmentManager().beginTransaction().replace(android.R.id.content, new ProfileFragment()).commit();
            }
        });
        builder.setNegativeButton(C0000.m86RvLVGdOdyN(), new DialogInterface.OnClickListener(this) { // from class: net.typeblog.socks.MainActivity.100000001
            private final MainActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.package_version = C0000.m143eaLRRIyMWq();
                this.this$0.getFragmentManager().beginTransaction().replace(android.R.id.content, new ProfileFragment()).commit();
            }
        });
        builder.setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        TextView textView = (TextView) alertDialogCreate.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setGravity(17);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isInternetAvailable(this)) {
            errorconnection(this);
        } else {
            CheckUdpOnline();
        }
    }

    public static boolean isVpnRunning(Context context) {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService(C0000.m19FPTbdvvvSd())).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            try {
                if (Class.forName(C0000.m129cIBUmmeJVl()).getName().equals(it.next().service.getClassName())) {
                    return true;
                }
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError(e.getMessage());
            }
        }
        return false;
    }

    void setupview() {
        Toast.makeText(getApplicationContext(), Html.fromHtml(Ghost()), 1).show();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor(C0000.m46KLkKhpaGQJ()));
        linearLayout.setPadding(16, 16, 16, 16);
        String strM214uuWEzuwGZX = C0000.m214uuWEzuwGZX();
        TextView textView = new TextView(this);
        SpannableString spannableString = new SpannableString(strM214uuWEzuwGZX);
        textView.setText(spannableString);
        textView.setTypeface(Typeface.MONOSPACE, 3);
        textView.setTextSize(15);
        textView.setTextColor(Color.parseColor(C0000.m185pEiQlFiijJ()));
        linearLayout.addView(textView);
        setContentView(linearLayout);
        int[] iArr = {-65536, Color.parseColor(C0000.m21FbLYEWHmaz()), -16711936, Color.parseColor(C0000.m7CHtRZKxVqt()), -256, -16776961, -16711681};
        Handler handler = new Handler();
        handler.post(new Runnable(this, strM214uuWEzuwGZX, iArr, spannableString, textView, handler) { // from class: net.typeblog.socks.MainActivity.100000002
            private final MainActivity this$0;
            private final int[] val$colors;
            private final Handler val$handler;
            private final SpannableString val$spannable;
            private final String val$text;
            private final TextView val$textView;
            int step = 0;
            int colorIndex = 0;

            {
                this.this$0 = this;
                this.val$text = strM214uuWEzuwGZX;
                this.val$colors = iArr;
                this.val$spannable = spannableString;
                this.val$textView = textView;
                this.val$handler = handler;
            }

            @Override // java.lang.Runnable
            public void run() {
                int length = this.val$text.length();
                if (this.step <= length / MainActivity.LOGIN_EXPIRY_DAYS) {
                    int i = this.step;
                    int i2 = (length - 1) - this.step;
                    int i3 = this.val$colors[this.colorIndex];
                    if (i < length) {
                        this.val$spannable.setSpan(new ForegroundColorSpan(i3), i, i + 1, 33);
                    }
                    if (i2 > i && i2 < length) {
                        this.val$spannable.setSpan(new ForegroundColorSpan(i3), i2, i2 + 1, 33);
                    }
                    this.val$textView.setText(this.val$spannable);
                    this.step++;
                    if (this.step > length / MainActivity.LOGIN_EXPIRY_DAYS) {
                        this.colorIndex = (this.colorIndex + 1) % this.val$colors.length;
                        this.step = 0;
                    }
                    this.val$handler.postDelayed(this, 1);
                }
            }
        });
    }

    private boolean isLoginExpired() {
        long j = getSharedPreferences(C0000.m56MoMuFlxgMZ(), 0).getLong(C0000.m231zJnjLNyZaG(), 0);
        if (j == 0) {
            return true;
        }
        return (java.lang.System.currentTimeMillis() - j) / ((long) 86400000) > ((long) LOGIN_EXPIRY_DAYS);
    }

    private void GHOST_LOGIN(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        TextView textView = new TextView(context);
        textView.setText(C0000.m6CDcNhYlFae());
        textView.setTextColor(-65536);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setTextSize(20);
        textView.setPadding(0, 40, 0, 40);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(1, 20, 1, 10);
        EditText editText = new EditText(context);
        editText.setHint(C0000.m76QJjWZtCHZJ());
        editText.setTypeface(Typeface.MONOSPACE, 1);
        EditText editText2 = new EditText(context);
        editText2.setHint(C0000.m27GlXQLxKHCD());
        editText2.setTypeface(Typeface.MONOSPACE, 1);
        editText2.setInputType(129);
        CheckBox checkBox = new CheckBox(context);
        checkBox.setText(C0000.m66OMUPCGihbN());
        checkBox.setTypeface(Typeface.MONOSPACE, 1);
        SharedPreferences sharedPreferences = getSharedPreferences(C0000.m202sgEGpYnerY(), 0);
        if (sharedPreferences.getBoolean(C0000.m98UjHkWztEuW(), false)) {
            editText.setText(sharedPreferences.getString(C0000.m43JYAsHmRfnc(), ""));
            editText2.setText(sharedPreferences.getString(C0000.m221vxUSgkOpkw(), ""));
            checkBox.setChecked(true);
        }
        linearLayout2.addView(editText);
        linearLayout2.addView(editText2);
        linearLayout2.addView(checkBox);
        linearLayout.addView(linearLayout2);
        ScrollView scrollView = new ScrollView(context);
        scrollView.addView(linearLayout);
        builder.setView(scrollView);
        builder.setPositiveButton(C0000.m144fHFCOwvmgp(), new DialogInterface.OnClickListener(this, editText, editText2, checkBox, context) { // from class: net.typeblog.socks.MainActivity.100000003
            private final MainActivity this$0;
            private final Context val$context;
            private final EditText val$passwordInput;
            private final CheckBox val$rememberMeCheckBox;
            private final EditText val$usernameInput;

            {
                this.this$0 = this;
                this.val$usernameInput = editText;
                this.val$passwordInput = editText2;
                this.val$rememberMeCheckBox = checkBox;
                this.val$context = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String lowerCase = this.val$usernameInput.getText().toString().replaceAll(C0000.m10DCyfjJqlod(), "").toLowerCase();
                String lowerCase2 = this.val$passwordInput.getText().toString().replaceAll(C0000.m79QhnWPnRwJE(), "").toLowerCase();
                boolean zIsChecked = this.val$rememberMeCheckBox.isChecked();
                SharedPreferences.Editor editorEdit = this.val$context.getSharedPreferences(C0000.m194qlAUKombut(), 0).edit();
                if (zIsChecked) {
                    editorEdit.putString(C0000.m167kaynTEzOLd(), lowerCase);
                    editorEdit.putString(C0000.m153hCSEpuVFzn(), lowerCase2);
                    editorEdit.putBoolean(C0000.m34HaPhkguEcg(), true);
                } else {
                    editorEdit.remove(C0000.m72PnnOahTcUA());
                    editorEdit.remove(C0000.m180nsJeRqBMYr());
                    editorEdit.remove(C0000.m160jHBNohLFnG());
                    editorEdit.remove(C0000.m166kPsFDCxqhc());
                }
                if (!MainActivity.isInternetAvailable(this.val$context)) {
                    this.this$0.errorconnection(this.val$context);
                    return;
                }
                String strLogin = this.this$0.Login(this.val$context, lowerCase, lowerCase2);
                if (strLogin.equals(C0000.m1ANpeHYXJXL())) {
                    this.this$0.update(this.val$context);
                    Process.killProcess(Process.myPid());
                }
                if (strLogin.equals(C0000.m99UkTUECKvCX())) {
                    this.this$0.update(this.val$context);
                } else if (strLogin.equals(C0000.m182obVJgPJCbY())) {
                    this.this$0.errorvpn(this.val$context);
                } else if (strLogin.equals(C0000.m162jgVLUgcLMR())) {
                    this.this$0.errorlogin(this.val$context);
                } else {
                    Toast.makeText(this.val$context, C0000.m196qpGGRgFBNg(), 0).show();
                    this.this$0.SelectVersion();
                }
                editorEdit.apply();
            }
        });
        builder.setNegativeButton(C0000.m64NqbxkYPJBn(), new DialogInterface.OnClickListener(this) { // from class: net.typeblog.socks.MainActivity.100000004
            private final MainActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Process.killProcess(Process.myPid());
            }
        });
        builder.create().show();
    }

    void userpass(Context context) {
        Intent intent = new Intent(C0000.m96UVaPPEVaVD(), Uri.parse(C0000.m67OMlnakrKcC()));
        intent.addFlags(268435456);
        context.startActivity(intent);
        Toast.makeText(context, C0000.m171lOMogUoTov(), 1).show();
    }

    void errorlogin(Context context) {
        userpass(context);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(C0000.m35HmAlIcBdWJ()).setMessage(C0000.m61NgtFcmcRbn()).setCancelable(false).setPositiveButton(C0000.m212ucLngYmpPZ(), new DialogInterface.OnClickListener(this) { // from class: net.typeblog.socks.MainActivity.100000005
            private final MainActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Process.killProcess(Process.myPid());
            }
        });
        builder.create().show();
    }

    void errorconnection(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(C0000.m116YgOeVGrTJk()).setMessage(C0000.m70OzkmjSPcgm()).setCancelable(false).setPositiveButton(C0000.m189qAhchoqwBR(), new DialogInterface.OnClickListener(this) { // from class: net.typeblog.socks.MainActivity.100000006
            private final MainActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Process.killProcess(Process.myPid());
            }
        });
        builder.create().show();
    }

    void update(Context context) {
        Intent intent = new Intent(C0000.m156hyKGZCBTjT(), Uri.parse(C0000.m140eERxOgaTNn()));
        intent.addFlags(268435456);
        context.startActivity(intent);
        Toast.makeText(context, C0000.m191qXCKiMZkxn(), 1).show();
    }

    void errorvpn(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(C0000.m20FZlKlrwGjJ()).setMessage(C0000.m24GGvrXZzqXR()).setCancelable(false).setPositiveButton(C0000.m137dKQCstLlWc(), new DialogInterface.OnClickListener(this) { // from class: net.typeblog.socks.MainActivity.100000007
            private final MainActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Process.killProcess(Process.myPid());
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isInternetAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(C0000.m218vnWgleibVB())).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private View GhostMessage() {
        Context applicationContext = getApplicationContext();
        ScrollView scrollView = new ScrollView(applicationContext);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(applicationContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(dp(15), dp(15), dp(15), dp(15));
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setVerticalScrollBarEnabled(true);
        linearLayout.setHorizontalScrollBarEnabled(true);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dp(10);
        textView.setLayoutParams(layoutParams2);
        textView.setTypeface((Typeface) null, 1);
        textView.setTextSize(15);
        textView.setText(C0000.m107WjSnICXBGQ());
        TextView textView2 = new TextView(applicationContext);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = dp(10);
        textView2.setLayoutParams(layoutParams3);
        textView2.setText(C0000.m132cXLgIGFQaO());
        textView2.setTypeface(Typeface.MONOSPACE);
        textView2.setTextColor(Color.parseColor(C0000.m2BCepyMCCbv()));
        textView2.setClickable(true);
        textView2.setOnClickListener(new View.OnClickListener(this) { // from class: net.typeblog.socks.MainActivity.100000008
            private final MainActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.this$0.startActivity(new Intent(C0000.m195qlKVDfcKaT(), Uri.parse(C0000.m216vQIaqBpLmG())));
            }
        });
        TextView textView3 = new TextView(applicationContext);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = dp(5);
        textView3.setLayoutParams(layoutParams4);
        textView3.setText(C0000.m11DFbCPiCqgT());
        textView3.setTextSize(14);
        TextView textView4 = new TextView(applicationContext);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = dp(10);
        textView4.setLayoutParams(layoutParams5);
        textView4.setText(C0000.m234zzmFLuYwCg());
        textView4.setTypeface(Typeface.MONOSPACE);
        textView4.setTextColor(Color.parseColor(C0000.m149ggWZGhJRaK()));
        textView4.setClickable(true);
        textView4.setOnClickListener(new View.OnClickListener(this) { // from class: net.typeblog.socks.MainActivity.100000009
            private final MainActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.this$0.startActivity(new Intent(C0000.m110WvbelnMkNM(), Uri.parse(C0000.m232zQsZTLGEuT())));
            }
        });
        TextView textView5 = new TextView(applicationContext);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = dp(10);
        textView5.setLayoutParams(layoutParams6);
        textView5.setText(C0000.m173lpjJYenPJB());
        textView5.setTextSize(12);
        textView5.setTypeface(Typeface.MONOSPACE);
        textView5.setTextColor(-65536);
        textView5.setClickable(true);
        textView5.setOnClickListener(new View.OnClickListener(this) { // from class: net.typeblog.socks.MainActivity.100000010
            private final MainActivity this$0;

            {
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.this$0.startActivity(new Intent(C0000.m23GAjgxlAxOj(), Uri.parse(C0000.m33HWNWdsJKps())));
            }
        });
        linearLayout.addView(textView);
        linearLayout.addView(textView3);
        linearLayout.addView(textView4);
        linearLayout.addView(textView5);
        scrollView.addView(linearLayout);
        return scrollView;
    }

    public void ShowUpdateDialog(Context context, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(C0000.m125abigwakrKs());
        builder.setMessage(C0000.m136cuwHymirZT());
        builder.setPositiveButton(C0000.m118ZBlMARnduU(), new DialogInterface.OnClickListener(this, str, context) { // from class: net.typeblog.socks.MainActivity.100000011
            private final MainActivity this$0;
            private final Context val$context;
            private final String val$link;

            {
                this.this$0 = this;
                this.val$link = str;
                this.val$context = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent intent = new Intent(C0000.m104VqNJhgJVrZ(), Uri.parse(this.val$link));
                intent.addFlags(268435456);
                this.val$context.startActivity(intent);
                this.this$0.finish();
            }
        });
        builder.setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        TextView textView = (TextView) alertDialogCreate.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setGravity(17);
        }
    }

    void GHOST_ALERT(Context context) {
        View viewGhostMessage = GhostMessage();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(C0000.m55MZXmdXUVpK()).setView(viewGhostMessage).setCancelable(false).setPositiveButton(C0000.m150gtvuGVkoIM(), new DialogInterface.OnClickListener(this, context) { // from class: net.typeblog.socks.MainActivity.100000012
            private final MainActivity this$0;
            private final Context val$context;

            {
                this.this$0 = this;
                this.val$context = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.this$0.FreeVersion_Check(this.val$context);
            }
        });
        builder.create().show();
    }
}