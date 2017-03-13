package test;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineOptionsExample {

  public static void main(String[] args) {
    System.out.println("CommandLineOptionsExample.main() - SRIDHAR: 1");

    Options options = new Options().addOption("p", "port", true, "Here you can set parameter .").addOption("h", "help",
        false, "show help.");

    Option.Builder builder = Option.builder("r");
    Option r = builder.argName("r").longOpt("recursive").required().build();
    options.addOption(r);

    System.out.println("CommandLineOptionsExample.main() - SRIDHAR: 2");
    try {
      CommandLine cmd = new DefaultParser().parse(options, args);
      parse(options, cmd);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  private static void parse(Options options, CommandLine cmd) {
    String port = cmd.getOptionValue("p", "4444");
    String recursive = cmd.getOptionValue("r", "true");
    System.out.println("CommandLineOptionsExample.parse() - SRIDHAR: port = " + port);
    System.out.println("CommandLineOptionsExample.parse() - SRIDHAR: recursive = " + recursive);

    if (cmd.hasOption("h")) {
      help(options);
    }

    // if (cmd.hasOption("v")) {
    // System.err.println("Using cli argument -v=" + cmd.getOptionValue("v"));
    // // Whatever you want to do with the setting goes here
    // } else {
    // System.err.println("Missing v option");
    // help(options);
    // }
  }

  private static void help(Options options) {
    // This prints out some help
    HelpFormatter formater = new HelpFormatter();

    formater.printHelp("Main", options);
    System.exit(0);
  }
}