package automation.model;

import java.util.ArrayList;
import java.util.List;

public class NoteModel {

    private boolean isSimple;
    private String priority;
    private String name;
    private String category;
    private List<String> categories = new ArrayList<>(1);
    private String description;


    public void createSimple(String priorityValue, String nameValue, String categoryValue) {
        isSimple = true;
        priority = priorityValue;
        name = nameValue;
        category = categoryValue;
    }

    public void createComplex(String priorityValue, String nameValue, List<String> categoriesList, String descriptionValue) {
        isSimple = false;
        priority = priorityValue;
        name = nameValue;
        categories = categoriesList;
        description = descriptionValue;
    }

    public boolean isSimple() {
        return isSimple;
    }

    public String getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getCategoriesString() {
        return String.join(", ", categories);
    }

    public String getDescription() {
        return description;
    }
}
