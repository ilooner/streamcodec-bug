package com.streamcodec;

import com.datatorrent.api.Context.OperatorContext;
import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.Operator;
import com.datatorrent.api.StreamCodec;
import com.datatorrent.lib.codec.KryoSerializableStreamCodec;

public class SinkOperator implements Operator
{
  public final transient DefaultInputPort<Double> input = new DefaultInputPort<Double>()
  {
    @Override
    public void process(Double tuple)
    {
    }
  };

  public final transient DefaultInputPort<Double> input1 = new DefaultInputPort<Double>()
  {
    @Override
    public void process(Double tuple)
    {
    }

    @Override
    public StreamCodec<Double> getStreamCodec()
    {
      return new DoubleStreamCodec();
    }
  };

  public final transient DefaultInputPort<Double> input2 = new DefaultInputPort<Double>()
  {
    @Override
    public void process(Double tuple)
    {
    }

    @Override
    public StreamCodec<Double> getStreamCodec()
    {
      return new KryoSerializableStreamCodec<>();
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
