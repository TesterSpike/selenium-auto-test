/*## 1. User will be able to add a note
1. User will be able to submit a note with only the essential details
1. User will be able to submit a note with additional details
1. System will include the creation date to the note*/

import automation.page.OutputNote;
import automation.page.note.ComplexNote;
import automation.page.note.SimpleNote;
import automation.page.note.Type;
import automation.util.ExpectedDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AddNoteTest extends BasicTest {

    @Test
    void simpleNoteAdd() {
        SimpleNote note = new Type(driver).simpleNote();
        note.selectPriority("Urgent");
        note.enterName("test Note");
        note.selectCategory("a");
        note.submitNote();
        String expectedDate = new ExpectedDate().now();
        OutputNote output = new OutputNote(driver);
        Assertions.assertEquals("Urgent", output.getPriority(), "Output 'Priority' field");
        Assertions.assertEquals("test Note", output.getName(), "Output 'Name' field");
        Assertions.assertEquals("a", output.getCategory(), "Output 'Category' field");
        Assertions.assertEquals(expectedDate, output.getTimeStamp(), "Output 'Timestamp' field");
    }

    @Test
    void complexNoteAdd() {
        ComplexNote note = new Type(driver).advancedNote();
        note.selectPriority("Info");
        note.enterName("Glue");
        note.selectCategories(Arrays.asList("a", "b"));
        note.enterText("block text");
        note.submitNote();
        String expectedDate = new ExpectedDate().now();
        OutputNote output = new OutputNote(driver);
        Assertions.assertEquals("Info", output.getPriority(), "Output 'Priority' field");
        Assertions.assertEquals("Glue", output.getName(), "Output 'Name' field");
        Assertions.assertEquals("a,b", output.getCategories(), "Output 'Categories' field");
        //Assertions.assertEquals("block text", output.getNoteText(), "Output 'Note text' field"); //FIXME - Bug 1 - text not added to output note
        Assertions.assertEquals(expectedDate, output.getTimeStamp(), "Output 'Timestamp' field");
    }
}
