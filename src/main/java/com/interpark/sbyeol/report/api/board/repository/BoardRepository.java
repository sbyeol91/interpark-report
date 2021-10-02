package com.interpark.sbyeol.report.api.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interpark.sbyeol.report.api.board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
