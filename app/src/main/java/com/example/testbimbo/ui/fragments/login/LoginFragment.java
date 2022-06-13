package com.example.testbimbo.ui.fragments.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.testbimbo.R;
import com.example.testbimbo.databinding.FragmentLoginBinding;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

    FragmentLoginBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentLoginBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadingPreferences();

        mBinding.btnLogin.setOnClickListener(v -> {

            String txtUser = mBinding.edTxtUser.getText().toString().trim();
            String txtPassword = mBinding.edTxtPassword.getText().toString().trim();

            if (txtUser.equals("victor") && txtPassword.equals("1234")) {
                saveData();
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_homeFragment);
            } else if (!txtUser.isEmpty() && !txtPassword.isEmpty()) {
                Toast.makeText(requireActivity(), "Usuario o Constraseña no coinciden", Toast.LENGTH_SHORT).show();
                validField(txtUser, mBinding.inputLayoutEdTxtUser);
                validField(txtPassword, mBinding.inputLayoutEdTxtPassword);
            } else {
                validField(txtUser, mBinding.inputLayoutEdTxtUser);
                validField(txtPassword, mBinding.inputLayoutEdTxtPassword);
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    public void validField(String string, TextInputLayout edTxt) {
        if (string.isEmpty()) {
            edTxt.setHelperText(getString(R.string.txt_empty_field));
        } else {
            edTxt.setHelperText("");
        }
    }

    public void saveData() {
        SharedPreferences preferences = requireActivity().getSharedPreferences("name", Context.MODE_PRIVATE);

        String nameUser = mBinding.edTxtUser.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("NAME_USER", nameUser);

        mBinding.edTxtUser.setText(nameUser);

        editor.commit();
    }

    public void loadingPreferences() {
        SharedPreferences preferences = requireActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        String user = preferences.getString("NAME_USER", "");
        mBinding.edTxtUser.setText(user);
    }
}