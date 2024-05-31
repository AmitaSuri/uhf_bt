package com.example.uhf_bt;

import android.content.Intent;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;


public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "wtt.flutter.dev/uhf";

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            // This method is invoked on the main thread.
                            if (call.method.equals("apicall")) {
                                navigate();
                                result.success("Successful");
                            } else {
                                result.notImplemented();
                            }
                        }
                );
    }


    public void navigate() {
        Intent intent = new Intent(getApplicationContext(),ChainwayActivity.class);
        startActivity(intent);
    }

}

