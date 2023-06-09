import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Movie;
import models.Store;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        /*
         * 
         * Movie movie = new Movie("the 11", "Blue-Ray", 9.2);
         * movie.setFormat("DVD");
         * movie.setAvailability(false);
         * System.out.println(movie);
         */

        try {
            loadMovies("movies.txt");
            System.out.println("MOVIES LOADED\n\n");
            System.out.println(store);
            manageMovies();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nProcess Complete.");
        }
    }

    /**
     * Name: manageMovies
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) purchase b) rent c)
     * return d) exit.
     * • case a: ask for the name and sell.
     * • case b: ask for the name and rent.
     * • case c: ask for the name and return.
     * • 3. call close() from the Scanner object.
     */
    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return.");
            String answer = scan.nextLine();
            if (!(answer.equals("a") || answer.equals("b") || answer.equals("c"))) {
                scan.close();
                break;
            }
            if (answer.equals("a")) {

                System.out.println("Enter the name of the movie: ");
                String name = scan.nextLine();
                if (!(store.getMovies(name).availability())) {
                    System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                    continue;
                }
                store.action(name, "sell");

                if (store.getMovies(name) == null) {
                    System.out.println("\nThe input you provided is not valid. Please try again\n");
                    continue;
                }

                System.out.println("\n\nUPDATED MOVIES\n\n" + store);
            }
            if (answer.equals("b")) {
                System.out.println("Enter the name of the movie: ");
                String name = scan.nextLine();
                if (store.getMovies(name) == null) {
                    System.out.println("\nThe input you provided is not valid. Please try again\n");
                    continue;

                }
                store.action(name, "rent");
                System.out.println("\n\nUPDATED MOVIES\n\n" + store);
            }
            if (answer.equals("c")) {
                System.out.println("Enter the name of the movie: ");
                String name = scan.nextLine();
                if (store.getMovies(name) == null) {
                    System.out.println("\nThe input you provided is not valid. Please try again\n");
                    continue;
                }
                store.action(name, "return");
                System.out.println("\n\nUPDATED MOVIES\n\n" + store);
            }

        }
    }

    /**
     * Name: loadMovies
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     *                               Inside the function:
     *                               1. loads movies from <fileName>.txt.
     *                               2. adds all movies to the store object's movie
     *                               field.
     */

    public static void loadMovies(String fileName) throws FileNotFoundException {
        File fis = new File(fileName);
        Scanner scanFis = new Scanner(fis);
        while (scanFis.hasNextLine()) {

            String line = scanFis.nextLine();
            String[] words = line.split("--");
            store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));

        }
        scanFis.close();
    }
}
