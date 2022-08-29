package com.example.gabo;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


/*-------------------핀 선택시 뜨는 유저 댓글 바텀시트 프래그먼트 --------------------------*/

public class BottomSheetDialogFrag extends BottomSheetDialogFragment {

    BottomSheetBehavior bBehavior;
    
    private ListView tc_list;
    private trsCommentAdapter tcAdapter = new trsCommentAdapter();

    //위치안내버튼
    private TextView btn_howtogo;
    //찾았다버튼
    private TextView btn_find;
    private Dialog win_dialog; //정답축하합니다 다이얼로그


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*바텀시트 라운드 투명배경을 위한 스타일 설정*/
        setStyle(
                STYLE_NORMAL,R.style.TransparentBottomSheetDialogFragment
        );
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(),R.layout.trs_comment_bottom_sheet_lyt,null);

        dialog.setContentView(view);
        bBehavior = BottomSheetBehavior.from((View)view.getParent());


        /*---------------------찾았다 버튼--------------------- */
        btn_find = view.findViewById(R.id.btn_find);
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext().getApplicationContext(),"찾았다!",Toast.LENGTH_SHORT).show();
                openWinDialog();
            }
        });

        /*---------------------위치안내 버튼--------------------- */
        btn_howtogo = view.findViewById(R.id.btn_howtogo);
        btn_howtogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext().getApplicationContext(),"위치안내",Toast.LENGTH_SHORT).show();
            }
        });
        

        /*유저 댓글 리스트뷰*/
        tc_list = view.findViewById(R.id.user_comment_listview);
        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e1),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "gil-dong","#나무아래","#작은소품","#파란색","1분전에 숨김","38","친구들이랑 밥먹으러 가다 찾았어요!"

        );

        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e2),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "gil-dong","#전봇대","#조명","#골드","08/11/22 06:10 PM에 찾음","5","강아지랑 산책하다 찾았어요!꿀잼.."
        );

        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e3),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "JellyBean","#상자속","#텀블러","#노란색","08/06/22 09:00 PM에 찾음","25","텀블러 겟함! 감사감사"
        );

        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e4),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "mmthcoffee","#카페앞","#문구류","#핑크","07/25/22 10:00 PM에 찾음","40","예쁜 핑크색펜이었어요"
        );
        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e5),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "bean","#커피창고","#음료","#커피색","07/20/11 12:45 PM에 찾음","10","커피쿠폰이었음 굿"
        );
        tcAdapter.addItems(
                ContextCompat.getDrawable(getActivity(),R.drawable.e6),
                ContextCompat.getDrawable(getActivity(),R.drawable.like_full),
                "heets","#의자옆","#문구류","#보라색","07/11/10 10:00 PM에 찾음","55","득템 ㄳ"
        );

        tc_list.setAdapter(tcAdapter);
        ListView user_comment_listview = getActivity().findViewById(R.id.user_comment_listview);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    /*-----------------------------------보물찾기 정답 축하합니다 다이얼로그 실행-------------------------------------*/

    private void openWinDialog() {
        win_dialog = new Dialog(getContext());
        win_dialog.setContentView(R.layout.win_layout_dialog);
        win_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imageViewClose=win_dialog.findViewById(R.id.imageViewClose);
        TextView tvOk=win_dialog.findViewById(R.id.tvOk);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                win_dialog.dismiss();
                Toast.makeText(getContext(), "Dialog Close", Toast.LENGTH_SHORT).show();
            }
        });
        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                win_dialog.dismiss();
                Toast.makeText(getContext(), "Button Ok", Toast.LENGTH_SHORT).show();
            }
        });
        win_dialog.show();

    }
}