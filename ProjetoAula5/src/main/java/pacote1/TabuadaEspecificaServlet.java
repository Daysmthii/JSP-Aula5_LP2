package pacote1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tabuada")
public class TabuadaEspecificaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenha o valor enviado pelo formulário como uma string
        String numeroStr = request.getParameter("numero");

        // Verifique se o valor não está vazio e é um número
        if (numeroStr != null && !numeroStr.isEmpty()) {
            try {
                int numero = Integer.parseInt(numeroStr);

                // Defina o tipo de conteúdo da resposta como HTML
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                // Gere a tabela da tabuada
                out.println("<html>");
                out.println("<head><title>Tabuada Especifica</title>");
                out.println("<style>body{text-align:center; font-family: Times New Roman, Times, serif; background-color: #836FFF;} h1{text-decoration: underline;} h2{padding-top:7%;}</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Tabuada do " + numero + "</h2>");
                out.println("<table border='3' border-color: black align='center'>");
                for (int i = 1; i <= 10; i++) {
                    out.println("<tr><td>" + numero + " x " + i + "</td><td>" + (numero * i) + "</td></tr>");
                }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            } catch (NumberFormatException e) {
                response.getWriter().println("Por favor, insira um número válido.");
            }
        } else {
            response.getWriter().println("Por favor, insira um número.");
        }
    }
}
