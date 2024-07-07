package com.testdb.testDB.service;

import com.testdb.testDB.model.Transaction;
import com.testdb.testDB.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepository;

    // thông tin tất cả giao dịch
    public List<Transaction> getAllTransaction() {
        List<Transaction> list = transactionRepository.findAll();
        return list;
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction deleteTransaction(Long transactionId) {
        // Tìm giao dịch bằng ID
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        // Đảm bảo rằng transactionType không null
        if (transaction.getTransactionType() == 0) {
            throw new RuntimeException("Transaction type is not set");
        }
        // Cập nhật trạng thái của giao dịch
        transaction.setStatus("deleted");

        // Lưu lại thay đổi vào database
        transactionRepository.save(transaction);

        return transaction;
    }

    // tìm kiếm giao dịch theo ID
    public Transaction getTransactionById(Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isPresent()) {
            return optionalTransaction.get();
        } else {
            throw new EntityNotFoundException("Transaction not found with ID: " + id);
        }
    }

    // xóa tất cả giao dịch
    public void deleteAllTransactions() {
        transactionRepository.deleteAll();
        System.out.println("All transactions deleted successfully");
    }

    // thông tin chi tiết của 1 giao dịch
    public Optional<Transaction> getTransactionInfoById(long transactionId) {
        return transactionRepository.findById(transactionId);
    }

    // thống kê theo ngày, theo loại giao dịch
    // thống kê từ ngày nào đến ngày nào
    //
    public List<Transaction> getTransactionsByDate(String transaction_date) {
        return transactionRepository.findByTransactionDate(transaction_date);
    }

    public List<Transaction> getTransactionsByType(int transaction_type) {
        return transactionRepository.findByTransactionType(transaction_type);
    }
}
