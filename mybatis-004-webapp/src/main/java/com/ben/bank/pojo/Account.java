package com.ben.bank.pojo;

/**
 * @description:
 * @author: benjieqiang
 * @date: 2023/5/6 6:31 PM
 * @version: 1.0
 */
public class Account {
    private Long id;
    private String actno;
    private Double balance;

    public Account(Long id, String actno, Double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
