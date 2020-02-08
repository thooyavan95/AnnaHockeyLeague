package com.example.annahockeyleague.Fragments.HomeFragment;

import android.util.Log;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.Entity.PointsTable;
import com.example.annahockeyleague.Entity.TopScorers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HomePresenter implements HomeModelInterface {

    private HomeModel homeModel;
    private HomeViewInterface homeViewInterface;
    private static final String TAG = "HomePresenter";

    public HomePresenter(HomeViewInterface homeViewInterface)
    {
        Log.d(TAG,"presenter constructor");
        this.homeViewInterface = homeViewInterface;
        homeModel = new HomeModel(HomePresenter.this);
    }

    public void fetchData(FragmentConfig config)
    {
        Log.d(TAG,"method fetch data");
        homeModel.beginDataCollection(config);
    }


    @Override
    public void fixtureDataCollected(ArrayList<Fixtures> data) {

        Log.d(TAG, "method fixture data collected");

        findNextMatch(data);

        findPreviousMatch(data);


    }

    @Override
    public void pointsTableDataCollected(ArrayList<PointsTable> data) {

        Log.d(TAG, "method points table data collected");
        homeViewInterface.setPointsTable(data);

    }

    @Override
    public void topScorersDataCollected(ArrayList<TopScorers> data) {

        Log.d(TAG, "method tpo scorer data collected");
        homeViewInterface.setTopScorers(data);

    }

    @Override
    public void dataCollectionFailure(Exception e) {
        Log.d(TAG, "method data collection failed");
        homeViewInterface.setFailureToast(e);
    }


    private void findNextMatch(ArrayList<Fixtures> fixturesData)
    {
        Log.d(TAG, "method find next match");

        Long currentMilliseconds = System.currentTimeMillis();

        Long nextMatchTime = 18937818000L;  // Millisecond dated jan 5,2030
        Fixtures nextMatchData = fixturesData.get(0);

        for(int i=0; i<fixturesData.size(); i++)
        {
            Long currentValue = fixturesData.get(i).getMatchDateTime();
            if(currentValue.compareTo(currentMilliseconds) > 0)
            {
                if(nextMatchTime > currentValue)
                {
                    nextMatchTime = currentValue;
                    nextMatchData = fixturesData.get(i);
                }
            }
        }

        homeViewInterface.setNextMatchFixture(nextMatchData, milliSecToDate(nextMatchData), milliSecToTime(nextMatchData));

    }

    private void findPreviousMatch(ArrayList<Fixtures> fixturesData)
    {

        Log.d(TAG, "method find previous match");

        Long currentMilliseconds = System.currentTimeMillis();

        Long previousMatchTime = 11994714000L;  // Millisecond dated jan 5,2008
        Fixtures previousMatchData = fixturesData.get(0);

        for(int i=0; i<fixturesData.size(); i++)
        {
            Long currentValue = fixturesData.get(i).getMatchDateTime();
            if(currentValue.compareTo(currentMilliseconds) < 0)
            {
                if(previousMatchTime < currentValue)
                {
                    previousMatchTime = currentValue;
                    previousMatchData = fixturesData.get(i);
                }
            }
        }

        homeViewInterface.setPrevoiusMatchFixture(previousMatchData, milliSecToDate(previousMatchData), milliSecToTime(previousMatchData));

    }


    private String milliSecToDate(Fixtures data)
    {
        Log.d(TAG, "method milli sec to date");

        SimpleDateFormat dateFormat = new SimpleDateFormat("d-MMM-yyyy");
        Date date = new Date(data.getMatchDateTime());

        return dateFormat.format(date);
    }


    private String milliSecToTime(Fixtures data)
    {
        Log.d(TAG, "method milli sec to time");

        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(data.getMatchDateTime());
        cal.setTimeZone(cal.getTimeZone());

        return cal.get(Calendar.HOUR_OF_DAY) + " : " +  cal.get(Calendar.MINUTE) + " " + cal.get(Calendar.AM_PM);
    }

}


