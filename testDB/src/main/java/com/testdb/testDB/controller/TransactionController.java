package com.testdb.testDB.controller;

import com.testdb.testDB.dto.TransactionDTO;
import com.testdb.testDB.dto.TransactionIdDTO;
import com.testdb.testDB.model.Category;
import com.testdb.testDB.model.Transaction;
import com.testdb.testDB.model.Users;
import com.testdb.testDB.repo.CategoryRepo;
import com.testdb.testDB.repo.UserRepo;
import com.testdb.testDB.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CategoryRepo categoryRepository;

    @Autowired
    private UserRepo usersRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addTransaction(@Valid @RequestBody TransactionDTO transactionDTO, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            for (FieldError error : result.getFieldErrors()) {
                errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(". ");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }

//        Optional<Category> categoryOpt = categoryRepository.findById(transactionDTO.getCategoryId());
//        if (!categoryOpt.isPresent()) {
//            return ResponseEntity.badRequest().body("Category does not exist");
//        }
//
//        Optional<Users> userOpt = usersRepository.findById(transactionDTO.getUserId());
//        if (!userOpt.isPresent()) {
//            return ResponseEntity.badRequest().body("User does not exist");
//        }

        Transaction transaction = new Transaction();
//        transaction.setCategory(categoryOpt.get());
//        transaction.setUser(userOpt.get());
        transaction.setShop_id(transactionDTO.getShopId());
        transaction.setAmount((double) transactionDTO.getAmount());
        transaction.setTransactionType(transactionDTO.getTransactionType());
        transaction.setNote(transactionDTO.getNote());
        transaction.setTransactionDate(transactionDTO.getTransactionDate());
        transaction.setStatus("pending");

        Transaction savedTransaction = transactionService.addTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransaction());
    }

    @PostMapping("/findById")
    public ResponseEntity<Transaction> getTransactionById(@RequestBody TransactionIdDTO transactionIdDTO) {
        Long transactionId = transactionIdDTO.getTransactionId();
        Transaction transaction = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/deleteById")
    public ResponseEntity<Transaction> deleteTransaction(@RequestBody TransactionIdDTO transactionIdDTO) {
        Long transactionId = transactionIdDTO.getTransactionId();
        Transaction transaction = transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok(transaction);
    }
    // thống kê
    // tìm kiếm dựa theo ngày, loại giao dịch, số tiền
    @GetMapping("/deleteAll")
    public ResponseEntity<String> deleteAllTransactions() {
        transactionService.deleteAllTransactions();
        String message = "All transactions deleted successfully";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionInfoById(@PathVariable("id") int transactionId) {
        Optional<Transaction> transaction = transactionService.getTransactionInfoById(transactionId);
        if(transaction.isPresent()) {
            return ResponseEntity.ok(transaction.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byDate/{date}")
    public ResponseEntity<List<Transaction>> getTransactionsByDate(@PathVariable("date") String date) {
        List<Transaction> transactions = transactionService.getTransactionsByDate(date);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/byType/{type}")
    public ResponseEntity<List<Transaction>> getTransactionsByType(@PathVariable("type") int type) {
        List<Transaction> transactions = transactionService.getTransactionsByType(type);
        return ResponseEntity.ok(transactions);
    }
}


