package models;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovies(int index) {

        return new Movie(movies.get(index));
    }

    public Movie getMovies(String name) {
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)) {
                return new Movie(this.movies.get(i));
            }
        }
        return null;
    }

    public void setMovies(int index, Movie movie) {
        movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String movieName, String action) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("movie is empty");
        }
        if (!(action.equals("sell") || (action.equals("rent") || (action.equals("return"))))) {
            throw new IllegalStateException("must be sell, rent or return");
        }
        if (movieName == null || movieName.isBlank()) {
            throw new IllegalStateException("name is null or blank");
        }

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(movieName)) {
                switch (action) {
                    case "sell":
                        if (!(movies.get(i).availability())) {
                            throw new IllegalStateException("movie is sold and cannot be rented");
                        }
                        movies.remove(i);
                        break;
                    case "rent":
                        movies.get(i).setAvailability(false);
                        break;
                    case "return":
                        movies.get(i).setAvailability(true);
                }

                /*
                 * if (action.equals("sell")) {
                 * movies.remove(i);
                 * }
                 * if (action.equals("rent")) {
                 * movies.get(i).setAvailability(false);
                 * }
                 * if (action.equals("return")) {
                 * movies.get(i).setAvailability(true);
                 * }
                 */
            }
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < movies.size(); i++) {
            temp += movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}
