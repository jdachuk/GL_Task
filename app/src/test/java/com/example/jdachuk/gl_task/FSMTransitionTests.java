package com.example.jdachuk.gl_task;

import com.example.jdachuk.gl_task.model.FiniteStateMachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FSMTransitionTests {

    private FiniteStateMachine finiteSM;

    @Before
    public void setUp() {
        finiteSM = mock(FiniteStateMachine.class);

        // Setting up expected results for each state on each event based on UML states schema
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED, FiniteStateMachine.Event.LOCK))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED, FiniteStateMachine.Event.UNLOCK))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED, FiniteStateMachine.Event.LOCK_X2))
                .thenReturn(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED, FiniteStateMachine.Event.UNLOCK_X2))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED);

        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED, FiniteStateMachine.Event.LOCK))
                .thenReturn(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED, FiniteStateMachine.Event.UNLOCK))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED, FiniteStateMachine.Event.LOCK_X2))
                .thenReturn(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED, FiniteStateMachine.Event.UNLOCK_X2))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED);

        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED, FiniteStateMachine.Event.LOCK))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED, FiniteStateMachine.Event.UNLOCK))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED, FiniteStateMachine.Event.LOCK_X2))
                .thenReturn(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED, FiniteStateMachine.Event.UNLOCK_X2))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED);

        when(finiteSM.transition(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED, FiniteStateMachine.Event.LOCK))
                .thenReturn(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED, FiniteStateMachine.Event.UNLOCK))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED, FiniteStateMachine.Event.LOCK_X2))
                .thenReturn(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED);
        when(finiteSM.transition(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED, FiniteStateMachine.Event.UNLOCK_X2))
                .thenReturn(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED);
    }

    // Testing transition from AlarmDisarmed_AllUnlocked on Lock event
    @Test
    public void AD_AU_onLock() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED, FiniteStateMachine.Event.LOCK));
    }

    // Testing transition from AlarmDisarmed_AllUnlocked on Unlock event
    @Test
    public void AD_AU_onUnlock() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED, FiniteStateMachine.Event.UNLOCK));
    }

    // Testing transition from AlarmDisarmed_AllUnlocked on Lock_x2 event
    @Test
    public void AD_AU_onLock_x2() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED, FiniteStateMachine.Event.LOCK_X2));
    }

    // Testing transition from AlarmDisarmed_AllUnlocked on Unlock_x2 event
    @Test
    public void AD_AU_onUnlock_x2() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED, FiniteStateMachine.Event.UNLOCK_X2));
    }

    // Testing transition from AlarmDisarmed_AllLocked on Lock event
    @Test
    public void AD_AL_onLock() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED, FiniteStateMachine.Event.LOCK));
    }

    // Testing transition from AlarmDisarmed_AllLocked on Unlock event
    @Test
    public void AD_AL_onUnlock() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED, FiniteStateMachine.Event.UNLOCK));
    }

    // Testing transition from AlarmDisarmed_AllLocked on Lock_x2 event
    @Test
    public void AD_AL_onLock_x2() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED, FiniteStateMachine.Event.LOCK_X2));
    }

    // Testing transition from AlarmDisarmed_AllLocked on Unlock_x2 event
    @Test
    public void AD_AL_onUnlock_x2() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED, FiniteStateMachine.Event.UNLOCK_X2));
    }

    // Testing transition from AlarmDisarmed_DriverUnlocked on Lock event
    @Test
    public void AD_DU_onLock() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_ALL_LOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED, FiniteStateMachine.Event.LOCK));
    }

    // Testing transition from AlarmDisarmed_DriverUnlocked on Unlock event
    @Test
    public void AD_DU_onUnlock() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED, FiniteStateMachine.Event.UNLOCK));
    }

    // Testing transition from AlarmDisarmed_DriverUnlocked on Lock_x2 event
    @Test
    public void AD_DU_onLock_x2() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED, FiniteStateMachine.Event.LOCK_X2));
    }

    // Testing transition from AlarmDisarmed_DriverUnlocked on Unlock_x2 event
    @Test
    public void AD_DU_onUnlock_x2() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED, FiniteStateMachine.Event.UNLOCK_X2));
    }

    // Testing transition from AlarmArmed_AllLocked on Lock event
    @Test
    public void AA_AL_onLock() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED, FiniteStateMachine.Event.LOCK));
    }

    // Testing transition from AlarmArmed_AllLocked on Unlock event
    @Test
    public void AA_AL_onUnlock() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_DRIVER_UNLOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED, FiniteStateMachine.Event.UNLOCK));
    }

    // Testing transition from AlarmArmed_AllLocked on Lock_x2 event
    @Test
    public void AA_AL_onLock_x2() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED, FiniteStateMachine.Event.LOCK_X2));
    }

    // Testing transition from AlarmArmed_AllLocked on Unlock_x2 event
    @Test
    public void AA_AL_onUnlock_x2() throws Exception {
        assertSame(FiniteStateMachine.State.ALARM_DISARMED_ALL_UNLOCKED,
                finiteSM.transition(FiniteStateMachine.State.ALARM_ARMED_ALL_LOCKED, FiniteStateMachine.Event.UNLOCK_X2));
    }

}
