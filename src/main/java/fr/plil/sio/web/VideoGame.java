/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.web;

import static java.lang.Float.NaN;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author lelaidou
 */
public class VideoGame {
    private Integer id;
    private String Name;
    private String Platform;
    private Integer Year_of_Release;
    private String Genre;
    private String Publisher;
    private Float NA_Sales;
    private Float EU_Sales;
    private Float JP_Sales;
    private Float Other_Sales;
    private Float Global_Sales;
    private Float Critic_Score;
    private Integer Critic_Count;
    private Float User_Score;
    private Integer User_Count;
    private String Developer;
    private String Rating;

    public VideoGame(Integer i, List<String> d) {
        id = i;
        Name = d.get(0).trim();
        Platform = d.get(1).trim();
        try{
            Year_of_Release = Integer.parseInt(d.get(2).trim());
        }catch (Exception e){
            Year_of_Release = 0;
        }
        
        Genre = d.get(3);
        Publisher = d.get(4);
        try{
            NA_Sales = Float.parseFloat(d.get(5).trim());
        }catch (Exception e){
            NA_Sales = Float.parseFloat("0");
        }
        try{
            EU_Sales = Float.parseFloat(d.get(6).trim());
        }catch (Exception e){
            EU_Sales = Float.parseFloat("0");
        }
        try{
            JP_Sales = Float.parseFloat(d.get(7).trim());
        }catch (Exception e){
            JP_Sales = Float.parseFloat("0");
        }
        try{
            Other_Sales = Float.parseFloat(d.get(8).trim());
        }catch (Exception e){
            Other_Sales = Float.parseFloat("0");
        }
        try{
            Global_Sales = Float.parseFloat(d.get(9).trim());
        }catch (Exception e){
            Global_Sales = Float.parseFloat("0");
        }
        try{
            Critic_Score = Float.parseFloat(d.get(10).trim());
        }catch (Exception e){
            Critic_Score = Float.parseFloat("0");
        }
        try{
            Critic_Count = Integer.parseInt(d.get(11).trim());
        }catch (Exception e){
            Critic_Count = 0;
        }
        try{
            User_Score = Float.parseFloat(d.get(12).trim());
        }catch (Exception e){
            User_Score = Float.parseFloat("0");
        }
        try{
            User_Count = Integer.parseInt(d.get(13).trim());
        }catch (Exception e){
            User_Count = 0;
        }
   
        Developer = d.get(14).trim();
        Rating = d.get(15).trim();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getPlatform() {
        return Platform;
    }

    public Integer getYear_of_Release() {
        return Year_of_Release;
    }

    public String getGenre() {
        return Genre;
    }

    public String getPublisher() {
        return Publisher;
    }

    public Float getNA_Sales() {
        return NA_Sales;
    }

    public Float getEU_Sales() {
        return EU_Sales;
    }

    public Float getJP_Sales() {
        return JP_Sales;
    }

    public Float getOther_Sales() {
        return Other_Sales;
    }

    public Float getGlobal_Sales() {
        return Global_Sales;
    }

    public Float getCritic_Score() {
        return Critic_Score;
    }

    public Integer getCritic_Count() {
        return Critic_Count;
    }

    public Float getUser_Score() {
        return User_Score;
    }

    public Integer getUser_Count() {
        return User_Count;
    }

    public String getDeveloper() {
        return Developer;
    }

    public String getRating() {
        return Rating;
    }
    

    public List<String> getData() {
        return Arrays.asList(Name,Platform, Year_of_Release.toString(),
                Genre,Publisher, NA_Sales.toString(),EU_Sales.toString(),
                JP_Sales.toString(),Other_Sales.toString(),Global_Sales.toString(),
                Critic_Score.toString(),Critic_Count.toString(),User_Score.toString(),User_Count.toString()
                ,Developer,Rating);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPlatform(String Platform) {
        this.Platform = Platform;
    }

    public void setYear_of_Release(Integer Year_of_Release) {
        this.Year_of_Release = Year_of_Release;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public void setNA_Sales(Float NA_Sales) {
        this.NA_Sales = NA_Sales;
    }

    public void setEU_Sales(Float EU_Sales) {
        this.EU_Sales = EU_Sales;
    }

    public void setJP_Sales(Float JP_Sales) {
        this.JP_Sales = JP_Sales;
    }

    public void setOther_Sales(Float Other_Sales) {
        this.Other_Sales = Other_Sales;
    }

    public void setGlobal_Sales(Float Global_Sales) {
        this.Global_Sales = Global_Sales;
    }

    public void setCritic_Score(Float Critic_Score) {
        this.Critic_Score = Critic_Score;
    }

    public void setCritic_Count(Integer Critic_Count) {
        this.Critic_Count = Critic_Count;
    }

    public void setUser_Score(Float User_Score) {
        this.User_Score = User_Score;
    }

    public void setUser_Count(Integer User_Count) {
        this.User_Count = User_Count;
    }

    public void setDeveloper(String Developer) {
        this.Developer = Developer;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }
   
    
}
