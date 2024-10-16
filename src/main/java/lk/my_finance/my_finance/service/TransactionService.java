package lk.my_finance.my_finance.service;

import lk.my_finance.my_finance.dto.CategoryDTO;
import lk.my_finance.my_finance.dto.TransactionDTO;
import lk.my_finance.my_finance.entity.Category;
import lk.my_finance.my_finance.entity.Transaction;
import lk.my_finance.my_finance.entity.User;
import lk.my_finance.my_finance.repo.CategoryRepo;
import lk.my_finance.my_finance.repo.TransactionRepo;
import lk.my_finance.my_finance.repo.UserRepo;
import lk.my_finance.my_finance.util.VarList;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor

public class TransactionService {

    private final ModelMapper modelMapper;
    private final TransactionRepo transactionRepo;

    public String saveTransaction(TransactionDTO transactionDTO) {

        if (transactionRepo.existsById((int) transactionDTO.getId())){
            return VarList.RSP_DUPLICATED;
        }else {
            transactionRepo.save(modelMapper.map(transactionDTO, Transaction.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateTransaction(TransactionDTO transactionDTO) {

        if (transactionRepo.existsById((int) transactionDTO.getId())){
            transactionRepo.save(modelMapper.map(transactionDTO, Transaction.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_ERROR;
        }
    }



    public List<TransactionDTO> getAllByUserId(int userId) {
        List<Transaction> transactionList = transactionRepo.findByUserId(userId);
        return transactionList.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
                .collect(Collectors.toList());
    }

    public TransactionDTO getTransactionServiceById(int trId) {
        Transaction transaction = transactionRepo.findById(trId)
                .orElseThrow(() -> new RuntimeException(VarList.RSP_NO_DATA_FOUND));
        return modelMapper.map(transaction, TransactionDTO.class);
    }

    public String deletTransactionServiceById(int trId) {
        Transaction transaction = transactionRepo.findById(trId)
                .orElseThrow(() -> new RuntimeException(VarList.RSP_NO_DATA_FOUND));

        transactionRepo.delete(transaction);
        return VarList.RSP_SUCCESS;
    }
}
