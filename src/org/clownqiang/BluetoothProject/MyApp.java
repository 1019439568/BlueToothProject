package org.clownqiang.BluetoothProject;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by clownqiang on 14-5-22.
 */
public class MyApp extends Application {

    private BluetoothSocket bluetoothSocket = null;
    private BluetoothDevice bluetoothDevice = null;
    private BluetoothAdapter bluetoothAdapter = null;
    private static String address = "00:14:03:12:19:00";


    @Override
    public void onCreate() {
        super.onCreate();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter.isEnabled()) {
            bluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
            Method method = null;
            try {
                method = bluetoothDevice.getClass().getMethod("createRfcommSocket", new Class[]{int.class});
                bluetoothSocket = (BluetoothSocket) method.invoke(bluetoothDevice, 1);
                bluetoothSocket.connect();
            } catch (NoSuchMethodException e) {
                try {
                    bluetoothSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                try {
                    bluetoothSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                try {
                    bluetoothSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            } catch (IOException e) {
                try {
                    bluetoothSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

    public BluetoothSocket getBluetoothSocket() {
        return bluetoothSocket;
    }
}
