package tech.intellispaces.ixora.testcases.http.simple.testcase1;

import tech.intellispaces.ixora.http.MovableInboundHttpPort;
import tech.intellispaces.jaquarius.annotation.Factory;
import tech.intellispaces.jaquarius.object.reference.DownwardObjectFactory;

@Factory
public class SimpleHttpPortFactory implements SimpleHttpPortAssistantCustomizer {

  @Override
  public MovableSimpleHttpPortHandle create(
      DownwardObjectFactory<? extends MovableInboundHttpPort> underlyingPortHandleFactory
  ) {
    return new SimpleHttpPortImplWrapper(underlyingPortHandleFactory);
  }
}
