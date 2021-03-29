package Entity;

import java.time.Year;
import java.util.HashSet;
import java.util.List;

public class Movie {

    public Movie(String name) {
        this.name = name;
    }

    private List<Genre> genre;
    private String name;
    private Year year;
    private Integer reviewScore = 0;
    private HashSet<Integer> reviewersList = new HashSet<>();
    private Integer averageReviewScore = 0;
    private boolean isCriticallyReviewed;


    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Integer getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Integer reviewScore) {
        this.reviewScore = reviewScore;
    }

    public HashSet<Integer> getReviewersList() {
        return reviewersList;
    }

    public void setReviewersList(HashSet<Integer> reviewersList) {
        this.reviewersList = reviewersList;
    }

    public void setReviewer(Integer userId){
        this.reviewersList.add(userId);
    }

    public double getAverageReviewScore(){
        return (double) reviewScore/ (reviewersList.size());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "genre=" + genre +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", reviewScore=" + reviewScore +
                ", reviewersList=" + reviewersList +
                '}';
    }

    public boolean isCriticallyReviewed() {
        return isCriticallyReviewed;
    }

    public void setCriticallyReviewed(boolean criticallyReviewed) {
        isCriticallyReviewed = criticallyReviewed;
    }
}
