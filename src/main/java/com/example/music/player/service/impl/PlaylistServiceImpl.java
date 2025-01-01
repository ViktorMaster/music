package com.example.music.player.service.impl;

import com.example.music.player.data.entity.PlaylistEntity;
import com.example.music.player.data.entity.SongEntity;
import com.example.music.player.data.repository.PlaylistRepository;
import com.example.music.player.data.repository.SongRepository;
import com.example.music.player.domain.Playlist;
import com.example.music.player.domain.Song;
import com.example.music.player.exception.ResourceNotFoundException;
import com.example.music.player.service.PlaylistService;
import com.example.music.player.service.mapper.PlaylistMapper;
import com.example.music.player.service.mapper.SongMapper;
import com.example.music.player.web.dto.playlist.PlaylistCreationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;
    private final PlaylistMapper playlistMapper;
    private final SongMapper songMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Playlist> getAllPlaylists() {
        return playlistMapper.toPlaylist(playlistRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Playlist getPlaylistId(Long id) {
        return playlistMapper.toPlaylist(
                playlistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Playlist not found with id: " + id))
        );
    }

    @Transactional
    @Override
    public Playlist createPlaylist(PlaylistCreationDto playlist) {
        return playlistMapper.toPlaylist(
                playlistRepository.save(playlistMapper.toPlaylistEntity(playlist))
        );
    }

    @Transactional
    @Override
    public void addSongToPlaylist(Long playlistId, Long songId) {
        PlaylistEntity playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found with id: " + playlistId));
        SongEntity song = songRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id: " + songId));

        playlist.getSongs().add(song);
        playlistRepository.save(playlist);
    }

    @Transactional(readOnly = true)
    @Override
    public Set<Song> getSongsByPlaylistId(Long playlistId) {
        PlaylistEntity playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found with id: " + playlistId));
        return songMapper.toSong(playlist.getSongs());
    }
}
