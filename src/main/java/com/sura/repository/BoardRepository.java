package com.sura.repository;

import com.sura.domain.BoardVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardVO, Long> {


}
