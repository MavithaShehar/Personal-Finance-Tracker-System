package lk.my_finance.my_finance.dto;

import jakarta.persistence.*;
import lk.my_finance.my_finance.entity.Category;
import lk.my_finance.my_finance.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class TransactionDTO {

    private long id;
    private User user;
    private Category category;
    private Double amount;
    private Date date;
    private String description;

}
