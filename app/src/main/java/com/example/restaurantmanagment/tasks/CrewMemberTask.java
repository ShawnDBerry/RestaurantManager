package com.example.restaurantmanagment.tasks;

import android.util.Log;

import com.example.restaurantmanagment.model.CrewMember;

public class CrewMemberTask implements Runnable {
    private CrewMember crewMember;

    public CrewMemberTask(CrewMember crewMember) {
        this.crewMember = crewMember;
    }

    @Override
    public void run() {
        for(int i = 0; i < crewMember.getSeconds(); i++){
            try{
                Thread.sleep(2000);
                Log.d("TAG_Q", crewMember.getName() + crewMember.getSeconds());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.d("TAG_Q", crewMember.getName() +" task is done. ");

    }
}
