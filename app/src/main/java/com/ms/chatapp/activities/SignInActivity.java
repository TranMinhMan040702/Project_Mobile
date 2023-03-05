package com.ms.chatapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.ms.chatapp.R;
import com.ms.chatapp.databinding.ActivitySignInBinding;
import com.ms.chatapp.dtos.auth.LoginRequest;
import com.ms.chatapp.models.User;
import com.ms.chatapp.repositories.auth.AuthRepository;
import com.ms.chatapp.repositories.user.UserRepository;

import java.util.UUID;

public class SignInActivity extends AppCompatActivity {

    // Tự đông binding các đối tượng trong layout
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners() {
        binding.textCreateNewAccount.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
        });
        binding.btnSignIn.setOnClickListener(view -> {
            if (isValidSignUpDetails()) signIn();
        });
    }
    private void signIn() {
        String userName = binding.inputUsername.getText().toString();
        String password = binding.inputPassword.getText().toString();
        boolean Logging = true;
        AuthRepository.getInstance().Login(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!Logging)
                    return;
                Iterable<DataSnapshot> users = snapshot.getChildren();
                boolean isLogin = false;
                for (DataSnapshot ds: users){
                    if(ds.hasChildren()){
                        User user = ds.getValue(User.class);
                        if(user != null) {
                            if(user.getUsername().equals(userName) && user.getPassword().equals(password)){
                                showToast("Login successfully");
                                isLogin = true;
                                break;
                            }
                        }
                    }
                }
                if(!isLogin)
                    showToast("Failed to login");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    private Boolean isValidSignUpDetails() {
         if (binding.inputUsername.getText().toString().trim().isEmpty()) {
            showToast("Enter your username");
            return false;
        } else if (binding.inputPassword.getText().toString().trim().isEmpty()) {
            showToast("Enter your password");
            return false;
        }else {
            return true;
        }
    }
}