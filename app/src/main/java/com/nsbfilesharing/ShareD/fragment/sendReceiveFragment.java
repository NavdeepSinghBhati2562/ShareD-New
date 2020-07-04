package com.nsbfilesharing.ShareD.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.genonbeta.TrebleShot.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.nsbfilesharing.ShareD.activity.ConnectionManagerActivity;
import com.nsbfilesharing.ShareD.activity.ContentSharingActivity;
import com.nsbfilesharing.ShareD.ui.callback.IconSupport;
import com.nsbfilesharing.ShareD.ui.callback.TitleSupport;


/**
 * A simple {@link Fragment} subclass.
 */
public class sendReceiveFragment extends Fragment implements IconSupport, TitleSupport {

    ExtendedFloatingActionButton sendBtn,receiveBtn;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public sendReceiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         preferences = this.getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);
         editor = preferences.edit();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_receive, container, false);
        sendBtn = view.findViewById(R.id.sendBtn);
        receiveBtn = view.findViewById(R.id.receiveBtn);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("sendReceive",1);
                editor.apply();
                startActivity(new Intent(getContext(), ContentSharingActivity.class));

            }
        });

        receiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("sendReceive",2);
                editor.apply();
                startActivity(new Intent(getContext(), ConnectionManagerActivity.class)
                        .putExtra(ConnectionManagerActivity.EXTRA_ACTIVITY_SUBTITLE, getString(R.string.text_receive))
                        .putExtra(ConnectionManagerActivity.EXTRA_REQUEST_TYPE, ConnectionManagerActivity.RequestType.MAKE_ACQUAINTANCE.toString()));

            }
        });
        return view;
    }



    @Override
    public int getIconRes()
    {
        return R.drawable.ic_swap_vert_white_24dp;
    }

    @Override
    public CharSequence getTitle(Context context)
    {
        return context.getString(R.string.text_send_receive);
    }

}
