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
import java.util.UUID;

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
    private static String address = "00:12:02:22:06:61";

    private static final String TAG = "BlueTooth_Util";

    public BlueToothUtil(Context context) {
        this.context = context;
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothAdapter.cancelDiscovery();
        bluetoothDevice = bluetoothAdapter.getRemoteDevice(address);
    }

    public void IsBlueToothEnable(){
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled() || bluetoothDevice == null){
            Toast.makeText(context,"蓝牙不可用",Toast.LENGTH_SHORT).show();
        }
    }

    public void CreateBlueTooth(){
        try {
            bluetoothSocket =bluetoothDevice.createRfcommSocketToServiceRecord(MY_UUID);
            bluetoothSocket.connect();
        } catch (IOException e) {
            Log.d(TAG,e.getMessage());
            try {
                bluetoothSocket.close();
            } catch (IOException e1) {
                Log.d(TAG,e1.getMessage());
            }
        }
    }

    public void WriteData(String data){
        try {
            outputStream = bluetoothSocket.getOutputStream();
            inputStream = bluetoothSocket.getInputStream();
            byte[] msgBuffer = data.getBytes();
            outputStream.write(msgBuffer);
        } catch (IOException e) {
            Log.d(TAG,e.getMessage());
        }
    }

    public void CloseIO(){
        try {
            if (bluetoothSocket != null){
                bluetoothSocket.close();
            }
            if (outputStream != null){
                outputStream.flush();
                outputStream.close();
            }
            if (inputStream != null){
                inputStream.close();
            }
        } catch (IOException e) {
            Log.d(TAG,e.getMessage());
        }
    }


}
