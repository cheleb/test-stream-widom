/*
 * #%L
 * Wisdom-Framework
 * %%
 * Copyright (C) 2013 - 2014 Wisdom Framework
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package sample;

import org.apache.felix.ipojo.annotations.Requires;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
import org.vertx.java.core.streams.Pump;
import org.vertx.java.core.streams.ReadStream;
import org.vertx.java.core.streams.WriteStream;
*/
import org.wisdom.api.DefaultController;
import org.wisdom.api.annotations.Controller;
import org.wisdom.api.annotations.Route;
import org.wisdom.api.annotations.View;
import org.wisdom.api.annotations.scheduler.Async;
import org.wisdom.api.bodies.RenderableStream;
import org.wisdom.api.concurrent.ManagedExecutorService;
import org.wisdom.api.http.HttpMethod;
import org.wisdom.api.http.Result;
import org.wisdom.api.templates.Template;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.Charset;


/**
 * Your first Wisdom Controller.
 */
@Controller
public class WelcomeController extends DefaultController {


    private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);

    @Requires(filter = "(name=myexecutor)", proxy = false)
    ManagedExecutorService service;

    /**
     * Injects a template named 'welcome'.
     */
    @View("welcome")
    Template welcome;


    /**
     * The action method returning the welcome page. It handles
     * HTTP GET request on the "/" URL.
     *
     * @return the welcome page
     */
    @Route(method = HttpMethod.GET, uri = "/")
    public Result welcome() {
        return ok(render(welcome, "welcome", "Welcome to Wisdom Framework!"));
    }


/*

    @Route(method = HttpMethod.GET, uri = "/raw/thread", produces = "application/xml")
    @Async
    public Result getRawThreaded() throws IOException {

        PipedOutputStream outputStream = new PipedOutputStream();

        PipedInputStream inputStream = new PipedInputStream();
        inputStream.connect(outputStream);

        new Thread() {
            @Override
            public void run() {
                writeToOutputAndClose(outputStream);
            }
        }.start();

        return ok(new RenderableStream(inputStream, false)).as("application/xml");
    }

    @Route(method = HttpMethod.GET, uri = "/raw/service", produces = "application/xml")
    @Async
    public Result getRawService() throws IOException {

        PipedOutputStream outputStream = new PipedOutputStream();

        PipedInputStream inputStream = new PipedInputStream();
        inputStream.connect(outputStream);

        service.submit(() -> {
            writeToOutputAndClose(outputStream);
        });

        return ok(new RenderableStream(inputStream, false)).as("application/xml");
    }


    @Route(method = HttpMethod.GET, uri = "/chunked/thread", produces = "application/xml")
    @Async
    public Result getChunkedThread() throws IOException {

        PipedOutputStream outputStream = new PipedOutputStream();

        PipedInputStream inputStream = new PipedInputStream();
        inputStream.connect(outputStream);

        new Thread() {
            @Override
            public void run() {
                writeToOutputAndClose(outputStream);
            }
        }.start();

        return ok(inputStream).as("application/xml");
    }

    @Route(method = HttpMethod.GET, uri = "/chunked/service", produces = "application/xml")
    public Result getChunkedService() throws IOException {

        PipedOutputStream outputStream = new PipedOutputStream();

        PipedInputStream inputStream = new PipedInputStream();
        inputStream.connect(outputStream);

        service.submit(() -> {
            writeToOutputAndClose(outputStream);
        });

        return ok(inputStream).as("application/xml");
    }

    void writeToOutputAndClose(OutputStream outputStream) {

        ReadStream<?> rs=null;
        WriteStream<?> ws=null;
        Pump.createPump(rs,ws);


        try {
            Charset utf8 = Charset.forName("UTF-8");
            outputStream.write("<root>".getBytes(utf8));
            for (int i = 0; i < 10000; i++) {
                LOGGER.debug("before write");
                outputStream.write((" <line>" + i + "</line>").getBytes(utf8));
                LOGGER.debug("after write");

                outputStream.flush();
            }
            outputStream.write("</root>".getBytes(utf8));
        } catch (IOException e) {
            logger().error(e.getMessage(), e);
        }*//* catch (InterruptedException e) {
            logger().error(e.getMessage(), e);
        }*//*
        finally {
            try {
                outputStream.flush();
                outputStream.close();
                logger().info("done");
            } catch (IOException e) {
                logger().error(e.getMessage(), e);
            }
        }
    }*/

}
