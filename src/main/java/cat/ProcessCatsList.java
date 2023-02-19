package cat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ProcessCatsList {

  public ProcessCatsList() {}

  public void showFilteredCatsList(List<Cat> catsList) {
    List<Cat> filteredCatsLis = catsList
      .stream()
      .filter(value -> value.getUpvotes() > 0)
      .toList();

    showList(filteredCatsLis);
  }

  private void showList(List<Cat> list) {
    list.forEach(cat -> System.out.printf(
      "Id: %s %n Text: %s %n Type: %s %n User: %s %n upvotes: %d %n",
      cat.getId(), cat.getText(), cat.getType(), cat.getUser(), cat.getUpvotes()));
  }

  public List<Cat> jsonResponseToList(String body) throws JsonProcessingException {
    final ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(body, new TypeReference<List<Cat>>(){});
  }
}
