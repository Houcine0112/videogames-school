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
    private List<VideoGame> videoGames = new ArrayList<>();

    public boolean add(VideoGame videoGame) {
        return videoGames.add(videoGame);
    }

    public List<VideoGame> getVideoGames() {
        return videoGames;
    }
    public List<VideoGame> getSortedBy(String sortBy, boolean rev){
        List<VideoGame> list_sorted = new ArrayList<>(videoGames);
        // cratorsomparators
        Comparator<VideoGame> compareById = (VideoGame v1, VideoGame v2) -> v1.getId().compareTo(v2.getId());
        Comparator<VideoGame> compareByName = (VideoGame v1, VideoGame v2) -> v1.getName().toUpperCase().compareTo(v2.getName().toUpperCase());
        Comparator<VideoGame> compareByPlatform = (VideoGame v1, VideoGame v2) -> v1.getPlatform().toUpperCase().compareTo(v2.getPlatform().toUpperCase());
        Comparator<VideoGame> compareByYear_of_Release = (VideoGame v1, VideoGame v2) -> v1.getYear_of_Release().compareTo(v2.getYear_of_Release());
        Comparator<VideoGame> compareByGenre = (VideoGame v1, VideoGame v2) -> v1.getGenre().toUpperCase().compareTo(v2.getGenre().toUpperCase());
        Comparator<VideoGame> compareByPublisher = (VideoGame v1, VideoGame v2) -> v1.getPublisher().toUpperCase().compareTo(v2.getPublisher().toUpperCase());
        Comparator<VideoGame> compareByNA_Sales = (VideoGame v1, VideoGame v2) -> v1.getNA_Sales().compareTo(v2.getNA_Sales());
        Comparator<VideoGame> compareByEU_Sales = (VideoGame v1, VideoGame v2) -> v1.getEU_Sales().compareTo(v2.getEU_Sales());
        Comparator<VideoGame> compareByJP_Sales = (VideoGame v1, VideoGame v2) -> v1.getJP_Sales().compareTo(v2.getJP_Sales());
        Comparator<VideoGame> compareByOther_Sales = (VideoGame v1, VideoGame v2) -> v1.getOther_Sales().compareTo(v2.getOther_Sales());
        Comparator<VideoGame> compareByGlobal_Sales = (VideoGame v1, VideoGame v2) -> v1.getGlobal_Sales().compareTo(v2.getGlobal_Sales());
        Comparator<VideoGame> compareByCritic_Score = (VideoGame v1, VideoGame v2) -> v1.getCritic_Score().compareTo(v2.getCritic_Score());
        Comparator<VideoGame> compareByCritic_Count = (VideoGame v1, VideoGame v2) -> v1.getCritic_Count().compareTo(v2.getCritic_Count());
        Comparator<VideoGame> compareByUser_Score = (VideoGame v1, VideoGame v2) -> v1.getUser_Score().compareTo(v2.getUser_Score());
        Comparator<VideoGame> compareByUser_Count = (VideoGame v1, VideoGame v2) -> v1.getUser_Count().compareTo(v2.getUser_Count());
        Comparator<VideoGame> compareByDeveloper = (VideoGame v1, VideoGame v2) -> v1.getDeveloper().toUpperCase().compareTo(v2.getDeveloper().toUpperCase());
        Comparator<VideoGame> compareByRating = (VideoGame v1, VideoGame v2) -> v1.getRating().toUpperCase().compareTo(v2.getRating().toUpperCase());
        switch(sortBy) {
            case "id":
              if(!rev){
                  Collections.sort(list_sorted, compareById);
              } else {
                  Collections.sort(list_sorted, compareById.reversed());
              }
              break;
            case "Name":
                if(!rev){
                    Collections.sort(list_sorted, compareByName);
                } else {
                    Collections.sort(list_sorted, compareByName.reversed());
                }
              break;
            case "Platform":
                if(!rev){
                    Collections.sort(list_sorted, compareByPlatform);
                } else {
                    Collections.sort(list_sorted, compareByPlatform.reversed());
                }
              break;
            case "Year_of_Release":
                if(!rev){
                    Collections.sort(list_sorted, compareByYear_of_Release);
                } else {
                    Collections.sort(list_sorted, compareByYear_of_Release.reversed());
                }
              break;
            case "Genre":
                if(!rev){
                    Collections.sort(list_sorted, compareByGenre);
                } else {
                    Collections.sort(list_sorted, compareByGenre.reversed());
                }
              break;
            case "Publisher":
                if(!rev){
                    Collections.sort(list_sorted, compareByPublisher);
                } else {
                    Collections.sort(list_sorted, compareByPublisher.reversed());
                }
              break;
            case "NA_Sales":
                if(!rev){
                    Collections.sort(list_sorted, compareByNA_Sales);
                } else {
                    Collections.sort(list_sorted, compareByNA_Sales.reversed());
                }
              break;
            case "EU_Sales":
                if(!rev){
                    Collections.sort(list_sorted, compareByEU_Sales);
                } else {
                    Collections.sort(list_sorted, compareByEU_Sales.reversed());
                }
              break;
            case "JP_Sales":
                if(!rev){
                    Collections.sort(list_sorted, compareByJP_Sales);
                } else {
                    Collections.sort(list_sorted, compareByJP_Sales.reversed());
                }
              break;
            case "Other_Sales":
                if(!rev){
                    Collections.sort(list_sorted, compareByOther_Sales);
                } else {
                    Collections.sort(list_sorted, compareByOther_Sales.reversed());
                }
              break;
            case "Global_Sales":
                if(!rev){
                    Collections.sort(list_sorted, compareByGlobal_Sales);
                } else {
                    Collections.sort(list_sorted, compareByGlobal_Sales.reversed());
                }
              break;
            case "Critic_Score":
                if(!rev){
                    Collections.sort(list_sorted, compareByCritic_Score);
                } else {
                    Collections.sort(list_sorted, compareByCritic_Score.reversed());
                }
              break;
            case "Critic_Count":
                if(!rev){
                    Collections.sort(list_sorted, compareByCritic_Count);
                } else {
                    Collections.sort(list_sorted, compareByCritic_Count.reversed());
                }
              break;
            case "User_Score":
                if(!rev){
                    Collections.sort(list_sorted, compareByUser_Score);
                } else {
                    Collections.sort(list_sorted, compareByUser_Score.reversed());
                }
              break;
            case "User_Count":
                if(!rev){
                    Collections.sort(list_sorted, compareByUser_Count);
                } else {
                    Collections.sort(list_sorted, compareByUser_Count.reversed());
                }
              break;
            case "Developer":
                if(!rev){
                    Collections.sort(list_sorted, compareByDeveloper);
                } else {
                    Collections.sort(list_sorted, compareByDeveloper.reversed());
                }
              break;
            case "Rating":
                if(!rev){
                    Collections.sort(list_sorted, compareByRating);
                } else {
                    Collections.sort(list_sorted, compareByRating.reversed());
                }
              break;
            default:
        }
        return list_sorted;
    }
}
