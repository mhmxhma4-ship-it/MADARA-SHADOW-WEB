package net.typeblog.socks;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import p000.p001.p002.C0000;

/* JADX INFO: loaded from: /data/data/com.termux/files/home/SHADOW_ANALYSIS/extracted/classes.dex */
public interface IVpnService extends IInterface {
    boolean isRunning() throws RemoteException;

    void stop() throws RemoteException;

    public static abstract class Stub extends Binder implements IVpnService {
        private static final String DESCRIPTOR = "net.typeblog.socks.IVpnService";
        static final int TRANSACTION_isRunning = 1;
        static final int TRANSACTION_stop = 2;

        public Stub() {
            attachInterface(this, C0000.m211ubdMVqpPFW());
        }

        public static IVpnService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return (IVpnService) null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(C0000.m42JTsXqeMbka());
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IVpnService)) {
                return (IVpnService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String strM65NwVfUFOizK = C0000.m65NwVfUFOizK();
            switch (i) {
                case TRANSACTION_isRunning /* 1 */:
                    parcel.enforceInterface(strM65NwVfUFOizK);
                    boolean zIsRunning = isRunning();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsRunning ? TRANSACTION_isRunning : 0);
                    return true;
                case TRANSACTION_stop /* 2 */:
                    parcel.enforceInterface(strM65NwVfUFOizK);
                    stop();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(strM65NwVfUFOizK);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IVpnService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return C0000.m175mgmLocZVLf();
            }

            @Override // net.typeblog.socks.IVpnService
            public boolean isRunning() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(C0000.m63NoiUUWOKxH());
                    this.mRemote.transact(Stub.TRANSACTION_isRunning, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? Stub.TRANSACTION_isRunning : false;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // net.typeblog.socks.IVpnService
            public void stop() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(C0000.m145fKXrYIkTkw());
                    this.mRemote.transact(Stub.TRANSACTION_stop, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}