package com.nsbfilesharing.ShareD.callback;

import com.nsbfilesharing.ShareD.object.NetworkDevice;

import java.util.List;

public interface OnDeviceSelectedListener
{
    void onDeviceSelected(NetworkDevice.Connection connection, List<NetworkDevice.Connection> availableInterfaces);
}
