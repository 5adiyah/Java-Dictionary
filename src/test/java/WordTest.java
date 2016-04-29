import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word testWord = new Word("Pencil");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWord_getsUserInputedWord(){
    Word testWord = new Word("Pencil");
    String expected = "Pencil";
    assertEquals(expected, testWord.getWord());
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word firstWord = new Word("Pencil");
    Word secondWord = new Word("Pen");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void newDefinition_addsNewDefinitions_true() {
    Word testWord = new Word("Pencil");
    Definition definition = new Definition("Something to Write with");
    testWord.newDefinition(definition);
    assertTrue(testWord.getDefinitions().contains(definition));
  }

 @Test
 public void getId_wordsInstantiateWithAnId(){
   Word testWord = new Word("Pencil");
   assertEquals(Word.all().size(), testWord.getId());
 }

 @Test
 public void find_returnsWordsWithSameId(){
   Word firstWord = new Word("Pencil");
   Word secondWord = new Word("Pen");
   assertEquals(Word.find(secondWord.getId()), secondWord);
 }

 @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(999) == null);
  }

}
