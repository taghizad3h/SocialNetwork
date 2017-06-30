package neo4j.ir.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import neo4j.ir.nodes.Genre;
import neo4j.ir.nodes.Movie;
import neo4j.ir.nodes.Person;

import java.util.List;

/**
 * Created by Ali Asghar on 29/06/2017.
 */
public class MovieDTO {
    @JsonProperty private Movie movie;
    @JsonProperty private List<Genre> genres;
    @JsonProperty private List<Person> players;
    @JsonProperty Person director;
    @JsonProperty Person writer;

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public Person getWriter() {
        return writer;
    }

    public void setWriter(Person writer) {
        this.writer = writer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Person> getPlayers() {
        return players;
    }

    public void setPlayers(List<Person> players) {
        this.players = players;
    }
}
