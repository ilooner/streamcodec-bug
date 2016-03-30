package com.streamcodec;

import com.datatorrent.api.Context.OperatorContext;
import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.Operator;
import com.datatorrent.api.StreamCodec;
import com.datatorrent.lib.codec.KryoSerializableStreamCodec;

public class SinkOperator implements Operator
{
  public final transient DefaultInputPort<Object> input = new DefaultInputPort<Object>()
  {
    @Override
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public void process(Object t)
    {
    }

    @Override
    public StreamCodec<Object> getStreamCodec()
    {
      return new KryoSerializableStreamCodec();
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
