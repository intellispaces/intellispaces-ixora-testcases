package intellispaces.samples.rdb.query;

import intellispaces.framework.core.IntellispacesFramework;
import intellispaces.framework.core.annotation.Inject;
import intellispaces.framework.core.annotation.Module;
import intellispaces.framework.core.annotation.Startup;
import intellispaces.ixora.cli.CliConfiguration;
import intellispaces.ixora.cli.Console;
import intellispaces.ixora.hikary.HikariConfiguration;
import intellispaces.ixora.rdb.RdbConfiguration;
import intellispaces.ixora.rdb.ResultSet;
import intellispaces.ixora.rdb.Transaction;
import intellispaces.ixora.rdb.Transactions;
import intellispaces.ixora.rdb.annotation.Transactional;
import intellispaces.ixora.snakeyaml.SnakeyamlGuide;
import intellispaces.ixora.structures.association.IxoraPropertiesToDataGuide;

@Module(units = {
    CliConfiguration.class,
    RdbConfiguration.class,
    HikariConfiguration.class,
    SnakeyamlGuide.class,
    IxoraPropertiesToDataGuide.class
})
public abstract class QueryBookCountSample3 {

  /**
   * This method will be invoked automatically after the module is started.<p/>
   *
   * The values of method arguments will be injected automatically.
   *
   * @param console value of the projection named 'console'.
   */
  @Startup
  @Transactional
  public void startup(@Inject Console console) {
    Transaction tx = Transactions.current();
    ResultSet rs = tx.query(QuerySql.BOOK_COUNT);
    rs.next();
    console.print("Number books: ");
    console.println(rs.integerValue("count"));
  }

  /**
   * In the main method, we load and run the IntelliSpaces framework module.
   */
  public static void main(String[] args) {
    IntellispacesFramework.loadModule(QueryBookCountSample3.class, args);
  }
}
