package com.example.music.player.web.controller;

import com.example.music.player.data.entity.PlaylistEntity;
import com.example.music.player.data.entity.SongEntity;
import com.example.music.player.service.PlaylistService;
import com.example.music.player.service.mapper.PlaylistMapper;
import com.example.music.player.service.mapper.SongMapper;
import com.example.music.player.web.dto.playlist.PlaylistCreationDto;
import com.example.music.player.web.dto.playlist.PlaylistDto;
import com.example.music.player.web.dto.song.SongDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/playlists")
@AllArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;
    private final PlaylistMapper playlistMapper;
    private final SongMapper songMapper;

    @GetMapping
    public ResponseEntity<List<PlaylistDto>> getPlaylists() {
        return ResponseEntity.ok(playlistMapper.toPlaylistDto(playlistService.getAllPlaylists()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDto> getPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(playlistMapper.toPlaylistDto(playlistService.getPlaylistId(id)));
    }

    @PostMapping
    public ResponseEntity<PlaylistDto> createPlaylist(@RequestBody @Valid PlaylistCreationDto playlistCreationDto) {
        return new ResponseEntity<>(playlistMapper.toPlaylistDto(playlistService.createPlaylist(playlistCreationDto)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/songs")
    public ResponseEntity<Set<SongDto>> getSongs(@PathVariable Long id) {
        return ResponseEntity.ok(songMapper.toSongDto(playlistService.getSongsByPlaylistId(id)));
    }

    @PostMapping("/{playlistId}/songs/{songId}")
    public void addSong(@PathVariable Long playlistId, @PathVariable Long songId) {
        playlistService.addSongToPlaylist(playlistId, songId);
    }
}
