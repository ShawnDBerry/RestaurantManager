package com.example.restaurantmanagment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 404;

    @BindView(R.id.permissions_text_view)
    TextView permissionTextView;

    @BindView(R.id.crew_list_textview)
    TextView crewListTextView;

    @BindView(R.id.add_crew_member_button)
    Button addCrewMemberButton;

    @BindView(R.id.crew_management_recycler_view)
    RecyclerView crewManagementRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        permissionTextView.setVisibility(View.GONE);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            requestPermission();
        }

    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}
                , REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE) {

            if (permissions[0].equals(Manifest.permission.CAMERA)
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera permission have been granted"
                        , Toast.LENGTH_SHORT).show();

                permissionTextView.setVisibility(View.GONE);

            } else if (permissions[0].equals(Manifest.permission.CAMERA)) {

                permissionTextView.setVisibility(View.GONE);
                crewManagementRecyclerView.setVisibility(View.GONE);
                addCrewMemberButton.setVisibility(View.GONE);
                crewListTextView.setVisibility(View.GONE);
                if (ActivityCompat.shouldShowRequestPermissionRationale(this
                        , Manifest.permission.CAMERA)) {

                    requestPermission();

                } else {
                    Log.d("TAG_Q", "onRequestPermissionsResult: FAILED");
                    Toast.makeText(this, "No Camera Access...", Toast.LENGTH_SHORT).show();
                    crewManagementRecyclerView.setVisibility(View.GONE);
                    addCrewMemberButton.setVisibility(View.GONE);
                    crewListTextView.setVisibility(View.GONE);

                    permissionTextView.setText("Permission must be granted from phone settings \n" +
                            "to use this application click here and go to the settings");

                    permissionTextView.setOnClickListener(v -> {
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                    });
                }
            }
        }
    }
}
