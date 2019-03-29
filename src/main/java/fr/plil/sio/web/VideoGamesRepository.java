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
    
    public List<VideoGame> getSortedBy(String sortBy, boolean reverse){
        List<VideoGame> list_sorted = new ArrayList<>(videoGames);
        //
        Comparator<VideoGame> comparator;

        switch(sortBy) {
            case "Name":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getName().toUpperCase().compareTo(v2.getName().toUpperCase());
              break;
            case "Platform":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getPlatform().toUpperCase().compareTo(v2.getPlatform().toUpperCase());
              break;
            case "Year_of_Release":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getYear_of_Release().compareTo(v2.getYear_of_Release());
              break;
            case "Genre":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getGenre().toUpperCase().compareTo(v2.getGenre().toUpperCase());
              break;
            case "Publisher":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getPublisher().toUpperCase().compareTo(v2.getPublisher().toUpperCase());
              break;
            case "NA_Sales":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getNA_Sales().compareTo(v2.getNA_Sales());
              break;
            case "EU_Sales":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getEU_Sales().compareTo(v2.getEU_Sales());
              break;
            case "JP_Sales":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getJP_Sales().compareTo(v2.getJP_Sales());
              break;
            case "Other_Sales":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getOther_Sales().compareTo(v2.getOther_Sales());
              break;
            case "Global_Sales":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getGlobal_Sales().compareTo(v2.getGlobal_Sales());
              break;
            case "Critic_Score":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getCritic_Score().compareTo(v2.getCritic_Score());
              break;
            case "Critic_Count":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getCritic_Count().compareTo(v2.getCritic_Count());
              break;
            case "User_Score":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getUser_Score().compareTo(v2.getUser_Score());
              break;
            case "User_Count":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getUser_Count().compareTo(v2.getUser_Count());
              break;
            case "Developer":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getDeveloper().toUpperCase().compareTo(v2.getDeveloper().toUpperCase());
              break;
            case "Rating":
                comparator = (VideoGame v1, VideoGame v2) -> v1.getRating().toUpperCase().compareTo(v2.getRating().toUpperCase());
              break;
            default:
                comparator = (VideoGame v1, VideoGame v2) -> v1.getId().compareTo(v2.getId());
        }
        list_sorted.sort(!reverse ? comparator : comparator.reversed());
        return list_sorted;
    }
}
