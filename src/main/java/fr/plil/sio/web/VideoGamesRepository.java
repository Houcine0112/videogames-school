/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lelaidou
 */
public class VideoGamesRepository {
    private List<VideoGame> videoGames = new ArrayList<VideoGame>();

    public boolean add(VideoGame videoGame) {
        return videoGames.add(videoGame);
    }

    public List<VideoGame> getVideoGames() {
        return videoGames;
    }

}
