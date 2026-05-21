package com.example.pract5;

public class Game {

    private String titulo;
    private String fecha;
    private String team;
    private double rating;
    private int timesListed;
    private int reviews;
    private int plays;
    private int playing;
    private int backlogs;
    private int wishlist;

    public Game(String titulo, String fecha, String team, double rating, int timesListed, int reviews,
                int plays, int playing, int backlogs, int wishlist) {

        this.titulo = titulo;
        this.fecha = fecha;
        this.team = team;
        this.rating = rating;
        this.timesListed = timesListed;
        this.reviews = reviews;
        this.plays = plays;
        this.playing = playing;
        this.backlogs = backlogs;
        this.wishlist = wishlist;
    }

    //GETTERS Y SETTERS
    public String getTitulo(){
        return titulo;
    }
    public String getFecha(){
        return fecha;
    }
    public String getTeam(){
        return team;
    }
    public double getRating(){
        return rating;
    }
    public int getTimesListed(){
        return timesListed;
    }
    public int getReviews(){
        return reviews;
    }
    public int getPlays(){
        return plays;
    }
    public int getPlaying(){
        return playing;
    }
    public int getBacklogs(){
        return backlogs;
    }
    public int getWishlist(){
        return wishlist;
    }
}
