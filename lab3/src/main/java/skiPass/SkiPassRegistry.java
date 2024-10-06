package skiPass;

import java.util.HashMap;
import java.util.Map;

public class SkiPassRegistry {
  private Map<String, SkiPass> registry;

  public SkiPassRegistry() {
    this.registry = new HashMap<>();
  }

  public SkiPass issueSkiPass(SkiPass skiPass) {
    registry.put(skiPass.getId(), skiPass);
    return skiPass;
  }

  public void blockSkiPass(String id) {
    SkiPass skiPass = registry.get(id);
    if (skiPass != null) {
      skiPass.block();
    }
  }

  public SkiPass getSkiPass(String id) {
    return registry.get(id);
  }
}
