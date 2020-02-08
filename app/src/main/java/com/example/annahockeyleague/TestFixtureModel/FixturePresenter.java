package com.example.annahockeyleague.TestFixtureModel;

import com.example.annahockeyleague.Fragments.HomeFragment.HomeViewInterface;

public class FixturePresenter implements FixturePresenterInterface {

    private HomeViewInterface viewInterface;

    FixturePresenter() {
        FixtureModel model = new FixtureModel();
        model.getData();
    }


    @Override
    public void getFixtures() {

        // update data when retrieved from model

//        viewInterface.setNextMatchFixture(); // regardless of interface, it does know what view will be updated

    }
}
