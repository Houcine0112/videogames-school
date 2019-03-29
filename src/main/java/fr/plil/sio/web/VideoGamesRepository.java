/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author lelaidou
 */
public class VideoGamesRepository {
    private List<VideoGame> videoGames = new ArrayList<>();

    public boolean add(VideoGame videoGame) {
        return videoGames.add(videoGame);
    }

    public List<VideoGame> getVideoGames() {
        return videoGames;
    }

    public List<VideoGame> getSortedBy(String sortBy, boolean reverse) {
        List<VideoGame> list_sorted = new ArrayList<>(videoGames);
        //
        Comparator<VideoGame> comparator;
        switch (sortBy) {
            case "Name":
                comparator = Comparator.comparing((VideoGame v) -> v.getName().toUpperCase());
                break;
            case "Platform":
                comparator = Comparator.comparing((VideoGame v) -> v.getPlatform().toUpperCase());
                break;
            case "Year_of_Release":
                comparator = Comparator.comparing(VideoGame::getYear_of_Release);
                break;
            case "Genre":
                comparator = Comparator.comparing((VideoGame v) -> v.getGenre().toUpperCase());
                break;
            case "Publisher":
                comparator = Comparator.comparing((VideoGame v) -> v.getPublisher().toUpperCase());
                break;
            case "NA_Sales":
                comparator = Comparator.comparing(VideoGame::getNA_Sales);
                break;
            case "EU_Sales":
                comparator = Comparator.comparing(VideoGame::getEU_Sales);
                break;
            case "JP_Sales":
                comparator = Comparator.comparing(VideoGame::getJP_Sales);
                break;
            case "Other_Sales":
                comparator = Comparator.comparing(VideoGame::getOther_Sales);
                break;
            case "Global_Sales":
                comparator = Comparator.comparing(VideoGame::getGlobal_Sales);
                break;
            case "Critic_Score":
                comparator = Comparator.comparing(VideoGame::getCritic_Score);
                break;
            case "Critic_Count":
                comparator = Comparator.comparing(VideoGame::getCritic_Count);
                break;
            case "User_Score":
                comparator = Comparator.comparing(VideoGame::getUser_Score);
                break;
            case "User_Count":
                comparator = Comparator.comparing(VideoGame::getUser_Count);
                break;
            case "Developer":
                comparator = Comparator.comparing((VideoGame v) -> v.getDeveloper().toUpperCase());
                break;
            case "Rating":
                comparator = Comparator.comparing((VideoGame v) -> v.getRating().toUpperCase());
                break;
            default:
                comparator = Comparator.comparing(VideoGame::getId);
        }
        list_sorted.sort(!reverse ? comparator : comparator.reversed());
        return list_sorted;
    }
}
