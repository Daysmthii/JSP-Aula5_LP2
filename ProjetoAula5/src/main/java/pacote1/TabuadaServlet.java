package pacote1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TabuadaServlet")
public class TabuadaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Tabuada</title>");
        out.println("<style>body{text-align:center; font-family: Times New Roman, Times, serif; background-color: #836FFF;} h1{text-decoration: underline;}</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Tabuada de Multiplicação de 1 a 9</h1>");
        out.println("<table border='3' border-color: black align='center'>");
        out.println("<tr>");
        out.println("<th>Número</th>");
        out.println("<th>Tabuada</th>");
        out.println("</tr>");

        for (int num = 1; num <= 9; num++) {
            out.println("<tr>");
            out.println("<td>" + num + "</td>");
            out.println("<td>");
            for (int mult = 1; mult <= 10; mult++) {
                int result = num * mult;
                out.println(num + " x " + mult + " = " + result + "<br>");
            }
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
