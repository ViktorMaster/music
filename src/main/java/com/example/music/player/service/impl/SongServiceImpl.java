package com.example.music.player.service.impl;

import com.example.music.player.data.entity.SongEntity;
import com.example.music.player.data.repository.SongRepository;
import com.example.music.player.domain.Song;
import com.example.music.player.exception.ResourceNotFoundException;
import com.example.music.player.service.SongService;
import com.example.music.player.service.mapper.SongMapper;
import com.example.music.player.web.dto.song.SongCreationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Transactional
    @Override
    public List<Song> getAllSongs() {
        return songMapper.toSong(songRepository.findAll());
    }

    @Transactional
    @Override
    public Song getSongById(Long id) {
        return songMapper.toSong(songRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Song not found with id: " + id)));
    }

    @Transactional
    @Override
    public Song createSong(SongCreationDto song) {
        return songMapper.toSong(songRepository.save(songMapper.toSongEntity(song)));
    }

    @Transactional
    @Override
    public void deleteSongById(Long id) {
        songRepository.deleteById(id);
    }
}
