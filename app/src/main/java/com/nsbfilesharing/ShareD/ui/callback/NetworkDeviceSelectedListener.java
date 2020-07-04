package com.nsbfilesharing.ShareD.ui.callback;

import com.nsbfilesharing.ShareD.object.NetworkDevice;

/**
 * created by: veli
 * date: 16/04/18 03:18
 */
public interface NetworkDeviceSelectedListener
{
    boolean onNetworkDeviceSelected(NetworkDevice networkDevice, NetworkDevice.Connection connection);

    boolean isListenerEffective();
}
