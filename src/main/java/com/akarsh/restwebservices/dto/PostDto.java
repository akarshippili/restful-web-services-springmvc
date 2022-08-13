package com.akarsh.restwebservices.dto;

public class PostDto {

    private Long id;
    private String message;
    private int likes;

    public PostDto() {
    }

    public PostDto(Long id, String message, int likes, UserDto userDto) {
        this.id = id;
        this.message = message;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", likes=" + likes +
                '}';
    }
}
