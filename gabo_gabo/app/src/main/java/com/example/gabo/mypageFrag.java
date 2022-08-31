package com.example.gabo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class mypageFrag extends Fragment {

    LinearLayout test_findbb ;
    BottomSheetDialogFrag bottomDialog;
    FragmentManager fmm ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mypage_lyt,container,false);

        fmm=getActivity().getSupportFragmentManager();
        bottomDialog = new BottomSheetDialogFrag();
        test_findbb = view.findViewById(R.id.test_findbb);
        test_findbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomDialog.show(fmm,"test");
            }
        });
        return view;


    }
}
