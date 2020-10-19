package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.vo.BoardVO;

//BoardService boardService = new BoardServiceImpl(); 을 아래와같이 사용. 
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	//@Autowired를 적으면 new 안해줘도 알아서 만들어줌. SqlSessionTemplate만들어져 있는 개체를 sqlSession에 넣어줌(자동으로 넣어줌),bean(클래스)으로 만들어줌 applicationContext파일안에
	//()안되있는 이유는 자료형을 봄 SqlSessionTemplate라는 자료형 (이름 신경안쓰고 자료형이 같으면 넣어줌)
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertBoard(BoardVO boardVO) {
		int result = sqlSession.insert("insertBoard", boardVO);
		return result;
	}

	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) {
		return sqlSession.selectList("selectBoardList", boardVO);
	}

	@Override
	public BoardVO selectBoard(BoardVO boardVO) {
		return sqlSession.selectOne("selectBoard", boardVO);
	}

	@Override
	public BoardVO selectBoard2(String boardTitle) {
		return sqlSession.selectOne("selectBoard2", boardTitle);
	}

	@Override
	public int deleteBoard(String boardTitle) {
		return sqlSession.delete("deleteBoard", boardTitle);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) {
		int result = sqlSession.update("boardUpdate", boardVO);
		return result;
	}


	
}
