package com.example.restaurantmanagment.presenter;

import com.example.restaurantmanagment.model.CrewMember;

import java.util.List;

public interface Contract {

    interface CrewMemberPresenter{
        void getCrewMembers();
        void insertNewCrewMember(CrewMember crewMember);
    }

    interface CrewMemberView{
        void displayAllCrewMembers(List<CrewMember> crewMemberList);
    }

}
