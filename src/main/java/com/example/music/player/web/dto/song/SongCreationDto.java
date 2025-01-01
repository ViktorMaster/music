package com.example.music.player.web.dto.song;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class SongCreationDto {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    String name;

    @NotBlank(message = "URL is mandatory")
    @Size(max = 255, message = "URL cannot exceed 255 characters")
    String url;
}
