package sample;

import org.apache.felix.ipojo.annotations.Requires;
import org.wisdom.api.DefaultController;
import org.wisdom.api.annotations.Body;
import org.wisdom.api.annotations.Controller;
import org.wisdom.api.annotations.Path;
import org.wisdom.api.annotations.Route;
import org.wisdom.api.http.HttpMethod;
import org.wisdom.api.http.Result;
import spark.Repl;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * Created by cheleb on 10/07/15.
 */

@Controller
@Path("/spark")
public class SparkREPLController extends DefaultController  {



    @Requires
    private Repl repl;

/*
    @Requires
    private OSGiScriptEngineManager scriptEngineManager;
*/


    @Route(uri = "/eval", method = HttpMethod.POST)
    public Result eval(@Body String script) throws ScriptException {

        ScriptEngine scriptEngine = null;


        if(scriptEngine==null){
        }

        Object eval = repl.doIt();


        return ok(eval);
    }

}
