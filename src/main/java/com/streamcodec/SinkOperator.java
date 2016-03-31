package com.streamcodec;

import com.datatorrent.api.Context.OperatorContext;
import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.api.Operator;
import com.datatorrent.api.StreamCodec;
import com.datatorrent.lib.codec.KryoSerializableStreamCodec;
import com.datatorrent.stram.codec.DefaultStatefulStreamCodec;
import com.streamcodec.RandomNumberGenerator.Complex;

public class SinkOperator implements Operator
{
  public final transient DefaultInputPort<Complex> input = new DefaultInputPort<Complex>()
  {
    @Override
    public void process(Complex tuple)
    {
    }

    @Override
    public StreamCodec<Complex> getStreamCodec()
    {
      return new DefaultStatefulStreamCodec();
    }
  };

  public final transient DefaultInputPort<Complex> input1 = new DefaultInputPort<Complex>()
  {
    @Override
    public void process(Complex tuple)
    {
    }

    @Override
    public StreamCodec<Complex> getStreamCodec()
    {
      return new DoubleStreamCodec();
    }
  };

  public final transient DefaultInputPort<Complex> input2 = new DefaultInputPort<Complex>()
  {
    @Override
    public void process(Complex tuple)
    {
    }

    @Override
    public StreamCodec<Complex> getStreamCodec()
    {
      return new KryoSerializableStreamCodec<>();
    }
  };

  @Override
  public void setup(OperatorContext cntxt)
  {
  }

  @Override
  public void beginWindow(long l)
  {
  }

  @Override
  public void endWindow()
  {
  }

  @Override
  public void teardown()
  {
  }
}
