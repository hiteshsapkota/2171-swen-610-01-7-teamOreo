package com.webcheckers;

import com.webcheckers.appl.GameCenter;
import java.util.logging.Logger;

import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import com.webcheckers.ui.WebServer;


/**
 * The entry point for the WebCheckers web application.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
final class Application {
  private static final Logger LOG = Logger.getLogger(Application.class.getName());

  //
  // Application Launch method
  //

  /**
   * Entry point for the WebCheckers web application.
   *
   * <p>
   * It wires the application components together.  This is an example
   * of <a href='https://en.wikipedia.org/wiki/Dependency_injection'>Dependency Injection</a>
   * </p>
   *
   * @param args
   *    Command line arguments; none expected.
   */
  public static void main(String[] args) {

    WebServer webServer = webServer();
	// inject web server into application
    final Application app = new Application(webServer);

    // start the application up
    app.initialize();
  }

private static WebServer webServer() {
	final TemplateEngine templateEngine = new FreeMarkerEngine();
	final GameCenter gameCenter = new GameCenter();
	final WebServer webServer = new WebServer(gameCenter, templateEngine);
	return webServer;
}

  //
  // Attributes
  //

  private final WebServer webServer;

  //
  // Constructor
  //

  private Application(final WebServer webServer) {
    this.webServer = webServer;
  }

  //
  // Private methods
  //

  private void initialize() {
    LOG.fine("WebCheckers is initializing.");

    // configure Spark and startup the Jetty web server
    webServer.initialize();

    // other applications might have additional services to configure

    LOG.fine("WebCheckers initialization complete.");
  }

}