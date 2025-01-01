package com.example.music.player.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Playlist {
    Long id;
    String name;
}
