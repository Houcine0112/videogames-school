/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/**
 * @author lelaidou
 */

class VideoGamesRepository {
    private List<VideoGame> videoGames = new ArrayList<>();

    boolean add(VideoGame videoGame) {
        return videoGames.add(videoGame);
    }

    List<VideoGame> getVideoGames() {
        return videoGames;
    }

    // returns a Map of annual sales_type of grouped videogames by a group_field
    Map<String, Map<Integer, Double>> getGroupedSalesBy(String group_field, String sales_type) {

        ToDoubleFunction<VideoGame> sum_param;
        switch (sales_type) {
            case "NA_Sales":
                sum_param = VideoGame::getNA_Sales;
                break;
            case "EU_Sales":
                sum_param = VideoGame::getEU_Sales;
                break;
            case "JP_Sales":
                sum_param = VideoGame::getJP_Sales;
                break;
            case "Other_Sales":
                sum_param = VideoGame::getOther_Sales;
                break;
            default:
                sum_param = VideoGame::getGlobal_Sales;
        }

        Function<VideoGame, String> group_param;
        switch (group_field) {
            case "Genre":
                group_param = VideoGame::getGenre;
                break;
            default:
                group_param = VideoGame::getPlatform;
        }

        Map<String, Map<Integer, Double>> map = getVideoGames()
                .stream().collect(Collectors.groupingBy(group_param,
                        Collectors.groupingBy(VideoGame::getYear_of_Release,
                                Collectors.summingDouble(sum_param))));
        // sort the map by keys
        Map<String, Map<Integer, Double>> sorted_map = new TreeMap<>(map);
        return sorted_map;
    }

    // returns a sorted version of the video games list
    List<VideoGame> getSortedBy(String sortBy, boolean order_asc) {
        // the sorting happens on a copy of the list in order to not lose the original order
        List<VideoGame> list_sorted = new ArrayList<>(getVideoGames());

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
        // if the order is asc we reverse the comparator
        list_sorted.sort(!order_asc ? comparator : comparator.reversed());
        return list_sorted;
    }
}
