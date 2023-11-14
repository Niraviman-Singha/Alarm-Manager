package com.example.alarmmanager

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alarmmanager.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var picker: MaterialTimePicker
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        createNotificationChannel()

        binding.selectTimeBtn.setOnClickListener {
            showTimePicker()

        }

        binding.setAlarmBtn.setOnClickListener {
            setAlarm()

        }

        binding.cancelAlarmBtn.setOnClickListener {

        }
    }

    private fun setAlarm() {

    }

    private fun showTimePicker() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        picker.show(supportFragmentManager, "niraviman")

        picker.addOnPositiveButtonClickListener {
            if (picker.hour > 12) {
                String.format("%02d", picker.hour - 12) + " : " + String.format(
                    "%02d",
                    picker.minute
                ) + "PM"
            }else{
                String.format("%02d",picker.hour) + " : " + String.format(
                    "%02d",
                    picker.minute
                ) + "AM"
            }
            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0


        }
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val name: CharSequence = "Niraviman Singha Roy"
            val description = "Daffodil International Professional Training Institute"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("niraviman", name, importance)
            channel.description = description
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }
}