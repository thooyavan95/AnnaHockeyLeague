package com.example.annahockeyleague.Entity;

import android.util.Log;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Interfaces.ModelInterface;
import com.example.annahockeyleague.Interfaces.ViewInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Presenter implements ModelInterface {

    private Model model;
    private ViewInterface viewInterface;
    private static final String TAG = "Presenter";

    public Presenter(ViewInterface viewInterface)
    {
        Log.d(TAG,"presenter constructor");
        this.viewInterface = viewInterface;
        model = new Model(Presenter.this);
    }

    public void fetchData(FragmentConfig config)
    {
        Log.d(TAG,"method fetch data");
        model.beginDataCollection(config);
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
        viewInterface.setPointsTable(data);

    }

    @Override
    public void topScorersDataCollected(ArrayList<TopScorers> data) {

        Log.d(TAG, "method tpo scorer data collected");
        viewInterface.setTopScorers(data);

    }

    @Override
    public void dataCollectionFailure(Exception e) {
        Log.d(TAG, "method data collection failed");
        viewInterface.setFailureToast(e);
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

        viewInterface.setNextMatchFixture(nextMatchData, milliSecToDate(nextMatchData), milliSecToTime(nextMatchData));

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

        viewInterface.setPrevoiusMatchFixture(previousMatchData, milliSecToDate(previousMatchData), milliSecToTime(previousMatchData));

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


