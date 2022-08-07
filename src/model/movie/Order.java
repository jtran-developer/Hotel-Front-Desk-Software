package model.movie;

import java.util.ArrayList;

public class Order {

	ArrayList<Movie> movies;

	/**
	 * @param movies
	 */
	public Order(ArrayList<Movie> movies) {
		this.movies = movies;
	}

	/**
	 * @return the movies
	 */
	public ArrayList<Movie> getMovies() {
		return movies;
	}

	/**
	 * @param movies the movies to set
	 */
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
}
