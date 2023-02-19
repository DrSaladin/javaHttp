package cat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class Cat {
  @JsonProperty("id")
  private String id;
  @JsonProperty("text")
  private String text;
  @JsonProperty("type")
  private String type;
  @JsonProperty("user")
  private String user;
  @JsonProperty("upvotes")
  private int upvotes;

  public Cat() {}

  public String getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public String getType() {
    return type;
  }

  public String getUser() {
    return user;
  }

  public int getUpvotes() {
    return upvotes;
  }
}
