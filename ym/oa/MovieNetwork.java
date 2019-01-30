//package com.amazon;

import java.util.*;


public class MovieNetwork {

    static Comparator<Movie> ratingCompare = new Comparator<Movie>() {
        public int compare(Movie a, Movie b) {
            return (a.rating - b.rating > 0 ? 1 : -1);
        }
    };

    public static List<Movie> getNearest(Movie movie, int k) {
        /*
            A priorityQueue to keep minHeap of top k rating
            Use DFS level order traverse all nodes
         */
        PriorityQueue<Movie> pQueue = new PriorityQueue<Movie>(k, ratingCompare);
        Queue<Movie> tmpMovieQueue = new LinkedList<Movie>();
        HashSet<Movie> tmpMovieHash = new HashSet<Movie>();

        for (Movie simMovie : movie.similarMovies) {
            if (!tmpMovieHash.contains(simMovie)) {
                tmpMovieQueue.offer(simMovie);
                tmpMovieHash.add(simMovie);
            }
        }

//        tmpMovieQueue.offer(movie);
//        tmpMovieHash.add(movie);
        while (!tmpMovieQueue.isEmpty()) {
            Movie oneMovie = tmpMovieQueue.poll();
            if (pQueue.size() < k) {
                pQueue.add(oneMovie);
            } else {
                if (pQueue.peek().rating < oneMovie.rating) {
                    pQueue.poll();
                    pQueue.offer(oneMovie);
                }
            }
            for (Movie similar : oneMovie.similarMovies) {
                if (!tmpMovieHash.contains(similar)) {
                    pQueue.offer(similar);
                    tmpMovieHash.add(similar);
                }
            }
        }

        List<Movie> res = new ArrayList<Movie>();
        while (!pQueue.isEmpty()) {
            res.add(pQueue.poll());
        }

        return res;
    }

    public static class Movie
    {
        int movieId;
        float rating;
        List<Movie> similarMovies;

        public Movie(int movieId, float rating, List<Movie> similarMovies){
            this.movieId = movieId;
            this.rating = rating;
            this.similarMovies = similarMovies;
        }
    }

    public static void main(String[] args){
        Movie m0 = new Movie(0, 5.5f, null);
        Movie m1 = new Movie(1, 5.1f, null);
        Movie m2 = new Movie(2, 4.8f, null);
        Movie m3 = new Movie(3, 3.2f, null);
        Movie m4 = new Movie(4, 5.4f, null);

        List<Movie> sim0 = new ArrayList<Movie>();
        List<Movie> sim1 = new ArrayList<Movie>();
        List<Movie> sim2 = new ArrayList<Movie>();
        List<Movie> sim3 = new ArrayList<Movie>();
        List<Movie> sim4 = new ArrayList<Movie>();


//        sim0.add(m1);
        sim0.add(m2);
        m0.similarMovies = sim0;

        sim1.add(m2);
        m1.similarMovies = sim1;

        sim2.add(m3);
        m2.similarMovies = sim2;

        sim3.add(m4);
        m3.similarMovies = sim3;

        List<Movie> result = getNearest(m0, 1);
        for (Movie each: result){
            System.out.println(each.movieId);
        }
    }
}