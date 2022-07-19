package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


// text 형식으로 주고 받기
@WebServlet(name="requestBodyStringSubvlet", urlPatterns = "/request-body-string")
public class RequestBodyStrubgSubvlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // body -> byte code
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        // byte code -> string

        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}
