package com.example.music.player.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Song {
    Long id;
    String name;
    String url;
}
