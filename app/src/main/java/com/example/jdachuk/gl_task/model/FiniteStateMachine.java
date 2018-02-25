package com.example.jdachuk.gl_task.model;

public class FiniteStateMachine {

    public enum State {
        ALARM_DISARMED_ALL_UNLOCKED,
        ALARM_DISARMED_ALL_LOCKED,
        ALARM_DISARMED_DRIVER_UNLOCKED,
        ALARM_ARMED_ALL_LOCKED
    }

    public enum Event {
        LOCK,
        UNLOCK,
        LOCK_X2,
        UNLOCK_X2
    }

    public State transition(State stateBefore, Event event) {
        switch (stateBefore) {
            case ALARM_DISARMED_ALL_UNLOCKED: {
                switch (event) {
                    case LOCK:
                        return State.ALARM_DISARMED_ALL_LOCKED;
                    case UNLOCK:
                        return State.ALARM_DISARMED_ALL_UNLOCKED;
                    case LOCK_X2:
                        return State.ALARM_ARMED_ALL_LOCKED;
                    case UNLOCK_X2:
                        return State.ALARM_DISARMED_ALL_UNLOCKED;
                }
            }
            case ALARM_DISARMED_ALL_LOCKED: {
                switch (event) {
                    case LOCK:
                        return State.ALARM_ARMED_ALL_LOCKED;
                    case UNLOCK:
                        return State.ALARM_DISARMED_DRIVER_UNLOCKED;
                    case LOCK_X2:
                        return State.ALARM_ARMED_ALL_LOCKED;
                    case UNLOCK_X2:
                        return State.ALARM_DISARMED_ALL_UNLOCKED;
                }
            }
            case ALARM_DISARMED_DRIVER_UNLOCKED: {
                switch (event) {
                    case LOCK:
                        return State.ALARM_DISARMED_ALL_LOCKED;
                    case UNLOCK:
                        return State.ALARM_DISARMED_DRIVER_UNLOCKED;
                    case LOCK_X2:
                        return State.ALARM_ARMED_ALL_LOCKED;
                    case UNLOCK_X2:
                        return State.ALARM_DISARMED_DRIVER_UNLOCKED;
                }
            }
            case ALARM_ARMED_ALL_LOCKED: {
                switch (event) {
                    case LOCK:
                        return State.ALARM_ARMED_ALL_LOCKED;
                    case UNLOCK:
                        return State.ALARM_DISARMED_DRIVER_UNLOCKED;
                    case LOCK_X2:
                        return State.ALARM_ARMED_ALL_LOCKED;
                    case UNLOCK_X2:
                        return State.ALARM_DISARMED_ALL_UNLOCKED;
                }
            }
        }
        return null;
    }
}
