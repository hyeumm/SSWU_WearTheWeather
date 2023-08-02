package org.techtown.weartheweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import java.text.DateFormat;
import java.util.Calendar;

public class alarm_MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    public static final String TAG = "MAIN";

    private TextView time_text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedinstanceState) {

        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_main2);

        time_text = findViewById(R.id.time_btn);
        Button time_btn = findViewById(R.id.time_btn);

        //시간 설정
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker = new alarm_TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        //알람 취소
        Button time_cancel_btn = findViewById(R.id.time_cancel_btn);
        time_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
    }



    //시간을 정하면 호출되는 메소드
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        Log.d(TAG, "## onTimeSet ##");
        Calendar c = Calendar.getInstance();

        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        //화면에 시간 지정
        updateTimeText(c);

        //알람 설정
        startAlarm(c);
    }


    //화면에 사용자가 선택한 시간을 보여주는 메소드
    private void updateTimeText(Calendar c) {

        Log.d(TAG, "## updateTimeText ##");
        String timeText = "알람 시간: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        time_text.setText(timeText);
    }


    //알람 시작
    private void startAlarm(Calendar c) {
        Log.d(TAG, "## startAlarm ##");
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, alarm_AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT); //약간 수정

        if(c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        //RTC_WAKE: 지정된 시간에 기기의 절전 모드를 해체하여 대기 중인 인텐트를 실행
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }


    //알람 취소
    private void cancelAlarm() {
        Log.d(TAG, "## cancelAlarm ##");
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, alarm_AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT); //약간 수정

        alarmManager.cancel(pendingIntent);
        time_text.setText("알람 취소");
    }
}