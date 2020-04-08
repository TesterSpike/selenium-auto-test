package steps;

import automation.SystemVariable;
import automation.model.NoteModel;
import automation.page.OutputNote;
import automation.page.note.ComplexNote;
import automation.page.note.SimpleNote;
import automation.page.note.Type;
import automation.util.ExpectedDate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class AddNoteStep extends BaseStep {
    private final NoteModel noteModel = new NoteModel();

    @Given("I am a user adding a note")
    public void IAmAUserAddingANote() {
        SystemVariable sys = new SystemVariable();
        driver.get(sys.baseUrl);
    }

    @When("I enter a simple note")
    public void IEnterASimpleNote() {
        SimpleNote note = new Type(driver).simpleNote();
        noteModel.createSimple("Urgent", "test Note", "Personal");
        note.selectPriority(noteModel.getPriority());
        note.enterName(noteModel.getName());
        note.selectCategory(noteModel.getCategory());
        note.submitNote();
    }

    @When("I enter a complex note")
    public void IEnterAComplexNote() {
        ComplexNote note = new Type(driver).advancedNote();
        noteModel.createComplex("Info", "Glue", Arrays.asList("Client", "Meeting"), "block text");
        note.selectPriority(noteModel.getPriority());
        note.enterName(noteModel.getName());
        note.selectCategories(noteModel.getCategories());
        note.enterText("block text");
        note.submitNote();
    }

    @Then("I will see that my note has been added")
    public void IWillSeeThatMyNoteHasBeenAdded() {
        String expectedDate = new ExpectedDate().now();
        OutputNote output = new OutputNote(driver);
        if (noteModel.isSimple()) {
            Assertions.assertEquals(noteModel.getPriority(), output.getPriority(), "Output 'Priority' field");
            Assertions.assertEquals(noteModel.getName(), output.getName(), "Output 'Name' field");
            Assertions.assertEquals(noteModel.getCategory(), output.getCategory(), "Output 'Category' field");
            Assertions.assertEquals(expectedDate, output.getTimeStamp(), "Output 'Timestamp' field");
        } else {
            Assertions.assertEquals(noteModel.getPriority(), output.getPriority(), "Output 'Priority' field");
            Assertions.assertEquals(noteModel.getName(), output.getName(), "Output 'Name' field");
            Assertions.assertEquals(noteModel.getCategoriesString(), output.getCategories(), "Output 'Categories' field"); //FIXED - Bug 2 - Categories not space separated
            Assertions.assertEquals(noteModel.getDescription(), output.getNoteText(), "Output 'Note text' field"); //FIXED - Bug 1 - text not added to output note
            Assertions.assertEquals(expectedDate, output.getTimeStamp(), "Output 'Timestamp' field");
        }
    }
}
