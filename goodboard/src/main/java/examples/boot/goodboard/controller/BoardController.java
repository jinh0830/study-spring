package examples.boot.goodboard.controller;

import examples.boot.goodboard.dto.BoardForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// 1. 게시물과 관련된 url요청들을 처리하는 class
// 2. url의 공통적인 앞부분을 지정하고 싶으면 클래스에 @RequestMapping을 설정한다.
@Controller
@RequestMapping("/boards")
public class BoardController {
    // 3. "/boards"라는 GET 방식 요청이 오면 실행된다.
    // 4. ModelMap에 설정한 값은 템플릿에게 값이 전달된다.
    // 5.
    @GetMapping
    public String list(ModelMap model) {
        model.addAttribute("name", "Park Jin Hyung");
        return "list";
    }

    // 6. "/boards/write" 라는 경로의 GET 요청이 실행되는 메소드
    @GetMapping(path = "/write")
    public String writeform() {
        return "writeform";
    }
    // 7. 파라미터 이름이 title, content가 전달된다.
    // 8. 컨텍스트 root를 알려면 HttpServletRequest 객체가 필요하다.
    // 9. 폼으로부터 넘어오는 값이 여러 개일 경우 하나의 객체에 저장할 수 있다.
    //    그 때는 @ModelAttribute를 사용한다.
    @PostMapping
//    public String write(@RequestParam(name = "title") String title,
//                        @RequestParam(name = "content") String content,
    public String write(@ModelAttribute BoardForm boardForm,
                        HttpServletRequest request) {

        System.out.println(boardForm.getTitle());
        System.out.println(boardForm.getContent());
        //TODO : db에 저장한다.

        return "redirect:" + request.getContextPath() + "/boards";
    }

    @GetMapping("/{boardId}")
    public String read(@PathVariable(name = "boardId")Long boardId){
        System.out.println("boardId : " + boardId);
        return "read";
    }

}
