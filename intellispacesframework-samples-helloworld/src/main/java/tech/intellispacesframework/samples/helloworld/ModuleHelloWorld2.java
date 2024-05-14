package tech.intellispacesframework.samples.helloworld;

import intellispaces.ixora.cli.ConsoleHandle;
import tech.intellispaces.ixora.commons.cli.CliUnit;
import tech.intellispacesframework.core.IntellispacesFramework;
import tech.intellispacesframework.core.annotation.Module;
import tech.intellispacesframework.core.annotation.Startup;

@Module(include = CliUnit.class)
public abstract class ModuleHelloWorld2 {

  public abstract ConsoleHandle console();

  public static void main(String[] args) {
    IntellispacesFramework.loadModule(ModuleHelloWorld2.class);
  }

  @Startup
  public void startup() {
    console().println("Hello, world!");
  }
}
