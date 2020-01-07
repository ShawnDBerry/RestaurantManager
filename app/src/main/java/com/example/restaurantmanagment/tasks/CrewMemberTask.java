package com.example.restaurantmanagment.tasks;

import com.example.restaurantmanagment.model.CrewMember;

public class CrewMemberTask implements Runnable {
    private CrewMember crewMember;

    public CrewMemberTask(CrewMember crewMember) {
        this.crewMember = crewMember;
    }

    @Override
    public void run() {

    }
}
