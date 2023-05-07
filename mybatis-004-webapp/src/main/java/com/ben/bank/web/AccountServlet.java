package com.ben.bank.web;

import com.ben.bank.exceptions.MoneyNotEnoughException;
import com.ben.bank.exceptions.TransferNotSuccessException;
import com.ben.bank.service.AccountService;
import com.ben.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 表现层写一个AccountServlet类继承HttpServlet，重写doPost方法
 * @author: benjieqiang
 * @date: 2023/5/7 9:24 AM
 * @version: 1.0
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受前端传递的参数：转出账户，转入账户，转账金额；
        String fromActno = req.getParameter("fromActno");
        String toActno = req.getParameter("toActno");
        Double money = Double.parseDouble(req.getParameter("money"));

        System.out.println(fromActno + toActno + money);
        //调用业务层代码完成转账的逻辑；层与层之间用接口来衔接，所以在service层新建AccountService接口，新建一个转账方法
        //使用AccountServiceImpl实现类，实现转账方法
        try {
            accountService.transfer(fromActno,toActno,money);
            resp.sendRedirect(req.getContextPath()+"/success.html");
        } catch (MoneyNotEnoughException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/money-not-enough.html");
        } catch (TransferNotSuccessException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath()+"/transfer-error.html");
        }
    }
}
