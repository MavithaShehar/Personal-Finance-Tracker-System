package lk.my_finance.my_finance.dto;

import lk.my_finance.my_finance.entity.Transaction;
import lk.my_finance.my_finance.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {

    private int id;
    private int userId;
    private String name;
    private String type;
    private Set<Transaction> transactions;
}
