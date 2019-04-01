/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import java.util.Arrays;
import java.util.List;

/**
 * @author lelaidou
 */


class VideoGame {
    private Integer id;
    private String Name;
    private String Platform;
    private Integer Year_of_Release;
    private String Genre;
    private String Publisher;
    private Double NA_Sales;
    private Double EU_Sales;
    private Double JP_Sales;
    private Double Other_Sales;
    private Double Global_Sales;
    private Double Critic_Score;
    private Integer Critic_Count;
    private Double User_Score;
    private Integer User_Count;
    private String Developer;
    private String Rating;

    VideoGame(Integer i, List<String> videoGame_data) {
        id = i;
        Name = videoGame_data.get(0).trim();
        Platform = videoGame_data.get(1).trim();
        try {
            Year_of_Release = Integer.parseInt(videoGame_data.get(2).trim());
        } catch (Exception e) {
            Year_of_Release = 0;
        }

        Genre = videoGame_data.get(3);
        Publisher = videoGame_data.get(4);
        try {
            NA_Sales = Double.parseDouble(videoGame_data.get(5).trim());
        } catch (Exception e) {
            NA_Sales = 0.;
        }
        try {
            EU_Sales = Double.parseDouble(videoGame_data.get(6).trim());
        } catch (Exception e) {
            EU_Sales = 0.;
        }
        try {
            JP_Sales = Double.parseDouble(videoGame_data.get(7).trim());
        } catch (Exception e) {
            JP_Sales = 0.;
        }
        try {
            Other_Sales = Double.parseDouble(videoGame_data.get(8).trim());
        } catch (Exception e) {
            Other_Sales = 0.;
        }
        try {
            Global_Sales = Double.parseDouble(videoGame_data.get(9).trim());
        } catch (Exception e) {
            Global_Sales = 0.;
        }
        try {
            Critic_Score = Double.parseDouble(videoGame_data.get(10).trim());
        } catch (Exception e) {
            Critic_Score = 0.;
        }
        try {
            Critic_Count = Integer.parseInt(videoGame_data.get(11).trim());
        } catch (Exception e) {
            Critic_Count = 0;
        }
        try {
            User_Score = Double.parseDouble(videoGame_data.get(12).trim());
        } catch (Exception e) {
            User_Score = 0.;
        }
        try {
            User_Count = Integer.parseInt(videoGame_data.get(13).trim());
        } catch (Exception e) {
            User_Count = 0;
        }

        Developer = videoGame_data.get(14).trim();
        Rating = videoGame_data.get(15).trim();
    }

    Integer getId() {
        return id;
    }

    String getName() {
        return Name;
    }

    String getPlatform() {
        return Platform;
    }

    Integer getYear_of_Release() {
        return Year_of_Release;
    }

    String getGenre() {
        return Genre;
    }

    String getPublisher() {
        return Publisher;
    }

    Double getNA_Sales() {
        return NA_Sales;
    }

    Double getEU_Sales() {
        return EU_Sales;
    }

    Double getJP_Sales() {
        return JP_Sales;
    }

    Double getOther_Sales() {
        return Other_Sales;
    }

    Double getGlobal_Sales() {
        return Global_Sales;
    }

    Double getCritic_Score() {
        return Critic_Score;
    }

    Integer getCritic_Count() {
        return Critic_Count;
    }

    Double getUser_Score() {
        return User_Score;
    }

    Integer getUser_Count() {
        return User_Count;
    }

    String getDeveloper() {
        return Developer;
    }

    String getRating() {
        return Rating;
    }

    List<String> getData() {
        return Arrays.asList(
                Name, Platform, Year_of_Release.toString(), Genre, Publisher,
                NA_Sales.toString(), EU_Sales.toString(), JP_Sales.toString(),
                Other_Sales.toString(), Global_Sales.toString(), Critic_Score.toString(),
                Critic_Count.toString(), User_Score.toString(), User_Count.toString(),
                Developer, Rating);
    }


}
