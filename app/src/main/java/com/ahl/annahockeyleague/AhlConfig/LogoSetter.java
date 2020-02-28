package com.ahl.annahockeyleague.AhlConfig;

import com.ahl.annahockeyleague.Entity.Team;
import com.ahl.annahockeyleague.R;

public class LogoSetter {


    public static int setTeamLogo(Team team)
    {

        int image = 0;

        switch (team.getTeamTag())
        {

            case W_RED:

            case M_RED:
                image =  R.drawable.ruffianz;
                break;

            case M_BLUE:

            case W_BLUE:

                image = R.drawable.bluz;
                break;

            case M_GREEN:

            case W_GREEN:

                image =  R.drawable.griffinz;
                break;

            case M_WHITE:

            case W_WHITE:

                image =  R.drawable.white;
                break;

            case M_VIOLET:

            case W_VIOLET:

                image =  R.drawable.driblerz;
                break;

            case M_YELLOW:

            case W_YELLOW:

                image =  R.drawable.yakz;
                break;

            case M_BLACK:

                image = R.drawable.black;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + team);
        }

        return image;
    }

}
