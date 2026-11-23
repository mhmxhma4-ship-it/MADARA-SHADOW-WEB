package p003.p004.p005;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import p006.p007.p008.C0002;

/* JADX INFO: renamed from: ᴵʽʾᵔʾﾞʽـ.ˋˑיˏـﹶˈʾ.ˑﾞˏʻⁱﹶʼᐧ.ʾﹳⁱˑﾞﹳᵢ, reason: contains not printable characters */
/* JADX INFO: compiled from: BYDecoder.java */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public class C0001 {
    public static String s1 = "fff";
    public static String s2 = "fsghff";

    public static String decode() {
        String text = C0002.s1;
        String result = decode(text, "#pass");
        return result;
    }

    /* JADX INFO: renamed from: יᵎˋˉﾞﹳˏᐧ, reason: contains not printable characters */
    public static String m235(String text, String pass) {
        byte[] result;
        int hexlen = text.length();
        if (hexlen % 2 == 1) {
            hexlen++;
            result = new byte[hexlen / 2];
            text = "0" + text;
        } else {
            result = new byte[hexlen / 2];
        }
        int j = 0;
        for (int i = 0; i < hexlen; i += 2) {
            result[j] = (byte) Integer.parseInt(text.substring(i, i + 2), 16);
            j++;
        }
        byte[] decrypt = null;
        try {
            Key key = new SecretKeySpec(pass.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);
            decrypt = cipher.doFinal(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(decrypt);
    }
}