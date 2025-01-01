package com.example.music.player.data.repository;

import com.example.music.player.data.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {
    PlaylistEntity findById(long id);
}
