import Entity.*;
import Service.Service;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {

        Service service = new Service();

        /* Add movies */
        Movie don = service.createMovie("Don", 2006, new Genre[]{Genre.ACTION, Genre.COMEDY});
        Movie tiger = service.createMovie("Tiger", 2008, new Genre[]{Genre.DRAMA});
        Movie padmaavat = service.createMovie("Padmaavat", 2006, new Genre[]{Genre.COMEDY});
        Movie lunchbox = service.createMovie("Lunchbox", 2022, new Genre[]{Genre.DRAMA});
        Movie guru = service.createMovie("Guru", 2006, new Genre[]{Genre.DRAMA});
        Movie metro = service.createMovie("Metro", 2006, new Genre[]{Genre.ROMANCE});

        /* Add users */
        User srk = service.createUser("SRK");
        User salman = service.createUser("Salman");
        User deepika = service.createUser("Deepika");

        /* Add reviews */
        service.addReview(srk, don, 2);
        service.addReview(srk, padmaavat, 8);
        service.addReview(salman, don, 5);
        service.addReview(deepika, don, 9);
        service.addReview(deepika, guru, 6);
        /* Uncomment to test- Exception - Multiple reviews not allowed */
//        service.addReview(srk, don, 10);  //
        /* Uncomment to test- Exception - Movie yet to be released */
//        service.addReview(deepika, lunchbox, 5);
        service.addReview(srk, tiger, 5);
        service.addReview(srk, metro, 7);

        List<Movie> catalog = service.getCatalog();
        System.out.println("\n All movies: ");
        for (Movie s : catalog) {
            System.out.println(s);
        }

        System.out.println("\n Test cases: ");

        System.out.println("\n 4a) top in 2006");
        System.out.println(service.getTopMovieByYear(2006));

        System.out.println("\n 4b) top in 2006 by critics preferred");
        System.out.println(service.getTopCriticPreferredMovieInYear(2006));


        System.out.println("\n 5) top in drama");
        System.out.println(service.getTopMovieByGenre(Genre.DRAMA));


        System.out.println("\n 6) top average review-score in 2006");
        System.out.println(service.getTopMovieByAverageScoreInYear(2006));

        System.out.println("\n 6) average review score in year");
        System.out.println(service.getAverageReviewScoreForYear(2006));

    }
}
