package com.interpark.sbyeol.report;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.interpark.sbyeol.report.api.board.controller.BoardController;

@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(BoardController.class)
@DisplayName("BoardController 테스트")
class ReportApplicationTests extends AbstractControllerTest {
	@Autowired
	private BoardController boardController;

	@Override
	protected Object controller() {
		// TODO Auto-generated method stub
		return boardController;
	}

	
	@Test
	public void get() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/board"));
	}

}
