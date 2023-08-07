package org.techtown.weartheweather;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class user_input_keyword extends AppCompatActivity implements View.OnClickListener {

    //날씨 버튼 4개를 눌렀을 때 변수 설정
    private Button user_input_suggestion_button1, user_input_suggestion_button2, user_input_suggestion_button3, user_input_suggestion_button4;
    private Button selectedButton; //현재 선택된 버튼을 저장하는 변수


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input_keyword);

        getWindow().setWindowAnimations(0);

        ImageButton keyword_right = (ImageButton) findViewById(R.id.user_input_keyword_common_big_arrow_left);
        keyword_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), user_input_slider.class);
                startActivity(intent);
            }
        });


        ImageButton keyword_left = (ImageButton) findViewById(R.id.user_input_keyword_common_big_arrow__right);
        keyword_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), user_input_fashion.class);
                startActivity(intent);
            }
        });


        ImageButton tipbutton1 = (ImageButton) findViewById(R.id.user_input_keyword_button_1);
        tipbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView search_tip = (ImageView) findViewById(R.id.user_input_suggestionkey);
                search_tip.setVisibility(View.VISIBLE);

            }
        });

        ImageView closetipbutton1 = (ImageView) findViewById(R.id.user_input_suggestionkey);
        closetipbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView search_tip = (ImageView) findViewById(R.id.user_input_suggestionkey);
                search_tip.setVisibility(View.INVISIBLE);

            }
        });

        ImageButton user_input_temperature_backbutton3 = (ImageButton) findViewById(R.id.user_input_temperature_backbutton3);
        user_input_temperature_backbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), main_weather.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), main_weather.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), recommended_music.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), calender.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), search_temperature.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), menu.class);
                startActivity(intent);
            }
        });





        //날씨 버튼 4개를 눌렀을 때 코드 모음

        user_input_suggestion_button1 = findViewById(R.id.user_input_suggestion_button1);
        user_input_suggestion_button2 = findViewById(R.id.user_input_suggestion_button2);
        user_input_suggestion_button3 = findViewById(R.id.user_input_suggestion_button3);
        user_input_suggestion_button4 = findViewById(R.id.user_input_suggestion_button4);

        // 모든 버튼에 같은 OnClickListener를 등록
        user_input_suggestion_button1.setOnClickListener(this);
        user_input_suggestion_button2.setOnClickListener(this);
        user_input_suggestion_button3.setOnClickListener(this);
        user_input_suggestion_button4.setOnClickListener(this);

        //각 버튼에 대한 onTouchListenenr 등록
        user_input_suggestion_button1.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                user_input_suggestion_button1.setBackgroundResource(R.drawable.user_input_suggestion_button1);
            }
            return false;
        });

        user_input_suggestion_button2.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                user_input_suggestion_button2.setBackgroundResource(R.drawable.user_input_suggestion_button2);
            }
            return false;
        });

        user_input_suggestion_button3.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                user_input_suggestion_button3.setBackgroundResource(R.drawable.user_input_suggestion_button3);
            }
            return false;
        });

        user_input_suggestion_button4.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                user_input_suggestion_button4.setBackgroundResource(R.drawable.user_input_suggestion_button4);
            }
            return false;
        });
    }

    public void onClick(View view) {
        //클릭된 버튼을 저장, 나머지 버튼들 비활성화
        if (selectedButton != null) {
            selectedButton.setEnabled(true);
        }

        selectedButton = (Button) view;
        selectedButton.setEnabled(false);

        if (view.getId() == R.id.user_input_suggestion_button1) {
            int desiredBackgroundResource = R.drawable.user_input_suggestion_button1;
            handleButtonBackgroundChange(user_input_suggestion_button1, desiredBackgroundResource);
            user_input_suggestion_button2.setEnabled(false);
            user_input_suggestion_button3.setEnabled(false);
            user_input_suggestion_button4.setEnabled(false);
        } else if (view.getId() == R.id.user_input_suggestion_button2) {
            int desiredBackgroundResource = R.drawable.user_input_suggestion_button2;
            handleButtonBackgroundChange(user_input_suggestion_button2, desiredBackgroundResource);
            user_input_suggestion_button1.setEnabled(false);
            user_input_suggestion_button3.setEnabled(false);
            user_input_suggestion_button4.setEnabled(false);
        } else if (view.getId() == R.id.user_input_suggestion_button3) {
            int desiredBackgroundResource = R.drawable.user_input_suggestion_button3;
            handleButtonBackgroundChange(user_input_suggestion_button3, desiredBackgroundResource);
            user_input_suggestion_button1.setEnabled(false);
            user_input_suggestion_button2.setEnabled(false);
            user_input_suggestion_button4.setEnabled(false);
        } else if (view.getId() == R.id.user_input_suggestion_button4) {
            int desiredBackgroundResource = R.drawable.user_input_suggestion_button4;
            handleButtonBackgroundChange(user_input_suggestion_button4, desiredBackgroundResource);
            user_input_suggestion_button1.setEnabled(false);
            user_input_suggestion_button2.setEnabled(false);
            user_input_suggestion_button3.setEnabled(false);
        }
    }

    private void handleButtonBackgroundChange(Button button, int desiredBackgroundResource) {
        if (button.getBackground().getConstantState() == getResources().getDrawable(desiredBackgroundResource).getConstantState()) {
            // 버튼의 배경이 원하는 Drawable과 같은 경우
            ImageButton user_input_keyword_button_1 = findViewById(R.id.user_input_keyword_button_1);
            user_input_keyword_button_1.setVisibility(View.VISIBLE);
            ImageButton user_input_keyword_button_2 = findViewById(R.id.user_input_keyword_button_2);
            user_input_keyword_button_2.setVisibility(View.VISIBLE);
            ImageView user_input_keyword_inputimageView2 = findViewById(R.id.user_input_keyword_inputimageView2);
            user_input_keyword_inputimageView2.setVisibility(View.VISIBLE);
            ImageView user_input_keyword_input1_bg = findViewById(R.id.user_input_keyword_input1_bg);
            user_input_keyword_input1_bg.setVisibility(View.VISIBLE);
            ImageView user_input_keyword_input2_bg = findViewById(R.id.user_input_keyword_input2_bg);
            user_input_keyword_input2_bg.setVisibility(View.VISIBLE);
            EditText user_input_keyword_input1 = findViewById(R.id.user_input_keyword_input1);
            user_input_keyword_input1.setVisibility(View.VISIBLE);
            EditText user_input_keyword_input2 = findViewById(R.id.user_input_keyword_input2);
            user_input_keyword_input2.setVisibility(View.VISIBLE);
            EditText user_input_keyword_input3 = findViewById(R.id.user_input_keyword_input3);
            user_input_keyword_input3.setVisibility(View.VISIBLE);
        } else {
            // 버튼의 배경이 원하는 Drawable과 다른 경우
            ImageButton user_input_keyword_button_1 = findViewById(R.id.user_input_keyword_button_1);
            user_input_keyword_button_1.setVisibility(View.INVISIBLE);
            ImageButton user_input_keyword_button_2 = findViewById(R.id.user_input_keyword_button_2);
            user_input_keyword_button_2.setVisibility(View.INVISIBLE);
            ImageView user_input_keyword_inputimageView2 = findViewById(R.id.user_input_keyword_inputimageView2);
            user_input_keyword_inputimageView2.setVisibility(View.INVISIBLE);
            ImageView user_input_keyword_input1_bg = findViewById(R.id.user_input_keyword_input1_bg);
            user_input_keyword_input1_bg.setVisibility(View.INVISIBLE);
            ImageView user_input_keyword_input2_bg = findViewById(R.id.user_input_keyword_input2_bg);
            user_input_keyword_input2_bg.setVisibility(View.INVISIBLE);
            EditText user_input_keyword_input1 = findViewById(R.id.user_input_keyword_input1);
            user_input_keyword_input1.setVisibility(View.INVISIBLE);
            EditText user_input_keyword_input2 = findViewById(R.id.user_input_keyword_input2);
            user_input_keyword_input2.setVisibility(View.INVISIBLE);
            EditText user_input_keyword_input3 = findViewById(R.id.user_input_keyword_input3);
            user_input_keyword_input3.setVisibility(View.INVISIBLE);
        }

    }
    
}