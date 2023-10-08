package pacote1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Obter valores do formulário
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        // Verificar as credenciais (neste exemplo, login="admin" e senha="password")
        if ("adm".equals(login) && "password".equals(senha)) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Formulário de Login</title>");
            out.println("<style>body{text-align:center; font-family: Times New Roman, Times, serif; background-color: #836FFF;} h1{font-family: Times New Rooman, Times, serif; text-decoration: underline;}</style>");
            out.println("<head>");
            out.println("<body>");
            out.println("<h1>Login bem-sucedido!</h1>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h1>Login falhou. Verifique o nome de login e senha.</h1>");
            out.println("</body></html>");
        }
    }
}

