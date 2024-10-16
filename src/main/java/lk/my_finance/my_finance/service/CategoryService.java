package lk.my_finance.my_finance.service;

import lk.my_finance.my_finance.dto.CategoryDTO;
import lk.my_finance.my_finance.entity.Category;
import lk.my_finance.my_finance.entity.User;
import lk.my_finance.my_finance.repo.CategoryRepo;
import lk.my_finance.my_finance.repo.UserRepo;
import lk.my_finance.my_finance.util.VarList;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor

public class CategoryService {

    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    public String saveCategory(CategoryDTO categoryDTO) {

        Optional<User> userOptional = userRepo.findById(categoryDTO.getUserId());

        if (userOptional.isEmpty()) {
            return VarList.RSP_NO_DATA_FOUND;
        } else {
            User user = userOptional.get();
            Category category = new Category();
            category.setName(categoryDTO.getName());
            category.setType(categoryDTO.getType());
            category.setUser(user);

            categoryRepo.save(category);

            return VarList.RSP_SUCCESS;
        }
    }

    public String updateCategory(CategoryDTO categoryDTO) {

        Optional<Category> categoryOptional = categoryRepo.findById(categoryDTO.getId());

        if (categoryOptional.isPresent()) {
            Category existingCategory = categoryOptional.get();

            Optional<User> userOptional = userRepo.findById(categoryDTO.getUserId());
            if (userOptional.isEmpty()) {
                return VarList.RSP_NO_DATA_FOUND;
            }

            User user = userOptional.get();


            existingCategory.setName(categoryDTO.getName());
            existingCategory.setType(categoryDTO.getType());
            existingCategory.setUser(user);

            categoryRepo.save(existingCategory);
            return VarList.RSP_SUCCESS;

        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }


    public Set<CategoryDTO> getAll() {
        List<Category> categoriesList = categoryRepo.findAll();
        return new HashSet<>(modelMapper.map(categoriesList, new TypeToken<List<CategoryDTO>>() {}.getType()));
    }

    public CategoryDTO getCategoryById(int categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException(VarList.RSP_NO_DATA_FOUND));
        return modelMapper.map(category, CategoryDTO.class);
    }

    public String deleteCategoryById(int categoryId) {
        // Find the category by ID
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException(VarList.RSP_NO_DATA_FOUND));

        // Delete the category
        categoryRepo.delete(category);

        // Return a success response
        return VarList.RSP_SUCCESS;
    }



}
