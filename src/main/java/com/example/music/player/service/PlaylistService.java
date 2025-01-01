package com.example.music.player.service;

import com.example.music.player.domain.Playlist;
import com.example.music.player.domain.Song;
import com.example.music.player.web.dto.playlist.PlaylistCreationDto;

import java.util.List;
import java.util.Set;

public interface PlaylistService {
    List<Playlist> getAllPlaylists();
    Playlist getPlaylistId(Long id);
    Playlist createPlaylist(PlaylistCreationDto playlist);
    void addSongToPlaylist(Long playlistId, Long songId);
    Set<Song> getSongsByPlaylistId(Long playlistId);
    void deletePlaylistById(Long id);
}
