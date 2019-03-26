/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lelaidou
 */
public class VideoGame {
    private int id;
    private String Name;
    private String Platform;
    private String Year_of_Release;
    private String Genre;
    private String Publisher;
    private String NA_Sales;
    private String EU_Sales;
    private String JP_Sales;
    private String Other_Sales;
    private String Global_Sales;
    private String Critic_Score;
    private String Critic_Count;
    private String User_Score;
    private String User_Count;
    private String Developer;
    private String Rating;

    public VideoGame(int i, List<String> d) {
        id = i;
        Name = d.get(0);
        Platform = d.get(1);
        Year_of_Release = d.get(2);
        Genre = d.get(3);
        Publisher = d.get(4);
        NA_Sales = d.get(5);
        EU_Sales = d.get(6);
        JP_Sales = d.get(7);
        Other_Sales = d.get(8);
        Global_Sales = d.get(9);
        Critic_Score = d.get(10);
        Critic_Count = d.get(11);
        User_Score = d.get(12);
        User_Count = d.get(13);
        Developer = d.get(14);
        Rating = d.get(15);
    }
    public int getId() {
        return id;
    }
    
    public String getName() {
        return Name;
    }

    public String getPlatform() {
        return Platform;
    }

    public String getYear_of_Release() {
        return Year_of_Release;
    }

    public String getGenre() {
        return Genre;
    }

    public String getPublisher() {
        return Publisher;
    }

    public String getNA_Sales() {
        return NA_Sales;
    }

    public String getEU_Sales() {
        return EU_Sales;
    }

    public String getJP_Sales() {
        return JP_Sales;
    }

    public String getOther_Sales() {
        return Other_Sales;
    }

    public String getGlobal_Sales() {
        return Global_Sales;
    }

    public String getCritic_Score() {
        return Critic_Score;
    }

    public String getCritic_Count() {
        return Critic_Count;
    }

    public String getUser_Score() {
        return User_Score;
    }

    public String getUser_Count() {
        return User_Count;
    }

    public String getDeveloper() {
        return Developer;
    }

    public String getRating() {
        return Rating;
    }

    public List<String> getData() {
        return Arrays.asList(Name,Platform,Year_of_Release,Genre,Publisher,NA_Sales,EU_Sales,JP_Sales,Other_Sales,Global_Sales,Critic_Score,Critic_Count,User_Score,User_Count,Developer,Rating);
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPlatform(String Platform) {
        this.Platform = Platform;
    }

    public void setYear_of_Release(String Year_of_Release) {
        this.Year_of_Release = Year_of_Release;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public void setNA_Sales(String NA_Sales) {
        this.NA_Sales = NA_Sales;
    }

    public void setEU_Sales(String EU_Sales) {
        this.EU_Sales = EU_Sales;
    }

    public void setJP_Sales(String JP_Sales) {
        this.JP_Sales = JP_Sales;
    }

    public void setOther_Sales(String Other_Sales) {
        this.Other_Sales = Other_Sales;
    }

    public void setGlobal_Sales(String Global_Sales) {
        this.Global_Sales = Global_Sales;
    }

    public void setCritic_Score(String Critic_Score) {
        this.Critic_Score = Critic_Score;
    }

    public void setCritic_Count(String Critic_Count) {
        this.Critic_Count = Critic_Count;
    }

    public void setUser_Score(String User_Score) {
        this.User_Score = User_Score;
    }

    public void setUser_Count(String User_Count) {
        this.User_Count = User_Count;
    }

    public void setDeveloper(String Developer) {
        this.Developer = Developer;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }
    
}
