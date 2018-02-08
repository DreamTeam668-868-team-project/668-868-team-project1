package store;

import customer.CashPayment;
import customer.CheckPayment;
import customer.CreditPayment;
import customer.Payment;
import customer.TransactionItem;

import java.io.OutputStream;

public class Post {
    private ProductCatalog productCatalog;
    private ProductSpec scannedProduct;
    private double total;
    private OutputStream oStream;
    private String invoice;

    Post(ProductCatalog productCatalog) {
        total = 0;
        this.productCatalog = productCatalog;
    }

    void updateProductCatalog() {
    }

    public void scanItem(TransactionItem tItem) {
        if (validateUPC(tItem.getUPC())) {
            scannedProduct = productCatalog.getProduct(tItem.getUPC());
            updateInvoice(tItem);
        }
    }

    public void pay(Payment payment) {
        invoice += "-------\n";
        invoice += "Total: $" + total + "\n"; // needs formatting
        if (payment instanceof CashPayment) {
            invoice += "Amount Tendered: $" + ((CashPayment) payment).getAmount();
            invoice += "Amount Redturned: $" + (((CashPayment) payment).getAmount() - total);

            // check if payment can cover total, return change (if any)
        } else if (payment instanceof CheckPayment) {
            // check if amount of payment can cover bill
            invoice += "Amount Tendered: " + ((CheckPayment) payment).toString();
        } else if (payment instanceof CreditPayment) {
            // verify credit number, reject or accept vased on result
            invoice += "Amount Tendered: " + ((CreditPayment) payment).toString();
        }
    }

    public void startTransaction() {
        invoice = "";
        total = 0;
        scannedProduct = null;
    }

    boolean validateUPC(String upc) {
        return this.productCatalog.validateUPC(upc);
    }

    private void updateInvoice(TransactionItem tItem) {
        double subTotal = 0;
        String desc = scannedProduct.getDescription();
        int quantity = tItem.getQuantity();
        double price = scannedProduct.getPrice();
        subTotal = quantity * price;
        String invoiceLine = "<" + desc + "\t\t" + quantity + " @ " + price + "\t" + subTotal + ">\n";

        invoice += invoiceLine;

        // <desc      # @ price     subtotal>
        this.total += subTotal;
    }

    public void printInvoice() {
        System.out.print(invoice);
    }

    public void printTotal() {
        System.out.println("total price:" + total + "\n");
    }

    private void clearInvoic() {
        total = 0;

    }
}
