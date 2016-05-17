
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.rules.ExternalResource;
import org.sql2o.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("My Dictionary");
  }
  @Test
  public void dictionary() {
    goTo("http://localhost:4567/");
    click("a", withText("My Dictionary"));
    assertThat(pageSource()).contains("All Words");
  }

  @Test
  public void newWord() {
    goTo("http://localhost:4567/");
    click("a", withText("My Dictionary"));
    click("a", withText("New Word"));
    assertThat(pageSource()).contains("Word");
  }

  @Test
  public void words() {
    goTo("http://localhost:4567/");
    click("a", withText("My Dictionary"));
    click("a", withText("New Word"));
    fill("#word").with("Hello");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved");
  }

  @Test
  public void word() {
    goTo("http://localhost:4567/");
    click("a", withText("My Dictionary"));
    click("a", withText("New Word"));
    fill("#word").with("yo");
    submit(".btn");
    click("a", withText("My Dictionary"));
    click("a", withText("yo"));
    assertThat(pageSource()).contains("yo");
  }



}
