package com.ahl.annahockeyleague.Fragments.PlayerFragment;

import com.ahl.annahockeyleague.Entity.PlayerDetails;

import java.util.ArrayList;

public interface PlayerModelInterface {

    void foundPlayerList(ArrayList<PlayerDetails> arrayList);

    void errorMsg(Exception e);

}
