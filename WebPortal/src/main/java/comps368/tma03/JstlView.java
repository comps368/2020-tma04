/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.tma03;

import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 *
 * @author Cyrus Cheng
 */
public class JstlView extends InternalResourceView {
    
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        exposeModelAsRequestAttributes(model, request);

        String dispatcherPath = prepareForRendering(request, response);
        response.addHeader("Content-Type", "text/html;charset=UTF-8");
        request.setAttribute("content", dispatcherPath);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/template/layout.jsp");
        if (requestDispatcher != null) {
            requestDispatcher.include(request, response);
        }
    }
    
}