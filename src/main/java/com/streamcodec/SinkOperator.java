package com.streamcodec;

import com.datatorrent.api.Context.OperatorContext;
import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.Operator;

public class SinkOperator implements Operator
{
  public final transient DefaultInputPort<Object> input = new DefaultInputPort<Object>()
  {
    @Override
    public void process(Object tuple)
    {
    }
  };

  public final transient DefaultInputPort<Object> input1 = new DefaultInputPort<Object>()
  {
    @Override
    public void process(Object tuple)
    {
    }
  };

  public final transient DefaultInputPort<Object> input2 = new DefaultInputPort<Object>()
  {
    @Override
    public void process(Object tuple)
    {
    }
  };

  @Override
  public void beginWindow(long l)
  {
  }

  @Override
  public void endWindow()
  {
  }

  @Override
  public void setup(OperatorContext cntxt)
  {
  }

  @Override
  public void teardown()
  {
  }
}
