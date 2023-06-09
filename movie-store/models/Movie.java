package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean availability;

    public Movie(String name, String format, double rating) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
        if (!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blue-Ray"))) {
            throw new IllegalArgumentException("Format must be DVD or Blue-Ray");
        }
        if (rating<0 || rating>10) {
            throw new IllegalArgumentException("Rating between 0-10");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25;
        this.rentalPrice = format.equals("Blue-Ray") ? 1.99 : 0.99;
        this.availability = true;
    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
        this.availability = source.availability;
    }

    public String getName() {
        return name;
    }
    public String getFormat() {
        return format;
    }
    public double getRating() {
        return rating;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }
    public double getRentalPrice() {
        return rentalPrice;
    }
    public boolean availability() {
        return availability;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
        this.name = name;
    }
    public void setFormat(String format) {
        if (format == null || format.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
        if (!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("Blue-Ray"))) {
            throw new IllegalArgumentException("Format must be DVD or Blue-Ray");
        }
        
        this.format = format;
        setSellingPrice(format.equals("Blue-Ray") ? 4.25 : 2.25);
        setRentalPrice(format.equals("Blue-Ray") ? 1.99 : 0.99);
    }
    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating between 0-10");
        }
        this.rating = rating;
    }
    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
        
    }
    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
        
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "\t Name: " + this.name + "\n" +

"\t Format: " + this.format + "\n" +

"\t Rating: " + this.rating + "\n" +

"\t Selling Price: " + this.sellingPrice + "\n" +

"\t Rental Price: " + this.rentalPrice + "\n" +

"\t Availability: " + (this.availability ? "in-stock" : "rented" + "\n");
    }
}
