package com.ahl.annahockeyleague.Fragments.PlayerFragment;

import com.ahl.annahockeyleague.Entity.PlayerDetails;

import java.util.ArrayList;

public interface PlayerViewInterface {

      void showPlayers(ArrayList<PlayerDetails> playersList);

      void displayErrorMessage(Exception e);

}
