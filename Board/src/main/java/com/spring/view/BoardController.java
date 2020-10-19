package com.spring.view;

import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.biz.BoardService;
import com.spring.biz.vo.BoardVO;

@Controller
public class BoardController {
	//메모리에 boardService인 이름을 갖고있어? 있으면 정보를 service에 넣어줘. AutoWired랑 달리 이름을 보기땜문에(이름)필수
	@Resource(name = "boardService")
	BoardService service;
	
	//게시판 리스트 - String Ajaxs쓰기 전까지는 100%
	@RequestMapping(value = "/boardList.do")
	public String selectBoardList(BoardVO boardVO, Model model) {
		List<BoardVO> list = service.selectBoardList(boardVO);
		model.addAttribute("list", list);
		//WEB-INF/view/boardList.jsp
		return "boardList";
	}
	//글쓰기 양식
	@RequestMapping(value = "/boardWrite.do", method = RequestMethod.GET)
	public String boardWriteForm() {
		return "boardWriteForm";
	}
	//글등록(객체생성 안하고 자동으로 넣어준다.) 강한 결합을 없애기위해서 new 키워드를 잘안씀, 선언만 하면됨
	@RequestMapping(value = "/boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(BoardVO boardVO) {
		
		//쿼리실행
		service.insertBoard(boardVO);
		//WEB-INF//view/boardList.do.jsp
		return "redirect:boardList.do";
	}
	
	/*
	 * //상세보기
	 * 
	 * @RequestMapping(value = "/boardDetail.do") 
	 * public String boardDetail(@ModelAttribute("abc")BoardVO boardVO, Model model) { 
	 * BoardVO vo = service.selectBoard(boardVO);
	 * model.addAttribute("vo", vo); 
	 * return "boardDetail"; //WEB-INF/view/boardDetail.jsp 자동으로 앞에 붙여줌 }
	 */
	
	//상세보기 @요청파라메터(title이름의 값을 String title이 받겠습니다.)(초기값 aaa로 넣을께요)(얘가 true가 되면 무조건 받아야됨 아니면 오류남 그래서 false받아도되고 아니어도되고)
	@RequestMapping(value = "/boardDetail.do")
	public String boardDetail(@RequestParam(value="title", defaultValue = "aaa", required = false) String title, Model model) {
		BoardVO vo = service.selectBoard2(title);
		model.addAttribute("vo", vo);
		return "boardDetail"; //WEB-INF/view/boardDetail.jsp 자동으로 앞에 붙여줌
	}
	//게시글 삭제
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(String boardTitle) {
		service.deleteBoard(boardTitle);
		return "redirect:boardList.do"; //WEB-INF/view/boardDetail.jsp 자동으로 앞에 붙여줌
	}
	//게시글 수정 폼
	@RequestMapping(value = "/updateBoardForm.do")
	public String updateBoardForm(String boardTitle, Model model) {
		BoardVO vo = service.selectBoard2(boardTitle);
		//쿼리실행
		model.addAttribute("vo", vo);
		//WEB-INF//view/boardList.do.jsp
		return "updateBoardForm";
	}

	//게시글 수정
	@RequestMapping(value = "/boardUpdate.do")
	public String boardUpdate(BoardVO boardVO, Model model) throws Exception{
		
		//쿼리실행
		service.boardUpdate(boardVO);
		model.addAttribute("title", boardVO.getBoardTitle());
		//인코딩
		String title = URLEncoder.encode(boardVO.getBoardTitle(), "UTF-8");
		return "redirect:boardList.do?title=" + title;
		/* return "redirect:boardList.do"; */
	}
	
	//테스트용
		@RequestMapping(value = "/testpage.do")
		public String testpage() {
			return "testpage";
		}
	

}
