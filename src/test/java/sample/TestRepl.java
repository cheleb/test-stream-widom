package sample;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by cheleb on 10/07/15.
 */
public class TestRepl {

    public static void main(String[] args) throws ScriptException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("scala");
        Object eval = scriptEngine.eval("1 + 1");
        System.out.println(eval);
        
        System.getProperties().entrySet().stream().forEach((e)->System.out.println(e));
        
    }

}
