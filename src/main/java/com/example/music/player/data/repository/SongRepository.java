package com.example.music.player.data.repository;

import com.example.music.player.data.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {
    SongEntity findById(long id);
}
