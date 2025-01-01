package com.example.music.player.service.mapper;

import com.example.music.player.data.entity.PlaylistEntity;
import com.example.music.player.domain.Playlist;
import com.example.music.player.web.dto.playlist.PlaylistCreationDto;
import com.example.music.player.web.dto.playlist.PlaylistDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    Playlist toPlaylist(PlaylistEntity playlistEntity);

    List<Playlist> toPlaylist(List<PlaylistEntity> playlistEntities);

    PlaylistEntity toPlaylistEntity(PlaylistCreationDto playlist);

    List<PlaylistDto> toPlaylistDto(List<Playlist> playlists);

    PlaylistDto toPlaylistDto(Playlist playlist);
}
