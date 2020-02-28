package com.ahl.annahockeyleague.TestFixtureModel;

import com.ahl.annahockeyleague.Fragments.HomeFragment.HomeViewInterface;

public class FixtureView implements FixtureViewInterface {

    private HomeViewInterface viewInterface;

    FixtureView() {
        FixtureModel model = new FixtureModel();
        model.getData();
    }


    @Override
    public void getFixtures() {

        // update data when retrieved from model

//        viewInterface.setNextMatchFixture(); // regardless of interface, it does know what view will be updated

    }
}
