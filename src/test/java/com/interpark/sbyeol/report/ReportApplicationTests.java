package com.interpark.sbyeol.report;

/**
 * 게시글 CRUD 테스트 코드 작성
 * @author sbyeol91
 * @version 0.1.1
 * @since 21.10.04
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interpark.sbyeol.report.api.board.controller.BoardController;
import com.interpark.sbyeol.report.api.board.model.Board;
import com.interpark.sbyeol.report.api.board.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(BoardController.class)
@DisplayName("BoardController 테스트")
class ReportApplicationTests extends AbstractControllerTest {
	@Autowired
	private BoardController boardController;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private BoardService boardService;

	@Override
	protected Object controller() {
		// TODO Auto-generated method stub
		return boardController;
	}

	public String toJsonString(Board board) throws JsonProcessingException {
		return objectMapper.writeValueAsString(board);
	}

	/**
	 * 게시글 리스트 조회
	 * @author sbyeol91
	 */
	@Test
	void getList() throws Exception {
		List<Board> mockBoards = new ArrayList<>();

		// MockBoard
		mockBoards.add(Board.builder().contents("contents1").title("title1").seq(1L).build());
		mockBoards.add(Board.builder().contents("contents2").title("title2").seq(2L).build());

		given(boardService.getList()).willReturn(mockBoards);

		// when
		final ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/board"));

		// then
		actions
		.andDo(print())
		.andExpect(status().isOk());
	}

	/**
	 * 게시글 조회 테스트
	 * @author sbyeol91
	 */
	@Test
	void get() throws Exception {
		Board mockBoard = Board.builder().contents("contents1").title("title1").seq(1L).build();
		given(boardService.get(1L)).willReturn(mockBoard);

		// when
		final ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/board/1"));

		// then
		actions
		.andDo(print())
		.andExpect(status().isOk());
	}

	/**
	 * 게시글 등록 테스트
	 * @author sbyeol91
	 */
	@Test
	void post() throws Exception {

		// request
		Board board = Board.builder()
				.title("title1")
				.contents("contents1")
				.build();
		// when
		final ResultActions actions = mockMvc.perform(
				MockMvcRequestBuilders.post("/api/v1/board")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJsonString(board)));

		// then
		actions
		.andDo(print())
		.andExpect(status().isOk());
	}


	/**
	 * 게시글 수정 테스트
	 * @author sbyeol91
	 */
	@Test
	void put() throws Exception {

		// request
		Board board = Board.builder()
				.title("title2")
				.contents("contents2")
				.build();
		// when
		final ResultActions actions = mockMvc.perform(
				MockMvcRequestBuilders.put("/api/v1/board/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(toJsonString(board)));

		// then
		actions
		.andDo(print())
		.andExpect(status().isOk());
	}

	/**
	 * 게시글 삭제 테스트
	 * @author sbyeol91
	 */
	@Test
	void delete() throws Exception {

		// when
		final ResultActions actions = mockMvc.perform(
				MockMvcRequestBuilders.delete("/api/v1/board/1"));

		// then
		actions
		.andDo(print())
		.andExpect(status().isOk());
	}

}
