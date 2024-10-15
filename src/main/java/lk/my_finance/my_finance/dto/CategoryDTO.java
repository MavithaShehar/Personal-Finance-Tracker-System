package lk.my_finance.my_finance.dto;

import jakarta.persistence.*;
import lk.my_finance.my_finance.entity.Transaction;
import lk.my_finance.my_finance.entity.User;

import java.util.Set;

public class CategoryDTO {

    private long id;
    private User user;
    private String name;
    private String type;
    private Set<Transaction> transactions;
}
