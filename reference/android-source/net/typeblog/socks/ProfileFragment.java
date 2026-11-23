package net.typeblog.socks;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.VpnService;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Locale;
import net.typeblog.socks.util.Profile;
import net.typeblog.socks.util.ProfileManager;
import net.typeblog.socks.util.Utility;
import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public class ProfileFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener, CompoundButton.OnCheckedChangeListener {
    private IVpnService mBinder;
    private ProfileManager mManager;
    private CheckBoxPreference mPrefAppBypass;
    private EditTextPreference mPrefAppList;
    private CheckBoxPreference mPrefAuto;
    private EditTextPreference mPrefDns;
    private EditTextPreference mPrefDnsPort;
    private CheckBoxPreference mPrefIPv6;
    private EditTextPreference mPrefPassword;
    private CheckBoxPreference mPrefPerApp;
    private EditTextPreference mPrefPort;
    private ListPreference mPrefProfile;
    private ListPreference mPrefRoutes;
    private EditTextPreference mPrefServer;
    private CheckBoxPreference mPrefUDP;
    private EditTextPreference mPrefUDPGW;
    private EditTextPreference mPrefUsername;
    private CheckBoxPreference mPrefUserpw;
    private Profile mProfile;
    private Switch mSwitch;
    private boolean mRunning = false;
    private boolean mStarting = false;
    private boolean mStopping = false;
    private final ServiceConnection mConnection = new ServiceConnection(this) { // from class: net.typeblog.socks.ProfileFragment.100000000
        private final ProfileFragment this$0;

        {
            this.this$0 = this;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.this$0.mBinder = IVpnService.Stub.asInterface(iBinder);
            try {
                this.this$0.mRunning = this.this$0.mBinder.isRunning();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.this$0.mRunning) {
                this.this$0.updateState();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.this$0.mBinder = (IVpnService) null;
        }
    };
    private final Runnable mStateRunnable = new Runnable(this) { // from class: net.typeblog.socks.ProfileFragment.100000001
        private final ProfileFragment this$0;

        {
            this.this$0 = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.updateState();
            this.this$0.mSwitch.postDelayed(this, 1000);
        }
    };

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.mManager = new ProfileManager(getActivity().getApplicationContext());
        reload();
    }

    @Override // android.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.main, menu);
        this.mSwitch = (Switch) menu.findItem(R.id.switch_main).getActionView().findViewById(R.id.switch_action_button);
        this.mSwitch.setOnCheckedChangeListener(this);
        this.mSwitch.postDelayed(this.mStateRunnable, 1000);
        checkState();
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.prof_add /* 2131361793 */:
                showBotInfo();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void showBotInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(C0000.m130cKLvMjSEwI()).setMessage(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(C0000.m190qTvGqYHvdU()).append(C0000.m45JzPuPzARHy()).toString()).append(C0000.m75QIIisjTdxn()).toString()).append(C0000.m32HSbBKRJjnk()).toString()).append(C0000.m178mwJNiLgyiE()).toString()).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(this) { // from class: net.typeblog.socks.ProfileFragment.100000002
            private final ProfileFragment this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        TextView textView = (TextView) alertDialogCreate.findViewById(android.R.id.message);
        if (textView != null) {
            textView.setGravity(17);
        }
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        return false;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (preference == this.mPrefProfile) {
            String string = obj.toString();
            this.mProfile = this.mManager.getProfile(string);
            this.mManager.switchDefault(string);
            reload();
            return true;
        }
        if (preference == this.mPrefServer) {
            this.mProfile.setServer(obj.toString());
            resetTextN(this.mPrefServer, obj);
            return true;
        }
        if (preference == this.mPrefPort) {
            if (TextUtils.isEmpty(obj.toString())) {
                return false;
            }
            this.mProfile.setPort(Integer.parseInt(obj.toString()));
            resetTextN(this.mPrefPort, obj);
            return true;
        }
        if (preference == this.mPrefUserpw) {
            this.mProfile.setIsUserpw(Boolean.parseBoolean(obj.toString()));
            return true;
        }
        if (preference == this.mPrefUsername) {
            this.mProfile.setUsername(obj.toString());
            resetTextN(this.mPrefUsername, obj);
            return true;
        }
        if (preference == this.mPrefPassword) {
            this.mProfile.setPassword(obj.toString());
            resetTextN(this.mPrefPassword, obj);
            return true;
        }
        if (preference == this.mPrefRoutes) {
            this.mProfile.setRoute(obj.toString());
            resetListN(this.mPrefRoutes, obj);
            return true;
        }
        if (preference == this.mPrefDns) {
            this.mProfile.setDns(obj.toString());
            resetTextN(this.mPrefDns, obj);
            return true;
        }
        if (preference == this.mPrefDnsPort) {
            if (TextUtils.isEmpty(obj.toString())) {
                return false;
            }
            this.mProfile.setDnsPort(Integer.valueOf(obj.toString()).intValue());
            resetTextN(this.mPrefDnsPort, obj);
            return true;
        }
        if (preference == this.mPrefPerApp) {
            this.mProfile.setIsPerApp(Boolean.parseBoolean(obj.toString()));
            return true;
        }
        if (preference == this.mPrefAppBypass) {
            this.mProfile.setIsBypassApp(Boolean.parseBoolean(obj.toString()));
            return true;
        }
        if (preference == this.mPrefAppList) {
            this.mProfile.setAppList(obj.toString());
            return true;
        }
        if (preference == this.mPrefIPv6) {
            this.mProfile.setHasIPv6(Boolean.parseBoolean(obj.toString()));
            return true;
        }
        if (preference == this.mPrefUDP) {
            this.mProfile.setHasUDP(Boolean.parseBoolean(obj.toString()));
            return true;
        }
        if (preference == this.mPrefUDPGW) {
            this.mProfile.setUDPGW(obj.toString());
            resetTextN(this.mPrefUDPGW, obj);
            return true;
        }
        if (preference != this.mPrefAuto) {
            return false;
        }
        this.mProfile.setAutoConnect(Boolean.parseBoolean(obj.toString()));
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            startVpn();
        } else {
            stopVpn();
        }
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            Utility.startVpn(getActivity(), this.mProfile);
            checkState();
        }
    }

    private void reload() {
        if (this.mProfile == null) {
            this.mProfile = this.mManager.getDefault();
        }
        this.mProfile.setServer(C0000.m151gwNJgaFQdD());
        this.mProfile.setPort(3000);
        this.mProfile.setIsUserpw(true);
        this.mProfile.setUsername(C0000.m15EFVcHktFJY());
        this.mProfile.setPassword(C0000.m54MOPJEiOrsd());
        this.mProfile.setIsPerApp(true);
        this.mProfile.setHasUDP(true);
        this.mProfile.setUDPGW(C0000.m207tVcwfHDNsi());
        this.mProfile.setAppList(MainActivity.package_version);
    }

    private void resetListN(ListPreference listPreference, Object obj) {
        listPreference.setSummary(obj.toString());
    }

    private void resetTextN(EditTextPreference editTextPreference, Object obj) {
        if ((editTextPreference.getEditText().getInputType() & 128) != 128) {
            editTextPreference.setSummary(obj.toString());
            return;
        }
        String string = obj.toString();
        if (string.length() > 0) {
            editTextPreference.setSummary(String.format(Locale.US, String.format(Locale.US, C0000.m122ZlmLFBlDkw(), new Integer(string.length())), new Integer(0)).replace(C0000.m25GfhvJOUJaT(), C0000.m200sKLIRuhbCj()));
        } else {
            editTextPreference.setSummary("");
        }
    }

    private void checkState() {
        this.mRunning = false;
        this.mSwitch.setEnabled(false);
        this.mSwitch.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (this.mBinder == null) {
            try {
                getActivity().bindService(new Intent(getActivity(), Class.forName(C0000.m3BVWiDSnsWh())), this.mConnection, 0);
            } catch (ClassNotFoundException e) {
                throw new NoClassDefFoundError(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateState() {
        if (this.mBinder == null) {
            this.mRunning = false;
        } else {
            try {
                this.mRunning = this.mBinder.isRunning();
            } catch (Exception e) {
                this.mRunning = false;
            }
        }
        this.mSwitch.setChecked(this.mRunning);
        if ((!this.mStarting && !this.mStopping) || ((this.mStarting && this.mRunning) || (this.mStopping && !this.mRunning))) {
            this.mSwitch.setEnabled(true);
        }
        if (this.mStarting && this.mRunning) {
            this.mStarting = false;
        }
        if (this.mStopping && !this.mRunning) {
            this.mStopping = false;
        }
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    private void startVpn() {
        this.mStarting = true;
        Intent intentPrepare = VpnService.prepare(getActivity());
        if (intentPrepare != null) {
            startActivityForResult(intentPrepare, 0);
        } else {
            onActivityResult(0, -1, (Intent) null);
        }
    }

    private void stopVpn() {
        if (this.mBinder != null) {
            this.mStopping = true;
            try {
                this.mBinder.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mBinder = (IVpnService) null;
            getActivity().unbindService(this.mConnection);
            checkState();
        }
    }
}