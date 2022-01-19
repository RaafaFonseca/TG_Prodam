package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Conectar;

/**
 *
 * @author Tiago
 */

@WebServlet("/salvar")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = Conectar.getConnection();
		
		String imagem = request.getParameter("nome");
        
        String sql = "INSERT INTO IMAGENS (img_id, img_dt_cadastro, img_descricao)" +
		"VALUES(img_id, now(), ?);";
         
        PreparedStatement stmt = null;

		try{

			stmt = conn.prepareStatement(sql);

			stmt.setString(1,imagem);

			stmt.executeUpdate();

		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
