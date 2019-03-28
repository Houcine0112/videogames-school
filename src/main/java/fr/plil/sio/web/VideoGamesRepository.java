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
                list_sorted.sort(!reverse ? compareById : compareById.reversed());
                break;
            case "Name":
                list_sorted.sort(!reverse ? compareByName : compareByName.reversed());
              break;
            case "Platform":
                list_sorted.sort(!reverse ? compareByPlatform : compareByPlatform.reversed());
              break;
            case "Year_of_Release":
                list_sorted.sort(!reverse ? compareByYear_of_Release : compareByYear_of_Release.reversed());
              break;
            case "Genre":
                list_sorted.sort(!reverse ? compareByGenre : compareByGenre.reversed());
              break;
            case "Publisher":
                list_sorted.sort(!reverse ? compareByPublisher : compareByPublisher.reversed());
              break;
            case "NA_Sales":
                list_sorted.sort(!reverse ? compareByNA_Sales : compareByNA_Sales.reversed());
              break;
            case "EU_Sales":
                list_sorted.sort(!reverse ? compareByEU_Sales : compareByEU_Sales.reversed());
              break;
            case "JP_Sales":
                list_sorted.sort(!reverse ? compareByJP_Sales : compareByJP_Sales.reversed());
              break;
            case "Other_Sales":
                list_sorted.sort(!reverse ? compareByOther_Sales : compareByOther_Sales.reversed());
              break;
            case "Global_Sales":
                list_sorted.sort(!reverse ? compareByGlobal_Sales : compareByGlobal_Sales.reversed());
              break;
            case "Critic_Score":
                list_sorted.sort(!reverse ? compareByCritic_Score : compareByCritic_Score.reversed());
              break;
            case "Critic_Count":
                list_sorted.sort(!reverse ? compareByCritic_Count : compareByCritic_Count.reversed());
              break;
            case "User_Score":
                list_sorted.sort(!reverse ? compareByUser_Score: compareByUser_Score.reversed());
              break;
            case "User_Count":
                list_sorted.sort(!reverse ? compareByUser_Count : compareByUser_Count.reversed());
              break;
            case "Developer":
                list_sorted.sort(!reverse ? compareByDeveloper : compareByDeveloper.reversed());
              break;
            case "Rating":
                list_sorted.sort(!reverse ? compareByRating : compareByRating.reversed());
              break;
            default:
        }
        return list_sorted;
    }
}
