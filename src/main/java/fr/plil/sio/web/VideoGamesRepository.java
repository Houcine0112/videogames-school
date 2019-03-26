/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    public List<VideoGame> getSortedBy(String sortBy){
        List<VideoGame> list_sorted = new ArrayList<VideoGame>(videoGames);
        // cratorsomparators
        Comparator<VideoGame> compareById = (VideoGame v1, VideoGame v2) -> v1.getId().compareTo(v2.getId());
        Comparator<VideoGame> compareByName = (VideoGame v1, VideoGame v2) -> v1.getName().compareTo(v2.getName());
        Comparator<VideoGame> compareByPlatform = (VideoGame v1, VideoGame v2) -> v1.getPlatform().compareTo(v2.getPlatform());
        Comparator<VideoGame> compareByYear_of_Release = (VideoGame v1, VideoGame v2) -> v1.getYear_of_Release().compareTo(v2.getYear_of_Release());
        Comparator<VideoGame> compareByGenre = (VideoGame v1, VideoGame v2) -> v1.getGenre().compareTo(v2.getGenre());
        Comparator<VideoGame> compareByPublisher = (VideoGame v1, VideoGame v2) -> v1.getPublisher().compareTo(v2.getPublisher());
        Comparator<VideoGame> compareByNA_Sales = (VideoGame v1, VideoGame v2) -> v1.getNA_Sales().compareTo(v2.getNA_Sales());
        Comparator<VideoGame> compareByEU_Sales = (VideoGame v1, VideoGame v2) -> v1.getEU_Sales().compareTo(v2.getEU_Sales());
        Comparator<VideoGame> compareByJP_Sales = (VideoGame v1, VideoGame v2) -> v1.getJP_Sales().compareTo(v2.getJP_Sales());
        Comparator<VideoGame> compareByOther_Sales = (VideoGame v1, VideoGame v2) -> v1.getOther_Sales().compareTo(v2.getOther_Sales());
        Comparator<VideoGame> compareByGlobal_Sales = (VideoGame v1, VideoGame v2) -> v1.getGlobal_Sales().compareTo(v2.getGlobal_Sales());
        Comparator<VideoGame> compareByCritic_Score = (VideoGame v1, VideoGame v2) -> v1.getCritic_Score().compareTo(v2.getCritic_Score());
        Comparator<VideoGame> compareByCritic_Count = (VideoGame v1, VideoGame v2) -> v1.getCritic_Count().compareTo(v2.getCritic_Count());
        Comparator<VideoGame> compareByUser_Score = (VideoGame v1, VideoGame v2) -> v1.getUser_Score().compareTo(v2.getUser_Score());
        Comparator<VideoGame> compareByUser_Count = (VideoGame v1, VideoGame v2) -> v1.getUser_Count().compareTo(v2.getUser_Count());
        Comparator<VideoGame> compareByDeveloper = (VideoGame v1, VideoGame v2) -> v1.getDeveloper().compareTo(v2.getDeveloper());
        Comparator<VideoGame> compareByRating = (VideoGame v1, VideoGame v2) -> v1.getRating().compareTo(v2.getRating());
        switch(sortBy) {
            case "id":
              Collections.sort(list_sorted, compareById);
              break;
            case "Name":
              Collections.sort(list_sorted, compareByName);
              break;
            case "Platform":
              Collections.sort(list_sorted, compareByPlatform);
              break;
            case "Year_of_Release":
              Collections.sort(list_sorted, compareByYear_of_Release);
              break;
            case "Genre":
              Collections.sort(list_sorted, compareByGenre);
              break;
            case "Publisher":
              Collections.sort(list_sorted, compareByPublisher);
              break;
            case "NA_Sales":
              Collections.sort(list_sorted, compareByNA_Sales);
              break;
            case "EU_Sales":
              Collections.sort(list_sorted, compareByEU_Sales);
              break;
            case "JP_Sales":
              Collections.sort(list_sorted, compareByJP_Sales);
              break;
            case "Other_Sales":
              Collections.sort(list_sorted, compareByOther_Sales);
              break;
            case "Global_Sales":
              Collections.sort(list_sorted, compareByGlobal_Sales);
              break;
            case "Critic_Score":
              Collections.sort(list_sorted, compareByCritic_Score);
              break;
            case "Critic_Count":
              Collections.sort(list_sorted, compareByCritic_Count);
              break;
            case "User_Score":
              Collections.sort(list_sorted, compareByUser_Score);
              break;
            case "User_Count":
              Collections.sort(list_sorted, compareByUser_Count);
              break;
            case "Developer":
              Collections.sort(list_sorted, compareByDeveloper);
              break;
            case "Rating":
              Collections.sort(list_sorted, compareByRating);
              break;
            default:
        }
        return list_sorted;
    }
}
