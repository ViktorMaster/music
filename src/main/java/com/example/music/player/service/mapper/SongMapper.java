package com.example.music.player.service.mapper;

import com.example.music.player.data.entity.SongEntity;
import com.example.music.player.domain.Song;
import com.example.music.player.web.dto.song.SongCreationDto;
import com.example.music.player.web.dto.song.SongDto;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface SongMapper {
    Song toSong(SongEntity songEntity);

    List<Song> toSong(List<SongEntity> songEntities);

    Set<Song> toSong(Set<SongEntity> songEntities);

    SongEntity toSongEntity(SongCreationDto song);

    Set<SongDto> toSongDto(Set<Song> songs);

    List<SongDto> toSongDto(List<Song> songs);

    SongDto toSongDto(Song songs);
}
