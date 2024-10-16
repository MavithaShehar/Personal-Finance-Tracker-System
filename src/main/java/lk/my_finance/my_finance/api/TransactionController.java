package lk.my_finance.my_finance.api;


import lk.my_finance.my_finance.dto.CategoryDTO;
import lk.my_finance.my_finance.dto.TransactionDTO;
import lk.my_finance.my_finance.service.TransactionService;
import lk.my_finance.my_finance.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public String saveTransaction(@RequestBody TransactionDTO transactionDTO) {

        String req = transactionService.saveTransaction(transactionDTO);
        if (req.equals("00")) {
            return req;
        }else {
            return VarList.RSP_ERROR;
        }

    }

    @PutMapping
    public String updateTransaction(@RequestBody TransactionDTO transactionDTO) {

        String req = transactionService.updateTransaction(transactionDTO);
        if (req.equals("00")) {
            return req;
        }else {
            return VarList.RSP_ERROR;
        }

    }

    @GetMapping("/user/{userId}")
    public List<TransactionDTO> getAllByUserId(@PathVariable int userId) {
        return transactionService.getAllByUserId(userId);
    }

    @GetMapping("/{trId}")
    public TransactionDTO getCategory(@PathVariable int trId) {
        return transactionService.getTransactionServiceById(trId);
    }

    @DeleteMapping("/{trId}")
    public String deleteCategory(@PathVariable int trId) {
        return transactionService.deletTransactionServiceById(trId);
    }

    @GetMapping("healthCheck")
    public String getMessage() {
        return "Hello";
    }
}
