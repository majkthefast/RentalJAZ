package pl.pjatk.RentalService.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Movie", description = "Movie from DB")
public class Movie {
    @ApiModelProperty(value = "Movie id",required = true)
    private Integer id;
    @ApiModelProperty(value = "Movie title",required = true)
    private String title;
    @ApiModelProperty(value = "Movie description",required = false)
    private String description;
    @ApiModelProperty(value = "Movie genre",required = false)
    private Genres genre;
    @ApiModelProperty(value = "Is movie available",required = false)
    private Boolean isAvailable = false;


    public Movie(Integer id, String title, String description, Genres genre, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public Movie() {
    }

    public Movie(Integer id, String title, String description, Genres genre) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Enum getGenre() {
        return genre;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
