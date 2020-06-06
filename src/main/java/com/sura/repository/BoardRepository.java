package com.sura.repository;

import com.sura.domain.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardVO, String> {

     BoardVO findByPk (Long pk);
}
