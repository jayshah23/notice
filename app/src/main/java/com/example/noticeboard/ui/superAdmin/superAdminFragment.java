package com.example.noticeboard.ui.superAdmin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.noticeboard.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class superAdminFragment extends Fragment {

    ListView lvsuperAdmin;
    Button btnUpdate, btnForgotPasswordAdminValidation;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");
    ArrayList<String> emailList = new ArrayList<>();
    ArrayList<String> superAdminList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    public superAdminFragment() {}   // Required empty public constructor

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_super_admin, container, false);

        lvsuperAdmin = view.findViewById(R.id.lvsuperAdmin);
        btnUpdate = view.findViewById(R.id.btnUpdate);
        btnForgotPasswordAdminValidation = view.findViewById(R.id.btnForgotPasswordAdminValidation);
        adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, emailList);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (ds.child("type").getValue().toString().equals("admin")) {
                        String email = ds.child("email").getValue(String.class);
                        String superAdmin = ds.child("superAdmin").getValue(String.class);
                        if(superAdmin.equals("true")) {
                            emailList.add(email);
                        }
                    }
                }
                adapter.notifyDataSetChanged();
                lvsuperAdmin.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new editSuperAdmin();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnForgotPasswordAdminValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());
                alertDialog.setTitle("Update Password").setCancelable(false);

                final EditText editText1 = new EditText(view.getContext()), editText2 = new EditText(view.getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                editText1.setLayoutParams(lp);
                editText1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                alertDialog.setView(editText1);
                alertDialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference("credential").child("validationAdmin")
                                .setValue(editText1.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toasty.success(view.getContext(), "Update Successful", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toasty.success(view.getContext(), "Update Failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });
        return view;
    }
}