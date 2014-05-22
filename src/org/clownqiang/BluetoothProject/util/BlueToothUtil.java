package org.clownqiang.BluetoothProject.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.logging.Handler;

/**
 * Created by clownqiang on 14-5-18.
 */
public class BlueToothUtil {

    private Context context;
    private BluetoothAdapter bluetoothAdapter = null;
    private BluetoothSocket bluetoothSocket = null;
    private OutputStream outputStream = null;
    private InputStream inputStream = null;
    private BluetoothDevice bluetoothDevice = null;

    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static String address = "00:14:03:12:19:00";

    private static final String TAG = "BlueTooth_Util";

    public BlueToothUtil(Context context,BluetoothSocket bluetoothSocket) {
        this.context = context;
        this.bluetoothSocket = bluetoothSocket;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public boolean IsBlueToothOpen() {
        if (bluetoothAdapter.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public void WriteData(int data) {
        try {
            outputStream = bluetoothSocket.getOutputStream();
            inputStream = bluetoothSocket.getInputStream();
            byte[] msgBuffer = Integer.toString(data).getBytes();
            Log.d(TAG, msgBuffer.toString());
            outputStream.write(msgBuffer);
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public void CloseIO() {
        try {
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }


}
