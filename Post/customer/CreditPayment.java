/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

/**
 *
 * @author Travis
 */
public class CreditPayment extends Payment {

    public CreditPayment(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return "Credit Card " + this.creditCardNumber;
    }

    private String creditCardNumber;
}
