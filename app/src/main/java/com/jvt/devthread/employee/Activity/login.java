package com.jvt.devthread.employee.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.R;

import java.util.Objects;

public class login extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText lEmail,lPassword;
    ImageView btnlogin,icon;
    LinearLayout linearLayout;
    Animation animation;
    TextView dev,thread,forgetPassword;
    ImageView showPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        lEmail=findViewById(R.id.user_txt_email);
        lPassword=findViewById(R.id.user_txt_password);
        btnlogin=findViewById(R.id.user_btn_login);
        dev=findViewById(R.id.dev);
        thread=findViewById(R.id.text2);
        icon=findViewById(R.id.icon);
        showPassword=findViewById(R.id.show_pass_btn);
        linearLayout=findViewById(R.id.linearLayout); animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pop_up);
        animation.setDuration(1000);
        dev.startAnimation(animation);
        thread.startAnimation(animation);
        icon.startAnimation(animation);
        btnlogin.setOnClickListener(this::loginUser);
        forgetPassword=findViewById(R.id.login_txt_forget);
        forgetPassword.setOnClickListener(v -> startActivity(new Intent(login.this, ForgetPassword.class)));
        showPassword.setOnClickListener(this::showHidePass);
    }
    public void loginUser(View view)
    {
        String e = lEmail.getEditableText().toString();
        String p=lPassword.getEditableText().toString();
        if (e.isEmpty())
        {
            lEmail.setError("Enter  Email");
            lEmail.requestFocus();
        }
        else if(p.isEmpty())
        {
            lPassword.setError("Enter Password");
            lPassword.requestFocus();
        }else{
            firebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(task -> {
                if(!task.isSuccessful())
                {
                    Toast.makeText(login.this, "Error..", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String UID= Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid();
                    DatabaseReference userRef= FirebaseDatabase.getInstance().getReference(Common.USER_REFERENCES).child(UID).child("UserInfo");
                    userRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //Common.currentUser= dataSnapshot.getValue(UserInfoModel.class);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            //
                        }
                    });
                    startActivity(new Intent(login.this, MainActivity.class));
                    finish();
                }
            });
        }
    }

    public void showHidePass(View view){

        if(view.getId()==R.id.show_pass_btn){

            if(lPassword.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){

                lPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                lPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }



    @Override
    public void onStart()
    {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser!=null)
        {
            startActivity(new Intent(login.this,MainActivity.class));
            finish();
        }
    }
}