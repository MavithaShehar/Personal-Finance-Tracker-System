package lk.my_finance.my_finance.api;

import lk.my_finance.my_finance.dto.CategoryDTO;
import lk.my_finance.my_finance.service.CategoryService;
import lk.my_finance.my_finance.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public String saveCategory(@RequestBody CategoryDTO categoryDTO) {

        String req = categoryService.saveCategory(categoryDTO);
        if (req.equals("00")) {
            return req;
        }else {
            return VarList.RSP_ERROR;
        }

    }

    @PutMapping
    public String uodateCategory(@RequestBody CategoryDTO categoryDTO) {

        String req = categoryService.updateCategory(categoryDTO);
        if (req.equals("00")) {
            return req;
        }else {
            return VarList.RSP_ERROR;
        }

    }

    @GetMapping()
    public Set<CategoryDTO> getAllCategory() {
        return categoryService.getAll();
    }

    @GetMapping("/{categoryId}")
    public CategoryDTO getCategory(@PathVariable int categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable int categoryId) {
        return categoryService.deleteCategoryById(categoryId);
    }


    @GetMapping("healthCheck")
    public String getMessage() {
        return "Hello";
    }


}
