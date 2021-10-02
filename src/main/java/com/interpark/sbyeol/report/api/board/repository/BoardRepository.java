package com.interpark.sbyeol.report.api.board.repository;

/**
* Board Repository Jpa 연결 구현체
* @author sbyeol91
* @version 0.1.1
* @since 21.10.03
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.interpark.sbyeol.report.api.board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
