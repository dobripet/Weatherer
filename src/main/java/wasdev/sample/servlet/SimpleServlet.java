package wasdev.sample.servlet;

import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechModel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SpeechToText service = new SpeechToText("b4d5e338-b5d2-4b91-bc50-67a4f73e2349", "om4MLqXIVcj0");
    private String token = service.getToken().execute();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print(token);
        System.out.println("Token: " + token);
    }
    /*
    private void synchronousCall() {
        ServiceCall call = service.getModels();
        List<SpeechModel> models = (List<SpeechModel>) call.execute();
    }

    private void asynchronousCall() {
        ServiceCall call = service.getModels();
        call.enqueue(new ServiceCallback<List<SpeechModel>>() {
            @Override
            public void onResponse(List<SpeechModel> models) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    */
}
