/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dvan2301
 */
public class CheckLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Users> listUser = new ArrayList<Users>();
        listUser.add(new Users(1, "abrkid", "abc123-we"));
        listUser.add(new Users(2, "Submible", "ibn9823"));
        listUser.add(new Users(3, "Kidshowa", "Unbina123"));
        listUser.add(new Users(4, "Xonann29", "89238333"));
        listUser.add(new Users(5, "HJICKED", "CHECJKOL"));

        String u = request.getParameter("username");
        String p = request.getParameter("password");

        try {
            for (Users s : listUser) {
                if (s.getUn().equals(u) && s.getPw().equals(p)) {
                    request.getSession().setAttribute("result", "Dang Nhap Thanh Cong");
                    response.sendRedirect("result-login");
                    return;
                } else {
                    request.getSession().setAttribute("result", "Dang Nhap That Bai");
                    response.sendRedirect("result-login");
                }
            }

        } catch (Exception e) {
        }

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
