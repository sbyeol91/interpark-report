package com.interpark.sbyeol.report.api.board.controller;

import com.interpark.sbyeol.report.api.board.model.Board;
import com.interpark.sbyeol.report.config.ReportConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Board CRUD API", description = "게시글 조회, 입력, 수정, 삭제 API")
@RequestMapping(path = ReportConst.VER_PATH)
public interface BoardController {
    static final String RESOURCE = "board";

    @GetMapping(path = RESOURCE)
    @ApiOperation("게시글 리스트 조회 API")
    @ResponseBody List<Board> getList();

    @GetMapping(path = RESOURCE + "/{seq}")
    @ApiOperation("게시글 조회 API")
    @ApiImplicitParams({@ApiImplicitParam(name = "seq", value = "게시글 SEQ")})
    @ResponseBody Board get(@PathVariable Long seq);

    @PostMapping(path = RESOURCE)
    @ApiOperation("게시글 등록 API")
    ResponseEntity<?> post(@RequestBody Board request);

    @PutMapping(path = RESOURCE + "/{seq}")
    @ApiOperation("게시글 수정 API")
    @ApiImplicitParams({@ApiImplicitParam(name = "seq", value = "게시글 SEQ")})
    ResponseEntity<?> put(@PathVariable Long seq, @RequestBody Board request);

    @DeleteMapping(path = RESOURCE + "/{seq}")
    @ApiOperation("게시글 삭제 API")
    @ApiImplicitParams({@ApiImplicitParam(name = "seq", value = "게시글 SEQ")})
    ResponseEntity<?> delete(@PathVariable Long seq, @RequestBody Board request);

}
