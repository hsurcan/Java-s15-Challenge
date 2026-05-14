package com.library.service;

import com.library.entity.Book;
import com.library.entity.Loan;
import com.library.entity.Member;
import com.library.entity.Receipt;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class BillingService {
    private long receiptIdCounter = 1;

    public Receipt createReceipt(Member member, Book book){
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        return new Receipt(receiptIdCounter++, member, book, book.getPrice());
    }

    public void refundReceipt(Receipt receipt){
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt cannot be null.");
        }

        if (receipt.isRefunded()) {
            throw new IllegalStateException("Receipt is already refunded.");
        }
        receipt.refund();
    }

    public double calculateFine(int lateDays){
        if (lateDays <= 0) {
            return 0;
        }

        return lateDays * 5;
    }

}
