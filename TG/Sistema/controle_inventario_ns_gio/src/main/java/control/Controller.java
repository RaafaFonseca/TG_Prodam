package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import control.commando.*;
import control.viewhelper.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.dominio.EntidadeDominio;
import util.Resultado;

/**
 *
 * @author Tiago
 */
@WebServlet(urlPatterns = {"/Imagem", "/Programa"})
public class Controller extends HttpServlet {
    
    private static Map<String, ICommand> commands;
    private static Map<String, IViewHelper> vhs;
    
    public Controller(){
        
        commands = new HashMap<String, ICommand>();
        
        commands.put("Salvar", new SalvarCommand());
        commands.put("Alterar", new AlterarCommand());  
        commands.put("Excluir", new ExcluirCommand());
        commands.put("Consultar", new ConsultarCommand());
        
        vhs = new HashMap<String, IViewHelper>();
        
        vhs.put("/controle_inventario_ns_gio/Imagem", new VhImagem());
        vhs.put("/controle_inventario_ns_gio/Programa", new VhPrograma());
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        request.setCharacterEncoding("UTF-8");

        String           uri = request.getRequestURI();
        IViewHelper      vh = vhs.get(uri);
        EntidadeDominio  entidade = vh.getEntidade(request);
        String           operacao = request.getParameter("operacao");
        ICommand         command = commands.get(operacao);
        Resultado        resultado = command.executar(entidade);
        
        vh.setView(resultado, request, response);
           
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
