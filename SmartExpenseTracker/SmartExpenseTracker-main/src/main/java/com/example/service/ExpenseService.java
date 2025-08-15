package com.example.service;

import com.example.model.Expense;
import com.example.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    public Expense addExpense(Expense expense) {
        return repo.save(expense);
    }

    public void deleteExpense(Long id) {
        repo.deleteById(id);
    }

    public List<Expense> filterByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Expense> filterByDateRange(String from, String to) {
        return repo.findByDateBetween(LocalDate.parse(from), LocalDate.parse(to));
    }
}