package com.example.music.player.web.controller;

import com.example.music.player.data.entity.SongEntity;
import com.example.music.player.service.SongService;
import com.example.music.player.service.mapper.SongMapper;
import com.example.music.player.web.dto.song.SongCreationDto;
import com.example.music.player.web.dto.song.SongDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@AllArgsConstructor
public class SongController {
    private final SongService songService;
    private final SongMapper songMapper;

    @GetMapping
    public ResponseEntity<List<SongDto>> getSongs() {
        return ResponseEntity.ok(songMapper.toSongDto(songService.getAllSongs()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDto> getSong(@PathVariable Long id) {
        return ResponseEntity.ok(songMapper.toSongDto(songService.getSongById(id)));
    }

    @PostMapping
    public ResponseEntity<SongDto> createSong(@RequestBody @Valid SongCreationDto songCreationDto) {
        return new ResponseEntity<>(songMapper.toSongDto(songService.createSong(songCreationDto)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        songService.deleteSongById(id);
        return ResponseEntity.noContent().build();
    }
}
