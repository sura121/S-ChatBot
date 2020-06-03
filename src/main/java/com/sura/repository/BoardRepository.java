package com.sura.repository;

import com.sura.domain.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardVO, Long> {


}
