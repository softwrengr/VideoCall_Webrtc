package com.softwr.samplevideocall.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.softwr.samplevideocall.R;
import com.softwr.samplevideocall.databinding.ActivityMainBinding;
import com.softwr.samplevideocall.helpers.ChatApplication;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //connecting socket
        ChatApplication app = new ChatApplication();
        Socket mSocket = app.getSocket();
        mSocket.connect();


        binding.audioCall.setOnClickListener(v -> {
            startActivity(new Intent(this, ChatActivity.class));
        });

        binding.videoCall.setOnClickListener(v -> {
            startActivity(new Intent(this, ChatActivity.class));
        });

    }

    //connecting socket
    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "connect", Toast.LENGTH_SHORT).show();

                }
            });
        }

    };

    //showing error in connecting socket
    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "connect", Toast.LENGTH_SHORT).show();

                }
            });
        }

    };
}