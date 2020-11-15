package com.naguib.technicalTasks.evision.entity;

public class TransactionEntity {
    private long id;
    private double transactionAmount;
    private long fromId;
    private long toId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public long getFromId() {
        return fromId;
    }

    public void setFromId(long fromId) {
        this.fromId = fromId;
    }

    public long getToId() {
        return toId;
    }

    public void setToId(long toId) {
        this.toId = toId;
    }

    public boolean isValid() {
        return id > 0 && transactionAmount > 0 && fromId > 0 && toId > 0;
    }
}
