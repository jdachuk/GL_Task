package com.example.jdachuk.gl_task.model;

import android.widget.TextView;

import com.example.jdachuk.gl_task.R;

import static com.example.jdachuk.gl_task.model.FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED;

public class CarKeylessEntrySystem extends FiniteStateMachine {

    private State CurrentState;
    private TextView Indicator;

    public CarKeylessEntrySystem() {
        CurrentState = ALARM_DISARMED_ALL_UNLOCKED;
    }

    public void Lock() {
        CurrentState = this.transition(CurrentState, Event.LOCK);
        SetUpIndicator();
    }

    public void Unlock() {
        CurrentState = this.transition(CurrentState, Event.UNLOCK);
        SetUpIndicator();
    }

    public void Lock_x2() {
        CurrentState = this.transition(CurrentState, Event.LOCK_X2);
        SetUpIndicator();
    }

    public void Unlock_x2() {
        CurrentState = this.transition(CurrentState, Event.UNLOCK_X2);
        SetUpIndicator();
    }

    public void setIndicator(TextView indicator) {
        Indicator = indicator;
        SetUpIndicator();
    }

    private void SetUpIndicator() {
        if(Indicator != null) {
            switch (CurrentState) {
                case ALARM_DISARMED_ALL_UNLOCKED:
                    Indicator.setText(Indicator.getContext().getString(R.string.all_unlocked));
                    Indicator.setBackgroundResource(R.color.alarmDisarmed);
                    break;
                case ALARM_DISARMED_ALL_LOCKED:
                    Indicator.setText(Indicator.getContext().getString(R.string.all_locked));
                    Indicator.setBackgroundResource(R.color.alarmDisarmed);
                    break;
                case ALARM_DISARMED_DRIVER_UNLOCKED:
                    Indicator.setText(Indicator.getContext().getString(R.string.driver_unlocked));
                    Indicator.setBackgroundResource(R.color.alarmDisarmed);
                    break;
                case ALARM_ARMED_ALL_LOCKED:
                    Indicator.setText(Indicator.getContext().getString(R.string.all_locked));
                    Indicator.setBackgroundResource(R.color.alarmArmed);
                    break;

            }
        }
    }

    public TextView getIndicator() {
        return Indicator;
    }

    public State getCurrentState() {
        return CurrentState;
    }

    public void setCurrentState(State currentState) {
        CurrentState = currentState;
        SetUpIndicator();
    }
}
