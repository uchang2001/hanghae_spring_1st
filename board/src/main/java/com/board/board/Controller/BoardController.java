package com.board.board.Controller;

import com.board.board.entity.board;
import com.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    @GetMapping("/write")
    public String boardwriteForm(){

        return "boardwrite";
    }
    @PostMapping("/writepro")
    public String boardwritepro(board board){
//        System.out.println(board.getTitle());
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
        Date now = new Date();
        String nowTime = sdf2.format(now);
        board.setDdate(nowTime);

        boardService.write(board);

        return"redirect:/list";
    }
    @GetMapping("/list")
    public String boardlist(Model model){
        model.addAttribute("list",boardService.boardList());

        return"boardlist";
    }
    @GetMapping("/view")
    public String boardview(Model model,Integer id){

        model.addAttribute("board",boardService.boardview(id));

        return "boardview";
    }


}
