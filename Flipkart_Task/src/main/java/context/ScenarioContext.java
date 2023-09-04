package context;

import java.util.HashMap;
import java.util.Map;
/* This class is created to achieve the sharing of the data between the different steps of the 
   scenario  */
public class ScenarioContext {
	private  Map<String, String> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(String key, String value) {
        scenarioContext.put(key.toString(), value);
    }

    public String getContext(String key){
        return scenarioContext.get(key.toString());
    }

    public Boolean hasKey(String key){
        return scenarioContext.containsKey(key);
    }
    public Boolean hasValue(String value){
        return scenarioContext.containsValue(value);
    }
}
