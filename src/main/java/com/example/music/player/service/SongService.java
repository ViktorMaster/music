package com.example.music.player.service;

import com.example.music.player.domain.Song;
import com.example.music.player.web.dto.song.SongCreationDto;

import java.util.List;

public interface SongService {
    List<Song> getAllSongs();
    Song getSongById(Long id);
    Song createSong(SongCreationDto song);
    void deleteSongById(Long id);
}
