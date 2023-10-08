package pacote1;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lengthcalculator")
public class LengthCalculatorStringServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenha o valor enviado pelo formulário como uma string
        String inputText = request.getParameter("inputText");

        // Calcule o comprimento da string
        int length = inputText.length();

        // Defina o tipo de conteúdo da resposta como HTML
        response.setContentType("text/html");

        // Escreva a resposta HTML
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Comprimento da String</title>");
        response.getWriter().println("<style>body{text-align: center; font-family: Times New Roman, Times, serif; background-color:#836FFF; padding-top: 7%;} h2{font-family: Times New Rooman, Times, serif; text-decoration: underline;}</style>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Comprimento da String</h2>");
        response.getWriter().println("<p>A string inserida foi: " + inputText + "</p>");
        response.getWriter().println("<p>O comprimento da string é: " + length + "</p>");

        // Crie um novo campo de entrada de texto para inserir o próximo valor
        response.getWriter().println("<form action='lengthcalculator' method='post'>");
        response.getWriter().println("Insira outra string: <input type='text' name='inputText'><br>");
        response.getWriter().println("<input type='submit' value='Calcular Comprimento'>");
        response.getWriter().println("</form>");

        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
