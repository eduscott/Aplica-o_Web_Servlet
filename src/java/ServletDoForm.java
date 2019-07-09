import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionaContato")
public class ServletDoForm extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        String dataEmTexto = request.getParameter("dataNasc");
        Calendar dataNasc = null;
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");

        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNasc = Calendar.getInstance();
            dataNasc.setTime(date);
        } catch (ParseException e) {
            out.println("Erro na conversão da data");
            return;
        }

        Contato contato = new Contato(nome, email, endereco, dataNasc);
        
        ContatoDao dao = new ContatoDao(contato);
        dao.adiciona();
        
        out.println("Contato " + contato.getNome() + " adicionado com sucesso");        
    }       
}
