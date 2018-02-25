package com.example.jdachuk.gl_task;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

import com.example.jdachuk.gl_task.model.CarKeylessEntrySystem;
import com.example.jdachuk.gl_task.model.FiniteStateMachine.State;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class CarKeylessEntrySystemTest {

    private CarKeylessEntrySystem carKeylessEntrySystem;
    private Context applicationContext;

    @Before
    public void setUp() {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        TextView indicator = mainActivity.findViewById(R.id.alarm_indicator);
        applicationContext = mainActivity.getApplicationContext();

        carKeylessEntrySystem = new CarKeylessEntrySystem();
        carKeylessEntrySystem.setIndicator(indicator);
    }

    // Testing each event at state AlarmDisarmed_AllUnlocked
    @Test
    public void lock_at_AD_AU() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        carKeylessEntrySystem.Lock();
        assertEquals(State.ALARM_DISARMED_ALL_LOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void unlock_at_AD_AU() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        carKeylessEntrySystem.Unlock();
        assertEquals(State.ALARM_DISARMED_ALL_UNLOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void lock_x2_at_AD_AU() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        carKeylessEntrySystem.Lock_x2();
        assertEquals(State.ALARM_ARMED_ALL_LOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void unlock_x2_at_AD_AU() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        carKeylessEntrySystem.Unlock_x2();
        assertEquals(State.ALARM_DISARMED_ALL_UNLOCKED, carKeylessEntrySystem.getCurrentState());
    }
    // End of event tests in state AlarmDisarmed_AllUnlocked

    // Testing each event at state AlarmDisarmed_AllLocked
    @Test
    public void lock_at_AD_AL() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        carKeylessEntrySystem.Lock();
        assertEquals(State.ALARM_ARMED_ALL_LOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void unlock_at_AD_AL() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        carKeylessEntrySystem.Unlock();
        assertEquals(State.ALARM_DISARMED_DRIVER_UNLOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void lock_x2_at_AD_AL() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        carKeylessEntrySystem.Lock_x2();
        assertEquals(State.ALARM_ARMED_ALL_LOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void unlock_x2_at_AD_AL() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        carKeylessEntrySystem.Unlock_x2();
        assertEquals(State.ALARM_DISARMED_ALL_UNLOCKED, carKeylessEntrySystem.getCurrentState());
    }
    // End of event tests in state AlarmDisarmed_AllLocked

    // Testing each event at state AlarmArmed_AllLocked
    @Test
    public void lock_at_AA_AL() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        carKeylessEntrySystem.Lock();
        assertEquals(State.ALARM_ARMED_ALL_LOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void unlock_at_AA_AL() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        carKeylessEntrySystem.Unlock();
        assertEquals(State.ALARM_DISARMED_DRIVER_UNLOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void lock_x2_at_AA_AL() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        carKeylessEntrySystem.Lock_x2();
        assertEquals(State.ALARM_ARMED_ALL_LOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void unlock_x2_at_AA_AL() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        carKeylessEntrySystem.Unlock_x2();
        assertEquals(State.ALARM_DISARMED_ALL_UNLOCKED, carKeylessEntrySystem.getCurrentState());
    }
    // End of event tests in state AlarmArmed_AllLocked

    // Testing each event at state AlarmDisarmed_DriverUnlocked
    @Test
    public void lock_at_AD_DU() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        carKeylessEntrySystem.Lock();
        assertEquals(State.ALARM_DISARMED_ALL_LOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void unlock_at_AD_DU() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        carKeylessEntrySystem.Unlock();
        assertEquals(State.ALARM_DISARMED_DRIVER_UNLOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void lock_x2_at_AD_DU() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        carKeylessEntrySystem.Lock_x2();
        assertEquals(State.ALARM_ARMED_ALL_LOCKED, carKeylessEntrySystem.getCurrentState());
    }

    @Test
    public void unlock_x2_at_AD_DU() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        carKeylessEntrySystem.Unlock_x2();
        assertEquals(State.ALARM_DISARMED_DRIVER_UNLOCKED, carKeylessEntrySystem.getCurrentState());
    }
    // End of event tests in state AlarmDisarmed_DriverUnlocked


    // Tests for indication each state
    // Indication of AlarmDisarmed_AllUnlocked state
    @Test
    public void AD_AU_text_test() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        assertEquals(applicationContext.getString(R.string.all_unlocked),
                carKeylessEntrySystem.getIndicator().getText());
    }

    @Test
    public void AD_AU_color_test() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_UNLOCKED);
        assertEquals(applicationContext.getColor(R.color.alarmDisarmed),
                ((ColorDrawable)carKeylessEntrySystem.getIndicator().getBackground()).getColor());
    }
    // End of tests for indication of AlarmDisarmed_AllUnlocked state

    // Indication of AlarmDisarmed_AllLocked state
    @Test
    public void AD_AL_text_test() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        assertEquals(applicationContext.getString(R.string.all_locked),
                carKeylessEntrySystem.getIndicator().getText());
    }

    @Test
    public void AD_AL_color_test() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_ALL_LOCKED);
        assertEquals(applicationContext.getColor(R.color.alarmDisarmed),
                ((ColorDrawable)carKeylessEntrySystem.getIndicator().getBackground()).getColor());
    }
    // End of tests for indication of AlarmDisarmed_AllLocked state

    // Indication of AlarmDisarmed_DriverUnlocked state
    @Test
    public void AD_DU_text_test() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        assertEquals(applicationContext.getString(R.string.driver_unlocked),
                carKeylessEntrySystem.getIndicator().getText());
    }

    @Test
    public void AD_DU_color_test() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_DISARMED_DRIVER_UNLOCKED);
        assertEquals(applicationContext.getColor(R.color.alarmDisarmed),
                ((ColorDrawable)carKeylessEntrySystem.getIndicator().getBackground()).getColor());
    }
    // End of tests for indication of AlarmDisarmed_DriverUnlocked state

    // Indication of AlarmArmed_AllLocked state
    @Test
    public void AA_AL_text_test() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        assertEquals(applicationContext.getString(R.string.all_locked),
                carKeylessEntrySystem.getIndicator().getText());
    }

    @Test
    public void AA_AL_color_test() throws Exception {
        carKeylessEntrySystem.setCurrentState(State.ALARM_ARMED_ALL_LOCKED);
        assertEquals(applicationContext.getColor(R.color.alarmArmed),
                ((ColorDrawable)carKeylessEntrySystem.getIndicator().getBackground()).getColor());
    }
    // End of tests for indication of AlarmArmed_AllLocked state
}