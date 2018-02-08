package customer;

import java.util.Date;
import java.text.DateFormat;

public class TransactionHeader {
    String customerName;
    Date date;
    DateFormat df;

    TransactionHeader(String name) {
        this.customerName = name;
        date = new Date();
    }

    public String getCustomerName() {
        return this.customerName;
    }

    @Override
    public String toString() {
        String s = "Customer Name: " + customerName + "  Date: " + date.toString();
        return s;
    }
}
