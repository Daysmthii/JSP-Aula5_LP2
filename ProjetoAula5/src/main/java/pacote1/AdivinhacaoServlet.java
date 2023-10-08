package pacote1;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdivinhacaoServlet")
public class AdivinhacaoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Obter a sessão
        HttpSession session = request.getSession();

        // Verificar se é o início do jogo (primeira tentativa)
        if (session.getAttribute("numeroSecreto") == null) {
            // Gerar um número secreto aleatório entre 1 e 100
            Random random = new Random();
            int numeroSecreto = random.nextInt(100) + 1;

            // Armazenar o número secreto na sessão
            session.setAttribute("numeroSecreto", numeroSecreto);

            // Inicializar o contador de palpites
            session.setAttribute("contadorPalpites", 0);
        }

        // Recuperar o número secreto da sessão
        int numeroSecreto = (int) session.getAttribute("numeroSecreto");

        // Recuperar o contador de palpites da sessão
        int contadorPalpites = (int) session.getAttribute("contadorPalpites");

        // Obter o palpite do usuário a partir dos parâmetros da solicitação
        String palpiteStr = request.getParameter("palpite");

        if (palpiteStr != null && !palpiteStr.isEmpty()) {
            int palpite = Integer.parseInt(palpiteStr);
            contadorPalpites++;

            String mensagem;

            if (palpite == numeroSecreto) {
                mensagem = "Parabéns! Você adivinhou o número correto em " + contadorPalpites + " palpites.";
                session.invalidate(); // Finalizar a sessão
            } else if (palpite < numeroSecreto) {
                mensagem = "Tente um número maior.";
            } else {
                mensagem = "Tente um número menor.";
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Jogo de Adivinhação</title>");
            out.println("<style>body{text-align: center; font-family: Times New Roman, Times, serif; background-color:#836FFF; padding-top: 7%;} h1{font-family: Times New Rooman, Times, serif; text-decoration: underline;}</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Jogo de Adivinhação</h1>");
            out.println("<p>" + mensagem + "</p>");
            out.println("<form action='/ProjetoAula5/AdivinhacaoServlet' method='get'>");
            out.println("<label for='palpite'>Faça um palpite: </label>");
            out.println("<input type='number' id='palpite' name='palpite' required>");
            out.println("<input type='submit' value='Enviar Palpite'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } else {
            // Página inicial do jogo
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Jogo de Adivinhação</title>");
            out.println("<style>body{text-align: center; font-family: Times New Roman, Times, serif; background-color:#836FFF; padding-top: 7%;} h1{font-family: Times New Rooman, Times, serif; text-decoration: underline;}</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Jogo de Adivinhação</h1>");
            out.println("<p>Tente adivinhar um número entre 1 e 100.</p>");
            out.println("<form action='/ProjetoAula5/AdivinhacaoServlet' method='get'>");
            out.println("<label for='palpite'>Faça um palpite: </label>");
            out.println("<input type='number' id='palpite' name='palpite' required>");
            out.println("<input type='submit' value='Enviar Palpite'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
