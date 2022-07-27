package hello.springmvc.basic.response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ResponseViewController {
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    //@ResponseBody // 리턴값이 응답 메시지로 이동
    @RequestMapping("/response-view-v2") // 추천 방식
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello"; // String 반환 : 뷰 논리 이름
        // thymleaf에 의해서 template 폴더 내의 파일을 찾음
    }

    @RequestMapping("/response/hello")
    // (controller 경로 이름 = 뷰 논리 이름) + 반환x : 해당 페이지가 논리 뷰 이름으로 불려짐
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }
}