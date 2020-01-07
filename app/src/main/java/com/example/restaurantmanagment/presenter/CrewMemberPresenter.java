package com.example.restaurantmanagment.presenter;

import com.example.restaurantmanagment.model.CrewMember;

import java.util.ArrayList;
import java.util.List;

public class CrewMemberPresenter implements Contract.CrewMemberPresenter {
    private Contract.CrewMemberView crewMemberView;
    List<CrewMember> crewMemberList = new ArrayList<>();
    @Override
    public void getCrewMembers() {

    }

    @Override
    public void insertNewCrewMember(CrewMember crewMember) {

    }
}
