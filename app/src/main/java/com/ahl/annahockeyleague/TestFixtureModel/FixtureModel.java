package com.ahl.annahockeyleague.TestFixtureModel;


// A common model class to get fixture (A sample work)

public class FixtureModel {

    private FixtureViewInterface presenterInterface;
    private String data;


    public void getData()
    {
        if(data != null)
        {
//            presenterInterface.getFixtures(); // send data
        }
        else
        {
            onComplete();  // do the work to get data
        }
    }

    private void onComplete()
    {
//        presenterInterface.getFixtures();  // after work done
    }

}
