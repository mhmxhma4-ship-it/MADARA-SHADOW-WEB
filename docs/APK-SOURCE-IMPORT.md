# MADARA SHADOW APK source import

This folder preserves the readable/decompiled Java sources from the companion repository `mhmxhma4-ship-it/MADARA-SHADOW-` for porting and audit. These files are Android reference material; they are not compiled or executed by the Next.js website.

## Imported source

- MainActivity, ProfileFragment, SocksVpnService, IVpnService, BootReceiver
- Profile, ProfileManager, Constants, Routes, Utility
- Generated R and BuildConfig references
- The available obfuscated helper C0001

## Verified profile model from Profile.java and Constants.java

The Android app stores a profile with these settings:

- server host and port (default port in Java source: 1080)
- SOCKS username/password and an authentication-enabled flag
- route mode
- DNS host and DNS port (default 53)
- per-app routing, bypass mode, and app list
- IPv6 toggle
- UDP toggle and UDP gateway endpoint
- auto-connect toggle

Intent keys include SOCKSSERV, SOCKSPORT, SOCKSUNAME, SOCKSPASSWD, SOCKSUDPGW, SOCKSDNS, SOCKSDNSPORT, SOCKSROUTE, SOCKSIPV6, SOCKSPERAPP, SOCKSAPPBYPASS, SOCKSAPPLIST and SOCKSNAME.

## Important limitations

- The Android VPN service uses Android VpnService and native binaries. A browser page cannot run that Android TUN service or load Android .so files.
- The source tree available in the companion repository does not contain the native libraries, APK, classes.dex, Android manifest/resources, or the referenced obfuscated C0000 helper. The companion README describes a larger archive, but those files are not present in its Git tree.
- The decompiled Java calls obfuscated C0000 methods to assemble native command-line arguments and obtain defaults. Until C0000 and native artifacts are recovered, the exact executable arguments and default remote UDP gateway values cannot be verified.
- No valid Happ VPN import format has been verified here. Do not export a guessed file and call it compatible.

## Next porting work

1. Recover the missing C0000.java/classes.dex, manifest/resources and native artifacts from the extracted APK.
2. Decode the profile defaults and native command construction from those artifacts.
3. Implement a server-side profile/config export using verified values and confirm Happ's accepted import format.
4. Build a separate iOS-compatible VPN integration if system-wide VPN tunneling is required. A downloaded config alone does not implement a VPN engine.
