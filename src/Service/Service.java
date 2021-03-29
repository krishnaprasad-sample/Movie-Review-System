package Service;

import Entity.Genre;
import Entity.Movie;
import Entity.Role;
import Entity.User;

import java.time.Year;
import java.util.*;

public class Service {

    public List<User> userList = new ArrayList<>();

    public List<Movie> catalog = new ArrayList<>();

    public Movie createMovie(String name, Integer year, Genre[] genres) {
        Movie newMovie = new Movie(name);
        newMovie.setGenre(Arrays.asList(genres));
        newMovie.setYear(Year.of(year));
        this.catalog.add(newMovie);
        return newMovie;
    }


    public String addReview(User user, Movie movie, int rating) throws Exception {
        checkForExceptions(user,movie,rating);

        movie.setReviewScore(movie.getReviewScore() + rating * user.getRole().getWeightage());
        movie.setReviewer(user.getUserId());
        if (user.getRole().equals(Role.CRITIC) || user.getRole().equals(Role.EXPERT)) {
            movie.setCriticallyReviewed(true);
        }

        user.review();
        return null;
    }

    private void checkForExceptions(User user, Movie movie, int rating) throws RuntimeException {
        if (rating < 1 || rating > 10) {
            throw new ArithmeticException("Movie rating has to be between 1 and 10");
        }
        if (movie.getYear().isAfter(Year.now())) {
            throw new RuntimeException("Movie is yet to be released");
        }
        if (movie.getReviewersList().contains(user.getUserId())) {
            throw new RuntimeException("Multiple reviews not allowed: " + user.getName() + "  " + user.getUserId());
        }
    }

    public Movie getTopMovieByYear(Integer year) {
        return catalog.stream().filter(m -> m.getYear().equals(Year.of(year)))
                .max(Comparator.comparing(Movie::getReviewScore)).orElseThrow(NoSuchElementException::new);
    }

    public Movie getTopCriticPreferredMovieInYear(Integer year){
        return catalog.stream().filter(m -> m.getYear().equals(Year.of(year)) && m.isCriticallyReviewed())
                .max(Comparator.comparing(Movie::getReviewScore)).orElseThrow(NoSuchElementException::new);
    }

    public Movie getTopMovieByGenre(Genre genre) {
        return catalog.stream().filter(m -> m.getGenre().contains(genre))
                .max(Comparator.comparing(Movie::getReviewScore)).orElseThrow(NoSuchElementException::new);
    }

    public Movie getTopMovieByAverageScoreInYear(Integer year) {
        return catalog.stream().filter(m -> m.getYear().equals(Year.of(year)))
                .max(Comparator.comparing(Movie::getAverageReviewScore)).orElseThrow(NoSuchElementException::new);
    }

    public double getAverageReviewScoreForYear(Integer year) {
        return catalog.stream().filter(m -> m.getYear().equals(Year.of(year))).mapToInt(m -> m.getReviewScore())
                .average().orElse(0);
    }

    public User createUser(String name) {
        User newUser = new User(name);
        userList.add(newUser);
        return newUser;
    }


    public List<Movie> getCatalog() {
        return this.catalog;
    }

    public List<User> getUserList() {
        return this.userList;
    }
}
